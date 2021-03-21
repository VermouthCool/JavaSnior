package com.jian.java;

import org.junit.Test;

import java.io.*;
import java.nio.CharBuffer;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @author Jiange
 * @create 2021-03-16-21:31
 * 标准输入输出
 * 打印流 PrintStream PrintWriter
 * 数据流
 */
public class OtherStream {
    public static void test1() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in,"utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        bufferedReader.readLine()//不会读到换行 需要自己添加
        String data;
        while (true){
            data = bufferedReader.readLine();
            if (data.equalsIgnoreCase("exit")  || data.equalsIgnoreCase("e") ){
                break;
            }else {
                System.out.println(data.toUpperCase());
            }
        }
        bufferedReader.close();
    }

    public void test2(){
        /*
        * 打印流
        * */
//        new PrintStream(System.out)
    }


    public static void main(String[] args) throws IOException {
        test1();
    }
    @Test
    public void  test3() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("jian.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\jian\\jian.txt");  //文件夹 必须存在  文件可以不存在
        byte[] bytes = fileInputStream.readAllBytes();
        fileOutputStream.write(bytes);
        new FileWriter("").write("jian");
        fileInputStream.close();
        fileOutputStream.close();
    }
    @Test
    public void test4(){
        File file = new File("D:\\jian\\jian.txt");

        file.mkdirs();//此时会把 jian.txt当作文件夹来创建
        file.delete();
    }
    public void test5() throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("jian.txt"));
        dataOutputStream.writeUTF("jian");
        dataOutputStream.flush();//将内存里面的数据写入 文件

        dataOutputStream.writeInt(10);

        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("jain.txt"));
        String s = dataInputStream.readUTF();
        int i = dataInputStream.readInt();
        //要按顺序读取
    }
}
class MyScanner{
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(inputStreamReader);

    public MyScanner() {
    }

    public int nextInt() throws IOException {
        return reader.read();
    }
    public char nextChar() throws IOException {
        return (char) reader.read();
    }
}