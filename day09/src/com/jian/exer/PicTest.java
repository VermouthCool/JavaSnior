package com.jian.exer;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Jiange
 * @create 2021-03-16-19:24
 */
public class PicTest {
    @Test
    public void test1(){
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream("1.jpg"));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("2.jpg"));
            byte[] bytes = new byte[20];
            int read = bufferedInputStream.read(bytes);
            while (read != -1){
                bufferedOutputStream.write(bytes,0,read);
                read = bufferedInputStream.read(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
    @Test
    public void test2(){
        Map<String,Integer> map = null;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("jian.txt"));
            map = new HashMap<>();
            int read = 0;
            while ((read = bufferedReader.read()) != -1){
                if(map.containsKey(""+(char) read)){
                    map.put((char)read+"",map.get((char)read + "") + 1);
                }else {
                    map.put((char)read+"",1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Set<Map.Entry<String,Integer>> set = map.entrySet();
        for(Map.Entry<String,Integer> entry : set){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
    @Test
    public void test3(){
        String a = "";
        a.intern();
        a.indexOf(4);
        a.lastIndexOf(4,5);
        a.isEmpty();
        a.charAt(5);
        a.concat("");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.insert(0,"");
        stringBuilder.setCharAt(1,'1');
        stringBuilder.charAt(1);
        stringBuilder.append(5);
        stringBuilder.replace(1,2,"as");
        a.replaceAll("\\|","da");

    }
    @Test
    public void test4() throws IOException {
//        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("jian.txt"));
////        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("jian.txt"));
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        String read;
//        while ((read = bufferedReader.readLine()) != null){
//            System.out.println(read);
//        }
        FileInputStream jian = new FileInputStream("jian.txt");
        byte[] bytes = jian.readAllBytes();
        String s = new String(bytes,"utf-8");
        System.out.println(s);
    }
}
