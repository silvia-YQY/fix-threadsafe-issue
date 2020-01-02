package com.github.hcsp.multithread;

import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int value = 0;
    private ReentrantLock lock = new ReentrantLock();

    int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    void addAndGet(int i) {
        lock.lock();
        try {
            value += i;
        } finally {
            lock.unlock();
        }
    }

    // 减去一个整数i，并返回减之后的结果
    void minusAndGet(int i) {
        lock.lock();
        try {
            value -= i;
        } finally {
            lock.unlock();
        }
    }
}

