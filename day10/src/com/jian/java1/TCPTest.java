package com.jian.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Jiange
 * @create 2021-03-17-16:28
 */
public class TCPTest {
    //客户端
//    @Test
//    public void client() throws IOException {
//        InetAddress byName = InetAddress.getByName("127.0.0.1");
//        Socket socket = new Socket(byName.getHostAddress(),8899);
//        OutputStream outputStream = socket.getOutputStream();
//        outputStream.write("建哥 你是最帅的".getBytes());
//        socket.close();
//        outputStream.close();
//    }
//
//    //服务端
//    @Test
//    public void server() throws IOException {
//        ServerSocket serverSocket = new ServerSocket(8899);
//        Socket accept = serverSocket.accept();
//        InputStream inputStream = accept.getInputStream();
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//        char[] bytes = new char[5];
//        int read;
//        while ((read = inputStreamReader.read(bytes)) != -1){
//            System.out.println(new String(bytes,0,read));
//        }
//    }
    @Test
    public void client() throws IOException {
        InetAddress localhost = InetAddress.getByName("localhost");
        Socket socket = new Socket(localhost.getHostName(),8899);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("jiange最刷阿大撒".getBytes());
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = inputStream.readAllBytes();
        System.out.println(new String(bytes));
        socket.close();
        outputStream.close();
    }
    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8899);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        int read;
        while ((read = inputStreamReader.read()) != -1){
            System.out.println((char) read);
        }
        socket.shutdownInput();
        System.out.println(socket.getInetAddress().getHostName());
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("成功接收，建哥果然很帅".getBytes());
        outputStream.close();
        inputStreamReader.close();
        serverSocket.close();
        socket.close();
    }
}
