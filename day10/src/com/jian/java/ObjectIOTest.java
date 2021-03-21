package com.jian.java;

import org.junit.Test;

import java.io.*;

/**
 * @author Jiange
 * @create 2021-03-17-13:35
 * 是字节流：
 *
 */
public class ObjectIOTest {
    /*
    * 将内存里的Java对象存到磁盘
    * 要想使Java对象可以序列化 ：
    *       1.Serializable实现该接口  标识接口
    *       2.static final long serialVersionUID 必须提供全局常量  如果不写 会自动根据类的
    *           内部细节 自己添加 但是可能会根据类的改变 而id改变
    *           在反序列化 时 会比较这两个ID  不一样就报错
    *       3. 类的内部属性保证可以是序列化的（基本数据类型是可以序列化的）
    *   不能序列化 和 反序列化 static transient修饰的成员变量 方法可以
    * */
    @Test
    public void test1() throws IOException {
        //序列化
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("jian.txt"));
        objectOutputStream.writeObject(new StringBuffer("jiange"));
        objectOutputStream.flush();
        objectOutputStream.writeObject(new Person("李子建",18));
        objectOutputStream.close();
        //你打开也没法都
    }
    @Test
    public void test2() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("jian.txt"));
        Object o = objectInputStream.readObject();
        System.out.println(o);
//        System.out.println(((Person)objectInputStream.readObject()));
        Person person = (Person) objectInputStream.readObject();
        person.sleep();
        objectInputStream.close();
    }
}
