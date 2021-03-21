package com.jian.java;

import org.junit.Test;

import java.io.*;

/**
 * @author Jiange
 * @create 2021-03-16-16:58
 * 提高效率
 */
public class BufferedTest {
    @Test
    public void test1(){
        copyOf("hello.txt","jian.txt");
    }
    public void copyOf(String rc,String ist){
        File src = new File(rc);
        File dist = new File(ist);
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(src);
            FileOutputStream fileOutputStream = new FileOutputStream(dist,true);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            byte[] bytes = new byte[10];
            int read = bufferedInputStream.read(bytes);
            while (read != -1){
                bufferedOutputStream.write(bytes,0,read);
                read = bufferedInputStream.read(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //先关外层  在关闭外层流的同时 内层流也会自动关闭  关于内层流的关闭 可以省略
            if (bufferedInputStream != null && bufferedOutputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
