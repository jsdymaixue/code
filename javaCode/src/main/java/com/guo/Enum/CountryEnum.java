package com.guo.Enum;

import lombok.Getter;

public enum CountryEnum {
    one(1,"齐"),two(2,"楚") ,three(3,"燕"),four(4,"赵"),five(5,"魏"),six(6,"韩");

    @Getter private int code;
    @Getter private String msg;

    CountryEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static CountryEnum foreach_Country(int index){
        CountryEnum[] array=CountryEnum.values();
        for (CountryEnum element:array) {
            if (index==element.getCode())
            {
                return element;
            }
        }
        return null;

    }
}
