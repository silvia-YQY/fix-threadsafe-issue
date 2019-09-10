package com.github.hcsp.multithread;

public class Counter {
//    private AtomicInteger value = new AtomicInteger(0);
//
//    public int getValue() {
//        return value.intValue();
//    }
//
//    // 加上一个整数i，并返回加之后的结果
//    public void addAndGet(int i) {
//        value.addAndGet(i);
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public void minusAndGet(int i) {
//        value.addAndGet(-i);
//    }


    private int value = 0;

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public synchronized void addAndGet(int i) {
        value += 1;
    }

    // 减去一个整数i，并返回减之后的结果
    public synchronized void minusAndGet(int i) {
        value -= 1;
    }
}
