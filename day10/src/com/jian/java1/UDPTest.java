package com.jian.java1;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @author Jiange
 * @create 2021-03-17-19:36
 */
public class UDPTest {
    @Test
    public void test1() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        String s = "jiange家的撒豆i赛道吉萨";
        DatagramPacket localhost = new DatagramPacket(s.getBytes(), 0, s.length(), InetAddress.getByName("localhost"), 8899);
        datagramSocket.send(localhost);
        datagramSocket.close();
    }
    @Test
    public void test2() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8899);
        byte[] bytes = new byte[100];
        DatagramPacket datagramPacket = new DatagramPacket(bytes,100);
        datagramSocket.receive(datagramPacket);
        System.out.println(new String(datagramPacket.getData(),0,datagramPacket
        .getLength()));
        datagramSocket.close();
    }
}
