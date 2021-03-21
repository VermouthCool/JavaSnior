package com.jian.exer;

/**
 * @author Jiange
 * @create 2021-03-10-12:41
 */
public class StringTest {
    String str = new String("good");
    char[] ch = new char[]{'1','2','3'};
    public void change(String a,char[] b){
        a = "ge";
        b[0] = '2';
    }

    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
        stringTest.change(stringTest.str,stringTest.ch);
        System.out.println(stringTest.str);//good
        System.out.println(stringTest.ch);//223
    }
}
