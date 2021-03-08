package com.guo.jmm;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 集合类不安全问题
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {

        Map<String,String> map=new ConcurrentHashMap<>();
        for (int i = 1; i <30 ; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
        /**
         * java.util.ConcurrentModificationException 故障现象
         *
         * 解决方案
         * new Vector<>();
         * Collections.synchronizedList(new ArrayList<>());
         * new CopyOnWriteArrayList<>();
         */
    }

    private static void setNotSafe() {
        Set<String> set=new HashSet<>();
        for (int i = 1; i <30 ; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }

    public void listNotSafe(){

        List<String> list= new CopyOnWriteArrayList<>();
        for (int i = 1; i <30 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
