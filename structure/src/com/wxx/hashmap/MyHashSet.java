package com.wxx.hashmap;

import java.lang.reflect.MalformedParameterizedTypeException;

/**
 * @Description :
 * @Author : wuxinxin
 * @Date: 2019-12-28 11:13
 */
public class MyHashSet implements MySet {
    private MyMap map =null;

    private static final Object PRESENT = new Object();
    

    public MyHashSet() {
        map =new MyHashMap();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void add(Object object) {
        map.put(object,PRESENT);
    }

    @Override
    public boolean isEmpty() {
        return map.size()!=0;
    }

    @Override
    public boolean container(Object object) {
        return map.get(object)!=null;
    }
}
