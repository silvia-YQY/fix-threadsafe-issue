package com.github.hcsp.multithread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * First method to solve this problem
 * Use ReentrantLock
 */

public class Counter {

    private final ReentrantLock lock = new ReentrantLock();
    private int value = 0;

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        lock.lock();
        try {
            value += i;
            return value;
        } finally {
            lock.unlock();
        }
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        lock.lock();
        try {
            value -= i;
            return value;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Counter1 counter = new Counter1();
        for (int i = 0; i < 100; i++) {
            counter.addAndGet(2);
            counter.minusAndGet(2);
        }
        System.out.println(counter.value);
    }
}
