package com.github.hcsp.multithread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int value = 0;
    private static Object lock = new Object();
    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static AtomicInteger count = new AtomicInteger(0);

    // 非  AtomicInteger 方式使用
    /*
    public int getValue() {
        return value;
    }
    */

    public int getValue() {
        return count.get();
    }

    //方法一 ：给所在方法加上 synchronized 关键字
    public synchronized int addAndGet1(int i) {
        value += i;
        return value;
    }

    public synchronized int minusAndGet1(int i) {
        value -= i;
        return value;
    }

    /*
    * 方法二：使用 Object 当作锁 synchronized(lock)
    * lock
    * 可以是 Counter 内部定义的成员变量 lock
    * 也可以直接用 this
    */
    public int addAndGet2(int i) {
        synchronized (lock) {
            value += i;
            return value;
        }

    }

    public int minusAndGet2(int i) {
        synchronized (lock) {
            value -= i;
            return value;
        }
    }

    // 方法三：使用 java.util.concurrent.locks.Lock 接口的实现类 ReentrantLock 可重入锁
    public int addAndGet3(int i) {
        reentrantLock.lock();
        try {
            value += i;
            return value;
        } finally {
            reentrantLock.unlock();
        }
    }

    public int minusAndGet3(int i) {
        reentrantLock.lock();
        try {
            value -= i;
            return value;
        } finally {
            reentrantLock.unlock();
        }
    }

    // 方法四：使用 AtomicInteger
    public int addAndGet(int i) {
        return count.addAndGet(i);
    }

    public int minusAndGet(int i) {
        return count.addAndGet(-i);
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        AtomicInteger count = new AtomicInteger(0);
        System.out.println(count.addAndGet(2));
        for (int i = 0; i < 1000; i++) {

            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter.addAndGet(2);
                System.out.println("add 2:" + counter.getValue());
            }).start();

            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter.minusAndGet(2);
                System.out.println("minus 2:" + counter.getValue());
            }).start();
        }
    }

}
