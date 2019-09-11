package com.github.hcsp.multithread;

import java.util.concurrent.atomic.AtomicInteger;

// public class Counter {
//     private int value = 0;
//     Object lock = new Object();
//
//     public int getValue() {
//         return value;
//     }
//
//     // 加上一个整数i，并返回加之后的结果
//     public int addAndGet(int i) {
//         synchronized (lock) {
//             value += i;
//             return value;
//         }
//     }
//
//     // 减去一个整数i，并返回减之后的结果
//     public int minusAndGet(int i) {
//         synchronized (lock) {
//             value -= i;
//             return value;
//         }
//     }
// }
// public class Counter {
//     private int value = 0;
//     private Lock reentrantLock = new ReentrantLock();
//
//     public int getValue() {
//         return value;
//     }
//
//     // 加上一个整数i，并返回加之后的结果
//     public int addAndGet(int i) {
//         reentrantLock.lock();
//         try {
//             value += i;
//             return value;
//         } finally {
//             reentrantLock.unlock();
//         }
//     }
//
//     // 减去一个整数i，并返回减之后的结果
//     public int minusAndGet(int i) {
//         reentrantLock.lock();
//         try {
//             value -= i;
//             return value;
//         } finally {
//             reentrantLock.unlock();
//         }
//     }
// }

public class Counter {
    private int value = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        return atomicInteger.addAndGet(i);
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        return atomicInteger.get() - i;
    }
}
