package com.jian.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Jiange
 * @create 2021-03-17-17:12
 */
public class TCPFileTest {
    @Test
    public void client() throws IOException {
        InetAddress inetAddress = InetAddress.getByName("localhost");
        Socket socket = new Socket(inetAddress.getHostName(),8899);
        FileInputStream fileInputStream = new FileInputStream("D:\\自己编程前端练习文件\\tupian\\2.jpg");
        OutputStream outputStream = socket.getOutputStream();
        byte[] bytes = fileInputStream.readAllBytes();
        outputStream.write(bytes);
        socket.close();
        fileInputStream.close();
        outputStream.close();
    }
    @Test
    public void test2() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8899);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bytes = bufferedInputStream.readAllBytes();
        FileOutputStream fileOutputStream = new FileOutputStream("1.jpg");
        fileOutputStream.write(bytes);
        socket.close();
        serverSocket.close();
        inputStream.close();
        bufferedInputStream.close();
    }
}
