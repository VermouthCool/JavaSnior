package com.jian.java;

import org.junit.Test;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.net.*;
import java.util.Random;

/**
 * @author Jiange
 * @create 2021-03-18-18:40
 *  通过反射创建对应的运行时类的对象
 */
public class NewInstanceTest {
    @Test
    public void test1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor();

        Person person = constructor.newInstance("jiange",18);//调用构造器
//        Person person = personClass.newInstance();这个方法已经过时了
    }
    @Test
    public void test2() throws Exception {
        Class<Person> personClass = Person.class;
        Constructor<Person> personConstructor = personClass.getConstructor();
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.print(Modifier.toString(field.getModifiers())+"\t");
            System.out.print(field.getType()+"\t");
            System.out.println(field.getName());
        }
        System.out.println("----------------------------------");
        Field[] fields1 = personClass.getDeclaredFields();
        for (Field field : fields1) {
            System.out.print(Modifier.toString(field.getModifiers())+"\t");
            System.out.print(field.getType()+"\t");
            System.out.println(field.getName());
        }
        System.out.println("-----------------------------------------");
        Field field = personClass.getDeclaredField("name");
        System.out.print(Modifier.toString(field.getModifiers())+"\t");
        System.out.print(field.getType()+"\t");
        System.out.println(field.getName());
    }
    @Test
    public void test3() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("jian.txt");
        byte[] bytes = new byte[10];
        int read;
        while ((read = fileInputStream.read(bytes)) != -1){
            for (byte aByte : bytes) {
                System.out.println((char) aByte);
            }
        }
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("jian"));
        outputStreamWriter.write("");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object o = objectInputStream.readObject();

    }
    @Test
    public void test4() throws Exception {
        InetAddress inetAddress = InetAddress.getByName("localhost");
        Socket socket = new Socket(inetAddress.getHostAddress(),8899);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("jian建哥最帅".getBytes());
        socket.shutdownOutput();
        ServerSocket serverSocket = new ServerSocket(8899);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();

    }
    @Test
    public void test5() throws Exception {
//        DatagramSocket datagramSocket = new DatagramSocket();
//        DatagramPacket datagramPacket = new DatagramPacket("jiange".getBytes(),0,10,InetAddress.getByName("localhost"),8899);
//        datagramSocket.send(datagramPacket);
//        datagramSocket.close();
        DatagramSocket datagramSocket = new DatagramSocket(8899);
        DatagramPacket datagramPacket = new DatagramPacket(new byte[100],100);
        datagramSocket.receive(datagramPacket);
        System.out.println(datagramPacket.getData());
        System.out.println(datagramPacket.getLength());
    }
    @Test
    public void test6() throws IOException {
        URL url = new URL("https://www.bilibili.com/video/BV1Kb411W75N?p=629&spm_id_from=pageDriver");
        System.out.println(url.getPath());
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        httpsURLConnection.connect();
        InputStream inputStream = httpsURLConnection.getInputStream();
        httpsURLConnection.disconnect();
        inputStream.close();
    }
}
