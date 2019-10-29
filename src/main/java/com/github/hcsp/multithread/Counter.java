package com.github.hcsp.multithread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int value = 0;
    private final Lock lock = new ReentrantLock();
    AtomicInteger a = new AtomicInteger(0);

    public int getValue() {
        return value;
    }

    /**
     * 加上一个整数i，并返回加之后的结果
     *
     * @param i 所加大小
     * @return 加后得到的值
     */
//    public synchronized int addAndGet(int i) {
//        value += i;
//        return value;
//    }

//    public int addAndGet(int i) {
//        lock.lock();
//        value += i;
//        lock.unlock();
//        return value;
//    }
    public int addAndGet(int i) {
        return a.addAndGet(i);
    }

    /**
     * 减去一个整数i，并返回减之后的结果
     *
     * @param i 所减大小
     * @return 减后的大小
     */
//    public synchronized int minusAndGet(int i) {
//        value -= i;
//        return value;
//    }

//    public int minusAndGet(int i) {
//        lock.lock();
//        value -= i;
//        lock.unlock();
//        return value;
//    }
    public int minusAndGet(int i) {
        return a.addAndGet(-i);
    }


}
