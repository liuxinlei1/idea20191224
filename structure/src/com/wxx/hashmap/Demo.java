package com.wxx.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description :
 * @Author : wuxinxin
 * @Date: 2019-12-28 09:19
 */
public class Demo {
    public static void main(String[] args) {
        MyMap map = new MyHashMap();
        map.put(23,"china");
        map.put(36,"japan");
        map.put(48,"america");
        map.put(86,"erica");
        map.put(67,"france");
        map.put(23,"itelian");
        map.put(47,"england");

        System.out.println( map.get(23));

        System.out.println(((MyHashMap) map).size);
        System.out.println(map.toString());


        MyHashSet set = new MyHashSet();
       /* set.add(23);
        set.add(54);
        set.add(23);
        set.add(656);*/
        System.out.println( set.size());
        System.out.println(set.container(65));
        System.out.println(set.isEmpty());
        
    }
}
