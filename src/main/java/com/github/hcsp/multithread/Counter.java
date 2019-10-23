package com.github.hcsp.multithread;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private static Lock lock=new ReentrantLock();
    private static int value;

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        lock.lock();
        try {
            value +=i;
            return value;
        }finally {
            lock.unlock();
        }
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        lock.lock();
        try{
            value -=i;
            return value;
        }finally {
            lock.unlock();
        }
    }
}
