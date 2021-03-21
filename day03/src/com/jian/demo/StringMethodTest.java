package com.jian.demo;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author Jiange
 * @create 2021-03-10-13:19
 */
public class StringMethodTest {
    /*
    int length():返回字符串的长度 return value.length;
    char charAt(int index): return value[index]
    boole):判断是否是空字符串 return value.length ==0
    toLowerCase、toUan isEmpty(pperCase()不会改变原来的字符串
    trim()去除字符串首尾的空格、中间的不删、不会改变原来的字符串
    equalsIgnoreCase()忽略大小写比较内容
    concat()等价于用+
    int compareTo(String str) 负数表示前者小 0 为相等、前面的相等前者的长度大返回的就是长度差
    String substring(index，end)从index位置开始截取 本身的不会改变,包括开始不包括结束
    boolean startsWith (String prefix,？int toffset) 测试指定的位置是否以这个字符串开头 包括这个位置
    boolean endsWith(String prefix)
    boolean container()  判断该字符串是否包含某个字串
    int indexOf(str,?index) 返回字串第一次出现的索引  没找到 返回-1；包括index
    int lastIndexOf(str,?index)返回index以前的最后一次出现的位置  包括index
    replace(char old,char newch)；返回一个新的串下 将所有的匹配到的
    replace(charSequence target,charSequence replacement)
    replace(String str,String replacement)
    replaceAll(String regex,String replacement)
    replaceFirst(String regex,String replacement)只修改第一个
    matches(regex)测试字符串是否匹配；
    split(regex,limit) 拆分为String[],最多不超过limit 超过就都放在最后一个元素里
    * */

    @Test
    public void test9() throws UnsupportedEncodingException {
        String s1 = "123abc";
        System.out.println(s1.length());
        System.out.println(s1.charAt(2));
        System.out.println(s1.isEmpty());
        System.out.println(s1.toLowerCase());
        System.out.println(s1.toUpperCase());
        System.out.println(s1.trim());
        System.out.println(s1.equalsIgnoreCase("123abc"));
        System.out.println(s1.concat("123"));
        System.out.println(s1.compareTo("123abcd"));
        System.out.println(s1.substring(0,2));//12
        System.out.println(s1.substring(1));
        System.out.println(s1.startsWith("12",1));
        System.out.println(s1.startsWith("12"));
        System.out.println(s1.endsWith("abc"));
        System.out.println(s1.contains("123"));
        System.out.println(s1.indexOf("12"));
        System.out.println(s1.indexOf(1));
        System.out.println(s1.indexOf("1",0));
        System.out.println(s1.lastIndexOf('1'));
        System.out.println(s1.lastIndexOf("123",2));
        System.out.println(s1.replace("123","1"));
        System.out.println(s1.replace('1','2'));
        System.out.println(s1.replaceAll("\\d+","jiange"));
        System.out.println(s1.replaceFirst("123","56789"));
        System.out.println(s1.matches("\\d+"));
        System.out.println(s1.split("\\|",2));
        System.out.println(new Object());
        System.out.println(s1);

        char[] chars = new char[]{'1','2','3'};
        String s2 = new String(chars);
        System.out.println(s2.toCharArray());
        System.out.println(s2);

        String s3 = "123456789中国";
        byte[] bytes = s3.getBytes("utf-8");
        System.out.println(Arrays.toString(bytes));
        System.out.println(new String(bytes));

    }

    @Test
    public void test(){
        String s1 = "HellowOrld";
        System.out.println(s1.length());//10
        System.out.println(s1.charAt(5));//w
//        s1="";
        System.out.println(s1.isEmpty());//false
        String s2 = s1.toLowerCase();
        System.out.println(s1.toUpperCase());
        System.out.println(s1);//HellowOrld
        System.out.println(s2);//helloworld
        String s3 = "  t  es t   ";
        System.out.println(s3.trim());
        System.out.println(s3);
    }
    @Test
    public void test1(){
        String s1 = "HeLLowoRld";
        String s2 = "helloworld";
        System.out.println(s1.equalsIgnoreCase(s2));//true
        String s3 = s1.concat(s2);
        System.out.println(s3);//HeLLowoRldhelloworld
        System.out.println("HeLLowoRldhelloworld"==s3);//false
        String s4 = "abcd";
        String s5 = "abcde";
        System.out.println(s4.compareTo(s5));//-1
        String s6 = "山西吕梁市岚县";
        System.out.println(s6.substring(2,5));//吕梁市
        System.out.println(s6);
    }
    @Test
    public void test2(){
        String s1 = "jiange";
        System.out.println(s1.endsWith("jiange"));//true
        System.out.println(s1.startsWith("Jian"));//false
        System.out.println(s1.startsWith("jian"));//true
        System.out.println(s1.startsWith("i",1));//true
        System.out.println(s1.contains("an"));//true
        System.out.println(s1.contains("in"));//false
        System.out.println(s1.indexOf("an",2));//2
        String s2 = "helloworld";
        System.out.println(s2.indexOf("lo",4));//-1
        System.out.println(s2.lastIndexOf("or",7));//6
    }
    @Test
    public void test3(){
        String s1 = "北京尚硅谷教育北京";
        System.out.println(s1.replace('北','东'));//东京尚硅谷教育东京
        System.out.println(s1);//北京尚硅谷教育北京
        System.out.println(s1.replace("北京","上海"));//上海尚硅谷教育上海
        System.out.println(s1);//北京尚硅谷教育北京
        System.out.println(s1.replaceFirst("北京","天津"));//天津尚硅谷教育北京
        System.out.println("-----------------------------");
        String s2 = "123BAj   -";
        System.out.println(s2.replaceAll("\\s+",","));//123BAj,-
        System.out.println(s2);//123BAj   -
        String s3 = "12345";
        System.out.println(s3.matches("\\d+"));//true
        String s4 = "lai|ba|Kuai|dian";
        System.out.println(s4.split("\\|",2)[1]);//ba|Kuai|dian
    }
    @Test
    public void test4(){
        /*
        * string和char[]的转换
        * string--->char[]
        *   1.s1.toCharArray()
        * char[]--->string
        *   1.调用字符串的构造器
        * */
        String s1 = "123abc";
        System.out.println(s1.toCharArray());
        char[] chars = new char[]{'1','2'};
        String s2 = new String(chars);
        System.out.println(s2);//12
    }
    static String a = "jian";
    final String b = "jian";
    @Test
    public void test5() throws UnsupportedEncodingException {
        /*
        * string--->byte[]:s1.getBytes()
        * byte[]----->string：调用构造器
        * */
        String s1 = "123abc中国";
        byte[] bytes = s1.getBytes();//使用默认的编码集
        byte[] gbks = s1.getBytes("gbk");//使用gbk编码
        System.out.println(Arrays.toString(bytes));//[49, 50, 51, 97, 98, 99, -28, -72, -83, -27, -101, -67]
        System.out.println(Arrays.toString(gbks));//[49, 50, 51, 97, 98, 99, -42, -48, -71, -6]
        System.out.println(new String(bytes));//123abc中国
        System.out.println(new String(gbks,"gbk"));//123abc中国
        String a = "jiange";
        final String b = "jian";
        System.out.println(a == this.a+"ge");//false
        System.out.println(a == (this.b+"ge"));//false
        System.out.println(a == b+"ge");//true
    }
}
