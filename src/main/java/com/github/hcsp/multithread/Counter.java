package com.github.hcsp.multithread;

public class Counter {
    private int value = 0;

//    1. synchronized方式
    // 加上一个整数i，并返回加之后的结果

    public int getValue() {
        return value;
    }

    public synchronized int addAndGet(int i) {
        value += i;
        return value;
    }

    // 减去一个整数i，并返回减之后的结果
    public synchronized int minusAndGet(int i) {
        value -= i;
        return value;
    }


//  2.AtomicInteger 方式
//
//    private AtomicInteger value = new AtomicInteger(0);
//
//    public int getValue() {
//        return value.intValue();
//    }
//
//    // 加上一个整数i，并返回加之后的结果
//    public int addAndGet(int i) {
//        value.addAndGet(i);
//        return value.intValue();
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public int minusAndGet(int i) {
//        value.addAndGet(-i);
//        return value.intValue();
//    }


//    3.ReentrantLock方式
//    ReentrantLock lock = new ReentrantLock();
//
//    public int getValue() {
//        return value;
//    }
//
//    // 加上一个整数i，并返回加之后的结果
//    public int addAndGet(int i) {
//        lock.lock();
//        try {
//            value += i;
//        } finally {
//            lock.unlock();
//        }
//        return value;
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public int minusAndGet(int i) {
//        lock.lock();
//        try {
//            value -= i;
//        } finally {
//            lock.unlock();
//        }
//
//        return value;
//    }

}
