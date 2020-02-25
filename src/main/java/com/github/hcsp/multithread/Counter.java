package com.github.hcsp.multithread;

// synchronized
//public class Counter {
//    private int value = 0;
//
//    public int getValue() {
//        return value;
//    }
//
//    // 加上一个整数i，并返回加之后的结果
//    public synchronized int addAndGet(int i) {
//        value += i;
//        return value;
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public synchronized int minusAndGet(int i) {
//        value -= i;
//        return value;
//    }
//}

import java.util.concurrent.atomic.AtomicInteger;

// AtomicInteger
public class Counter {
    private AtomicInteger value = new AtomicInteger(0);

    public int getValue() {
        return value.intValue();
    }

    // 加上一个整数i，并返回加之后的结果
    public synchronized int addAndGet(int i) {
        return value.addAndGet(i);
    }

    // 减去一个整数i，并返回减之后的结果
    public synchronized int minusAndGet(int i) {
        return value.addAndGet(-i);
    }
}

//import java.util.concurrent.locks.ReentrantLock;

// ReentrantLock
//public class Counter {
//    private int value = 0;
//    ReentrantLock lock = new ReentrantLock();
//
//    public int getValue() {
//        return value;
//    }
//
//    // 加上一个整数i，并返回加之后的结果
//    public synchronized int addAndGet(int i) {
//        value += i;
//        lock.lock();
//        return value;
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public synchronized int minusAndGet(int i) {
//        value -= i;
//        lock.unlock();
//        return value;
//    }
//}
