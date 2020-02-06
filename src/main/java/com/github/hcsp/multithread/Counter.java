package com.github.hcsp.multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
//    第一种方法AtomicInteger
//    private AtomicInteger value =new AtomicInteger();
//
//    public int getValue() {
//        return value.get();
//    }
//
//    // 加上一个整数i，并返回加之后的结果
//    public void addAndGet(int i) {
//        value .addAndGet(i);
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public void minusAndGet(int i) {
//        value.addAndGet(-i);
//    }


//    第二种方法使用synchronized
//    private int value =0;
//
//    public int getValue() {
//        return value;
//    }
//
//    // 加上一个整数i，并返回加之后的结果
//    public synchronized void addAndGet(int i) {
//        value +=i;
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public synchronized void minusAndGet(int i) {
//        value-=i;
//    }



//    第二种方法使用Lock
    private int value = 0;
    Lock lock = new ReentrantLock();

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public synchronized void addAndGet(int i) {
        lock.lock();
        value += i;
        lock.unlock();
    }

    // 减去一个整数i，并返回减之后的结果
    public synchronized void minusAndGet(int i) {
        lock.lock();
        value -= i;
        lock.unlock();
    }
}
