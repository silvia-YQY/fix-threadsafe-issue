package com.github.hcsp.multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Counter {
    private int value = 0;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public int getValue() {
        readLock.lock();
        try {
            return value;
        } finally {
            readLock.unlock();
        }
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        writeLock.lock();
        try {
            value += i;
            return value;
        } finally {
            writeLock.unlock();
        }
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        writeLock.lock();
        try {
            value -= i;
            return value;
        } finally {
            writeLock.unlock();
        }
    }
}
