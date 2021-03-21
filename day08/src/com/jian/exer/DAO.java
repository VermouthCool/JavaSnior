package com.jian.exer;

import java.util.*;

/**
 * @author Jiange
 * @create 2021-03-15-19:34
 */
public class DAO<T> {
    static {
        System.out.println( DAO.age);
        age = 100;
    }
    public static int age = 10;
    private Map<String,T> map = new HashMap<>();

    public void save(String id,T entity){
        map.put(id,entity);
    }
    public T get(String id){
        return map.get(id);
    }
    public void update(String id,T entity){
        map.put(id,entity);
    }
    public List<T> list(){
        Collection<T> values = map.values();
        List<T> list = new ArrayList<>();
        list.addAll(values);
        return list;
    }
    public void delete(String id){
        map.remove(id);
    }
}
