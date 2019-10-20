package com.github.hcsp.multithread;

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

//import java.util.concurrent.atomic.AtomicInteger;
//
//public class Counter {
//    private AtomicInteger count = new AtomicInteger(0);
//
//    public int getValue() {
//        return count.get();
//    }
//
//    // 加上一个整数i，并返回加之后的结果
//    public int addAndGet(int i) {
//        return count.addAndGet(i);
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public int minusAndGet(int i) {
//        return count.addAndGet(-i);
//    }
//}


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    Lock l = new ReentrantLock();
    private int value = 0;

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        l.lock();
        value += i;
        l.unlock();
        return value;
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        l.lock();
        value -= i;
        l.unlock();
        return value;
    }
}
