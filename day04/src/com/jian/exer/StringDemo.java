package com.jian.exer;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @author Jiange
 * @create 2021-03-11-13:01
 */
public class StringDemo {
    @Test
    public void test1() throws UnsupportedEncodingException {
        String s1 = "123abc";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.replace('1','2'));
        System.out.println(s1.replace("jian","ge"));
        System.out.println(s1.replaceFirst("\\|","jian"));
        System.out.println(s1.replaceAll("\\d+","5"));
        System.out.println(s1.indexOf('1'));
        System.out.println(s1.indexOf('1',2));
        System.out.println(s1.lastIndexOf('1',5));
        System.out.println(s1.toCharArray());
        System.out.println(s1.getBytes("utf-8"));
        System.out.println(s1.split("i",2));
    }
    @Test
    public void test2(){
        StringBuilder s2 = new StringBuilder(20);
        s2.append(1);
        s2.append(234);
        System.out.println(s2.length());
        s2.insert(1,2.3);
        System.out.println(s2.toString());
        System.out.println(s2.length());//7
        System.out.println(s2.replace(0,1,"0"));
        System.out.println(s2.charAt(0));
//        System.out.println(s2.setCharAt(0,'1'));
        s2.setCharAt(0,'1');
        System.out.println(s2.indexOf("1",0));
        System.out.println(s2.lastIndexOf("1",s2.length()));
        System.out.println(s2.substring(1));
        System.out.println(s2.delete(0,1));
        System.out.println();
    }
    public String reverse(@NotNull String str){
        char[] chars = str.toCharArray();
        int length = chars.length;
        char[] chars1 = new char[length];
        for (int i = 0; i < str.length(); i++) {
            chars1[length-1-i] = chars[i];
        }
        return new String(chars1);
    }
    public String reverse(@NotNull String str,int start){
        char[] chars = str.toCharArray();
        int length = chars.length;
        char[] chars1 = new char[length];
        for (int i = 0; i < length; i++) {
            if(i<start){
                chars1[i] = chars[i];
            }else {
                chars1[length-1-i+start] = chars[i];
            }
        }
        return new String(chars1);
    }
    public String reverse(@NotNull String str,int start,int end){
        char[] chars = str.toCharArray();
        int length = chars.length;
        char[] chars1 = new char[length];
        for (int i = 0; i < length; i++) {
            if(i<start||i>=end){
                chars1[i] = chars[i];
            }else {
                chars1[end-1-i+start] = chars[i];
            }
        }
        return new String(chars1);
    }
    @Test
    public void test3(){
        String s1 = "123abc";
        System.out.println(reverse(s1));
        System.out.println(reverse(s1,1));
        System.out.println(reverse(s1,1,3));
    }
}
