package com.guo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 比较并交换
 * CAS==compareAndSet 比较期望值和真实值（主内存的值）相同，并修改
 */
public class CASDemo {

    public static void main(String[] args) {

        AtomicInteger atomicInteger=new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5,2019)+"/t"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5,2010)+"/t"+atomicInteger.get());
    }
}
