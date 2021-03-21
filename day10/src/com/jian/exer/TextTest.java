package com.jian.exer;

import org.junit.Test;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiange
 * @create 2021-03-18-11:20
 */
public class TextTest {
    @Test
    public void test1 () throws IOException {
        InetAddress localhost = InetAddress.getByName("localhost");
        Socket socket = new Socket(localhost.getHostAddress(),8899);
        OutputStream outputStream  = socket.getOutputStream();
        outputStream.write("jiangezuishuai,建哥最帅".getBytes());
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = inputStream.readAllBytes();
        System.out.println(new String(bytes));
        socket.close();
        outputStream.close();
        inputStream.close();
    }
    @Test
    public void test2() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8899);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        byte[] bytes = inputStream.readAllBytes();
        System.out.println(new String(bytes));
        socket.shutdownInput();
        outputStream.write("已经收到，有趣弟弟".getBytes());
        socket.close();
        inputStream.close();
        outputStream.close();
    }
    @Test
    public void test3() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        DatagramPacket datagramPacket = new DatagramPacket("建哥最帅啊".getBytes(),0,15,InetAddress.getByName("localhost"),8899);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
    @Test
    public void test4() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8899);
        byte[] bytes = new byte[100];
        DatagramPacket datagramPacket = new DatagramPacket(bytes,100);
        datagramSocket.receive(datagramPacket);
        System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));
        datagramSocket.close();
    }
    @Test
    public void test5() throws IOException {
        URL url = new URL("https://www.bilibili.com/video/BV1Kb411W75N?p=629&spm_id_from=pageDriver");
//        System.out.println(url.getContent());
        HttpsURLConnection urlConnection =(HttpsURLConnection) url.openConnection();

        urlConnection.connect();
        InputStream inputStream = urlConnection.getInputStream();
        byte[] bytes = inputStream.readAllBytes();
        System.out.println(new String(bytes));
        inputStream.close();
        urlConnection.disconnect();
    }
}
