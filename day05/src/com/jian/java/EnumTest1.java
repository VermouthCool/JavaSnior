package com.jian.java;

import java.util.Arrays;

/**
 * @author Jiange
 * @create 2021-03-12-15:35
 * enum 定义的枚举类默认继承于Java.lang.Enum类
 *  常用方法
 *  实现接口
 */
interface jian{
    void show();
}
public enum EnumTest1 implements jian {
    //提供多个对象，之间用，隔开 最后用分号结尾
    SPRING("春天","很暖"),
    SUMMER("夏天","喜欢");
    private final String name;
    private final String Desc;

    EnumTest1(String name, String desc) {
        this.name = name;
        Desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return Desc;
    }

    @Override
    public void show() {
        System.out.println("EnumTest1.show");
    }
}
class Test1{
    public static void main(String[] args) {
        System.out.println(EnumTest1.SPRING.toString());//SPRING
        EnumTest1[] values = EnumTest1.values();
        System.out.println(Arrays.toString(values));//[SPRING, SUMMER]
        EnumTest1 spring = EnumTest1.valueOf("SPRING"); //没写对会报错 非法
        System.out.println(spring);
        spring.show();
    }
}
