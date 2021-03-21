package com.jian.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Jiange
 * @create 2021-03-16-15:56
 */
public class FileInoutOutTest {
    @Test
    public void test1(){
        File file = new File("hello.txt");
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream("jian.txt");
            byte[] bytes = new byte[5];
            int read = fileInputStream.read(bytes);
            while (read != -1){
                String a = new String(bytes,0,read);
                System.out.println(a);
                fileOutputStream.write(bytes,0,read);
                read = fileInputStream.read(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream != null && fileOutputStream != null){

                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
