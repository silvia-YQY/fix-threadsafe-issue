package com.github.hcsp.multithread;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private int value = 0;
    private static Object lock = new Object();
    private static AtomicInteger atomicInteger=new AtomicInteger();

    public  synchronized int getValue() {
        return value;

    }
    // 加上一个整数i，并返回加之后的结果
    public synchronized int  addAndGet(int i) {
        value += i;
        return value;

    }

    // 减去一个整数i，并返回减之后的结果
    public  synchronized int minusAndGet(int i) {
        value -= i;
        return value;
    }
    public int getValue1() {
        synchronized (lock) {
            return value;
        }
    }
    public  int  addAndGet1(int i) {
        synchronized (lock) {
            value += i;
            System.out.println(value);
            return value;
        }
    }
    public   int minusAndGet1(int i) {
        synchronized (lock) {
            value -= i;
            System.out.println(value);
            return value;

        }
    }
    public  int minusAndGet2(int i){
        int b=atomicInteger.addAndGet(-i);
        System.out.println(b);
        return b;
    }



    public static void main(String[] args) {
        Counter counter=new Counter();
        for (int i=0;i<100;i++){
      //  new Thread(String.valueOf(counter.minusAndGet1(50))).start();
        new Thread(String.valueOf(counter.minusAndGet2(222))).start();
    } }
}
