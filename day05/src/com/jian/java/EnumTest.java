package com.jian.java;

/**
 * @author Jiange
 * @create 2021-03-12-15:06
 * 方式一：JDK5.0 之前
 * 方式二：JDK8.0之后
 */
class Season{
    private final String name;
    private final String Desc;

    private Season(String name,String Desc){
        this.name = name;
        this.Desc = Desc;
    }

    public static final Season SRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","寒冬腊月");

    public String getName() {
        return name;
    }

    public String getDesc() {
        return Desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", Desc='" + Desc + '\'' +
                '}';
    }
}
public class EnumTest {
    public static void main(String[] args) {
        Season sring = Season.SRING;
        Season season = Season.SRING;
        System.out.println(sring);
        System.out.println(season == sring);//true
        final String a = "jian";
        final int b = 1;
        String c = "jian1";
        System.out.println(a+b == c);//true
    }
}
