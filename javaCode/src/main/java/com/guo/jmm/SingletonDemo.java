package com.guo.jmm;

public class SingletonDemo {

    private volatile static SingletonDemo instance=null;

    private SingletonDemo()
    {
        System.out.println(Thread.currentThread().getName()+"\t 我是构造方法SingletonDemo()");
    }

    //DCL(双端检锁机制)
    public static SingletonDemo getInstance(){
        if (instance==null){
            synchronized (SingletonDemo.class){
                if(instance==null)
                {
                    instance=new SingletonDemo();
                }
            }
        }
        return  instance;
    }

    public static void main(String[] args) {
//        System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());

        for (int i = 1; i <=10; i++) {
            new Thread(()->{
                SingletonDemo.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
