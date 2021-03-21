package com.jian.demo;

import org.jetbrains.annotations.NotNull;

/**
 * @author Jiange
 * @create 2021-03-12-12:54
 */
public class Goods implements Comparable {
    private String name;
    private double price;

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Goods() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(@NotNull Object o) {
        if(o instanceof Goods){
            Goods goods = (Goods) o;
            return Double.compare(goods.price,this.price);
        }else{
            throw new RuntimeException("传入数据类型不一致");
        }
    }
}
