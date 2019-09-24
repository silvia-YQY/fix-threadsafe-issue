package com.github.hcsp.multithread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int value = 0;
    private static Object lock = new Object();
    private static ReentrantLock reentrantLock = new ReentrantLock();
    public static AtomicInteger count = new AtomicInteger(0);
    public int getValue() {
        return value;
    }

    /**
     *  方法一 ：给所在方法加上 synchronized 关键字
     * @param i
     * @return
     */
    // 加上一个整数i，并返回加之后的结果
    public synchronized int addAndGet1(int i) {
        value += i;
        return value;
    }

    // 减去一个整数i，并返回减之后的结果
    public synchronized int minusAndGet1(int i) {
        value -= i;
        return value;
    }

    /**
     *  方法二：使用 Object 当作锁 synchronized(lock)
     *  lock
     *      可以是 Counter 内部定义的成员变量 lock
     *      也可以直接用 this
     * @param i
     * @return
     */
    public int addAndGet2(int i) {
        synchronized (lock){
            value += i;
            return value;
        }

    }

    public int minusAndGet2(int i) {
        synchronized (lock){
            value -= i;
            return value;
        }
    }

    /**
     *  方法三：使用 java.util.concurrent.locks.Lock 接口的实现类 ReentrantLock 可重入锁
     * @param i
     * @return
     */
    public int addAndGet3(int i) {
        reentrantLock.lock();
        try{
            value += i;
            return value;
        }finally {
            reentrantLock.unlock();
        }
    }

    public int minusAndGet3(int i) {
        reentrantLock.lock();
        try{
            value -= i;
            return value;
        }finally {
            reentrantLock.unlock();
        }
    }

    //

    /**
     *  方法四：使用 AtomicInteger
     * @param i
     * @return
     */
    public int addAndGet(int i) {
        return count.addAndGet(i);
    }

    public int minusAndGet(int i) {
        return count.addAndGet(-i);
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        for (int i = 0; i < 1000; i++) {

            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter.addAndGet2(2);
                System.out.println("add 2:" + counter.getValue());
            }).start();

            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter.minusAndGet2(2);
                System.out.println("minus 2:" + counter.getValue());
            }).start();
        }
    }

}
