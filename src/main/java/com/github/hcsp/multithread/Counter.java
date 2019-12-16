package com.github.hcsp.multithread;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private int value = 0;
    AtomicInteger integer = new AtomicInteger();

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) throws InterruptedException {
        return integer.addAndGet(i + 1);
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) throws InterruptedException {
        return integer.addAndGet(i - 1);
    }
}
