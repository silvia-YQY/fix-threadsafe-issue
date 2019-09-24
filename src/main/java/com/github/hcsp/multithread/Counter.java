package com.github.hcsp.multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int value = 0;
    Lock calculator = new ReentrantLock();

    public int getValue() {
        calculator.lock();
        try {
            return value;
        } finally {
            calculator.unlock();
        }
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        calculator.lock();
        try {
            value += i;
            return value;
        } finally {
            calculator.unlock();
        }
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        calculator.lock();
        try {
            value -= i;
            return value;
        } finally {
            calculator.unlock();

        }
    }
}
