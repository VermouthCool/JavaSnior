package com.jian.java1;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Jiange
 * @create 2021-03-17-19:47
 */
public class URLTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.bilibili.com/video/BV1Kb411W75N?p=629&spm_id_from=pageDriver");
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getFile());
        System.out.println(url.getPath());
        System.out.println(url.getQuery());
        /*
        * https
            www.bilibili.com
            /video/BV1Kb411W75N?p=629&spm_id_from=pageDriver
            /video/BV1Kb411W75N
            p=629&spm_id_from=pageDriver
        * */
        HttpURLConnection urlConnection =(HttpURLConnection) url.openConnection();

        urlConnection.connect();
        InputStream inputStream = urlConnection.getInputStream();

        inputStream.close();
        urlConnection.disconnect();

    }
}
