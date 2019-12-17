package com.github.hcsp.multithread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

public class Counter {
//    private int value = 0;
    AtomicInteger value = new AtomicInteger(0);

    public int getValue() {
        return value.get();
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) throws InterruptedException {
        return value.addAndGet(i);
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) throws InterruptedException {
        return value.updateAndGet(new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return operand-i;
            }
        });
    }
}
