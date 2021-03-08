package com.guo.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatileDemo
 */
public class VolatileDemo {

    static class MyDate{
        volatile int number=0;

        public void add()
        {
            number++;
        }

        AtomicInteger atomicInteger=new AtomicInteger();

        public  void addAtomic() {
             atomicInteger.getAndIncrement();
        }
    }


    public static void main(String[] args) {
        MyDate myDate=new MyDate();
        for (int i = 1; i <=20 ; i++) {
            new Thread(()->{
                for (int j = 1; j <=1000; j++) {
                    myDate.add();
                    myDate.addAtomic();
                }
            },String.valueOf(i)).start();
        }
        while (Thread.activeCount()>2)
        {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t int type  number value: "+ myDate.number);
        System.out.println(Thread.currentThread().getName()+"\t atomicInteger type number value: "+ myDate.atomicInteger);
    }
}
