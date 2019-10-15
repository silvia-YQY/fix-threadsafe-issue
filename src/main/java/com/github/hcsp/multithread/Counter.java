package com.github.hcsp.multithread;

// 方法1 使用 synchronized

public class Counter {
    private int value = 0;

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public synchronized int addAndGet(int i) {
        value += i;
        return value;
    }

    // 减去一个整数i，并返回减之后的结果
    public synchronized int minusAndGet(int i) {
        value -= i;
        return value;
    }
}

// 方法2 使用 java.util.concurrent.locks.lock

//import java.util.concurrent.locks.ReentrantLock;
//
//public class Counter {
//    private int value = 0;
//    private final ReentrantLock lock = new ReentrantLock();
//
//    public int getValue() {
//        return value;
//    }
//
//    // 加上一个整数i，并返回加之后的结果
//    public int addAndGet(int i) {
//        lock.lock();
//        value += i;
//        lock.unlock();
//        return value;
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public int minusAndGet(int i) {
//        lock.lock();
//        value -= i;
//        lock.unlock();
//        return value;
//    }
//}

// 方法3 使用 AtomicInteger

//import java.util.concurrent.atomic.AtomicInteger;
//
//public class Counter {
//    private AtomicInteger atomicInteger = new AtomicInteger();
//
//    public int getValue() {
//        return atomicInteger.get();
//    }
//
//    // 加上一个整数i，并返回加之后的结果
//    public int addAndGet(int i) {
//        return atomicInteger.addAndGet(i);
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public  int minusAndGet(int i) {
//        return atomicInteger.addAndGet(-i);
//    }
//}
