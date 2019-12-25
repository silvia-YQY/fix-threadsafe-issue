package com.github.hcsp.multithread;


import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    private static AtomicInteger value = new AtomicInteger(0);

    int getValue() {
        return value.intValue();
    }

    // 加上一个整数i，并返回加之后的结果
    int addAndGet(int i) {

        return value.addAndGet(i);
    }

    // 减去一个整数i，并返回减之后的结果
    int minusAndGet(int i) {
        return value.addAndGet(-i);
    }
}
