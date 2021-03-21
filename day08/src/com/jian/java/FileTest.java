package com.jian.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Jiange
 * @create 2021-03-15-20:22
 *      1.File类的一个对象，代表一个文件或一个文件目录
 *      2.File类声明在java.io包下
 *      3.路径分隔符 windows \\ url/
 */
public class FileTest {
    @Test
    public void test1(){
        File file = new File("jian.txt");//这个文件不一定非要存在 只是存在于内存层面
        File file1 = new File("D:\\WEB\\Java\\day08","jian");
        File f3 = new File(file1,"1.txt");
        System.out.println(file);
        System.out.println(file1);
        System.out.println(f3);
        /*
        * jian.txt
D:\WEB\Java\day08\jian
D:\WEB\Java\day08\jian\1.txt
        * */
    }
    @Test
    public void test2(){
        //
        File file = new File("jian.txt");
        System.out.println(file.toString());

        //getPath   返回构造器的字符串内 最后一段字符
        System.out.println(file.getPath());//jian.txt

        //getAbsolutePath
        System.out.println(file.getAbsolutePath());//D:\WEB\Java\day08\jian.txt

        //getName() 最后一段
        System.out.println(file.getName());//jian.txt

        //getParent  字符串前面的处了最后一段  没有就是null
        System.out.println(file.getParent());//null

        //length()    返回文件的字节数
        System.out.println(file.length());//0

        //lastModified
        System.out.println(file.lastModified());//0

        //以下两个方法  只适用于文件目录
        File file1 = new File("D:\\WEB\\Java\\day08");//如果没有这个文件  在遍历时就会报错
        String[] list = file1.list();//返回当前目录下的所有的文件和文件目录
        for (String s : list) {
            System.out.println(s);
        }
        File[] files = file1.listFiles();
        for (File file2 : files) {
            System.out.println(file2);//返回的是 使用的绝对路径的File对象
        }
    }
    @Test
    public void test4(){
        //boolean renameTo()  把文件重命名到指定的文件路径
        File file = new File("jian.txt");
        File lai = new File("D:\\WEB\\Java\\day07\\lai.txt");//此时必须写文件名
        //如果想要保证成功  需要file在硬盘内存在 且 lai不能存在
        //成功后 file后消失 去到lai里面   内容也会跟着去
        boolean b = file.renameTo(lai);

        System.out.println(b);
    }
    @Test
    public void test5(){
        File file = new File("jian.txt");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());//硬盘内
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
    }
    @Test
    public void test6() throws IOException {
        File file = new File("hi.txt");
        if(!file.exists()){
            file.createNewFile();
            System.out.println("-----------");
        }else {
            file.delete();//不走回收站
            System.out.println("*****************");
        }

    }
    @Test
    public void test(){
        File file = new File("D:\\WEB\\Java\\day08\\jian");
        boolean mkdir = file.mkdir();
        //如果上层文件目录不存在就不会创建 如果文件都存在 不会创建 返回false
        System.out.println(mkdir);
        boolean mkdirs = file.mkdirs();
        //不管上层文件存在与否  都会创建 上层没有上层也会一起创建 如果已经存在会返回false
        System.out.println(mkdirs);
    }
    @Test
    public void jian(){
        //要想删除成功文件夹 文件夹内不能有东西
        File file = new File("D:\\WEB\\Java\\day08");
        System.out.println(file.length());//0
    }
    @Test
    public void ge() throws IOException {
//        File file = new File("D:\\jian");
//        System.out.println(file.exists());
//        System.out.println(file.isDirectory());
//        System.out.println(file.isAbsolute());
//        System.out.println(file.mkdir());
//        File file1 = new File(file,"jian.txt");
//        if (!file1.exists()) {
//            file1.createNewFile();
//        }
//        System.out.println(file.delete());
//        String a = "";
//        Map<String,Object > map = new HashMap<>();
//        map.put("jian","ge");
//        Set<String> strings = map.keySet();
        System.out.println(Lai(10));
    }
    public <E> E Lai( E a){
        return null;
    }

}

