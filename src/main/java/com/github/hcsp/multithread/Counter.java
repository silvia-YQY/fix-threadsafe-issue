package com.github.hcsp.multithread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Counter {
    private int value = 0;
    BlockingQueue<Integer> queue = new LinkedBlockingDeque<>();

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) throws InterruptedException {
        queue.add(i + 1);
        return queue.take();
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) throws InterruptedException {
        queue.add(i - 1);
        return queue.take();
    }
}
