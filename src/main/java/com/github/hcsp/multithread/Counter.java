package com.github.hcsp.multithread;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private static AtomicInteger atomicInteger = new AtomicInteger();

    public int getValue() {
        return atomicInteger.get();
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        return atomicInteger.addAndGet(i);
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        return atomicInteger.addAndGet(-i);
    }
}
