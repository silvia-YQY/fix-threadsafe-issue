package com.github.hcsp.multithread;

import java.util.concurrent.atomic.AtomicInteger;
//import java.util.concurrent.locks.ReentrantLock;

//方法一：给所有方法加上synchronized
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



//方法二：JUC:ReentrantLock
//public class Counter {
//    private static int value = 0;
//    ReentrantLock lock = new ReentrantLock();
//    public int getValue() {
//        return value;
//    }
//
//    // 加上一个整数i，并返回加之后的结果
//    public  int addAndGet(int i) {
//        lock.lock();
//        value += i;
//        return value;
//    }
//    // 减去一个整数i，并返回减之后的结果
//    public  int minusAndGet(int i) {
//        value -= i;
//        lock.unlock();
//        return value;
//    }
//}

//方法三：AtomicIntger
public class Counter {
    private static AtomicInteger value = new AtomicInteger(0);

    public int getValue() {
        return value.intValue();
    }

    // 加上一个整数i，并返回加之后的结果
    public  int addAndGet(int i) {
        return value.addAndGet(i);
    }

    // 减去一个整数i，并返回减之后的结果
    public  int minusAndGet(int i) {
        return value.addAndGet(-i);
    }
}
