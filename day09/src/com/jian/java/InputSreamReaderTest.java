package com.jian.java;

import org.junit.Test;

import java.io.*;

/**
 * @author Jiange
 * @create 2021-03-16-20:38
 * 字符集
 */
public class InputSreamReaderTest {
    @Test
    public void test1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("hello.txt");

        //字符集 是根据文件存的时候决定
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");//不写字符集 就是默认的

        char[] chars = new char[20];
        int len;
        while ((len = inputStreamReader.read(chars)) != -1){
            String a = new String(chars,0,len);
            System.out.println(a);
        }
        inputStreamReader.close();
    }
    @Test
    public void test2() throws IOException {
        File file = new File("hello_gbk.txt");
        File file1 = new File("hello_utf_8.txt");
        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
        OutputStreamWriter gbk = new OutputStreamWriter(fileOutputStream,"gbk");

        char[] chars = new char[20];
        int read;
        while ((read = inputStreamReader.read(chars))!= -1){
            String s = new String(chars,0,read);
            System.out.println(s);
            gbk.write(s);
        }
        inputStreamReader.close();
        gbk.close();
    }
}
