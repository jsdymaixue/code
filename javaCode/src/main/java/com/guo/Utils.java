package com.guo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Utils {
    public static void  printValur(String str){
        System.out.println("print value : "+str);
    }

    public static void main(String[] args) {

          int number=0;
        System.out.println("----------------普通的写法-----------------------");
        List<String> al = Arrays.asList("a","b","c","d");
        for (String a: al) {
            Utils.printValur(a);
        }
        System.out.println("----------------JDK双冒号--------------------------");
        //JDK8中有双冒号的用法，就是把方法当做参数传到stream内部，使stream的每个元素都传入到该方法里面执行一下
        Consumer<String> stringConsumer = Utils::printValur;
        System.out.println("----------------方式1--------------------------");
        al.forEach(stringConsumer);
        System.out.println("----------------方式2--------------------------");
        al.forEach(x -> stringConsumer.accept(x));
        System.out.println("----------------方式3--------------------------");
        al.forEach(Utils::printValur);
    }
}
