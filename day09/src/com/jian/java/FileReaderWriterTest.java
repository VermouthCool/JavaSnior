package com.jian.java;

import org.junit.Test;

import java.io.*;

/**
 * @author Jiange
 * @create 2021-03-16-13:33
 * 抽象基类：                    节点流(文件流)                缓冲流：（处理流的一种）
 *      inputStream                 FileInputstream             BufferedInputStream
 *      outputStream                FileOutputStream            BufferedOutStream
 *      Reader                      FileReader                  BufferedReader
 *      Writer                      FileWriter                  BufferedWriter
 *
 */
public class FileReaderWriterTest {
    @Test
    public void test1(){
        byte a = 1;
        short b = 2;
        short c = (short) (a + b);

    }
    @Test
    public void testFileReader() throws IOException {
        File file = new File("hello.txt");
//        System.out.println(file.getAbsolutePath());//列出当前file的绝对路径
        FileReader fileReader = new FileReader(file);

//        int read = fileReader.read();//当返回值是 -1 时 表示读完了  否则 返回一个字符
        int read = fileReader.read();
        while (read != -1){
            System.out.print((char)read);
            read = fileReader.read();
        }

        //流的关闭
        fileReader.close();
    }
    @Test
    public void test2(){
        File file = new File("hello.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            fileReader.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null)
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @Test
    public void test3() throws IOException {
        File file = new File("hello.txt");
        char[] chars = new char[5];
        FileReader fileReader = new FileReader(file);
        int read ;//一次读取五个  没了返回-1 否则返回数组内字符的个数 不够 也返回剩下的个数
        while ((read = fileReader.read(chars))!=-1){
            //方式一：
//            for (int i = 0; i < read; i++) {
//                System.out.print(chars[i]);
//            }
            //方式二：
//            String a = new String(chars,0,read);
//            System.out.print(a);


        }
    }
    @Test
    public void FileWriterTest() {
        /*
        * file是可以不存在的 写的时候会自动生成
        * 如果文件存在 就在原有文件上操作
        * */
        File file = new File("jian.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file,true);//true 此时才能追加
//            fileWriter.write(1025);//添加数字的时候  会找到对应的unicode码 变成字符填进去
            fileWriter.append("jiange");
            fileWriter.append("kuaidajiaj");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null)
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void jian() {
        File file = new File("hello.txt");
        File Jian = new File("jian.txt");
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(file);
            fileWriter = new FileWriter(Jian);
            char[] chars = new char[5];
            int read = fileReader.read(chars);
            String a;
            while (read != -1){
                a = new String(chars,0,read);
                fileWriter.write(a);
                read = fileReader.read(chars);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader!=null && fileWriter!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
