package com.jian.java;

import java.util.Properties;

/**
 * @author Jiange
 * @create 2021-03-19-15:02
 */

interface ClothFactroy{
    void produce();
}

class Proxy implements ClothFactroy {
    private final ClothFactroy clothFactroy;
    public Proxy(ClothFactroy clothFactroy){
        this.clothFactroy = clothFactroy;
    }
    @Override
    public void produce() {
        System.out.println("准备公作");
        clothFactroy.produce();
        System.out.println("后续的首尾工作");
    }
}

class NikeClothFactroy implements ClothFactroy{
    @Override
    public void produce() {
        System.out.println("生产衣服");
    }
}

public class StaticProxy {
    public static void main(String[] args) {
        NikeClothFactroy nikeClothFactroy = new NikeClothFactroy();
        Proxy proxy = new Proxy(nikeClothFactroy);
        proxy.produce();
    }
}
