package com.jian.java1;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*
网络编程的要素：
    IP和端口号
        端口号 标记进程
        端口+ip 叫做socket
    网络通信协议
*/
public class InterAdressTest {
    public static void main(String[] args) {
        try {
            InetAddress byName = InetAddress.getByName("192.168.10.0");
            System.out.println(byName);// /192.168.10.0

            InetAddress byName1 = InetAddress.getByName("www.oppo.com");
            System.out.println(byName1);//www.oppo.com/59.49.93.217

            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);//DESKTOP-C69GI8M/192.168.48.1

            System.out.println(byName.getHostAddress());//获取域名地址
            System.out.println(byName.getHostName());//获取域名
            /*
            * 192.168.10.0
              192.168.10.0
            * */
            System.out.println(byName1.getHostAddress());
            System.out.println(byName1.getHostName());
            /*
            * 223.15.177.242
              www.oppo.com
            * */
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
