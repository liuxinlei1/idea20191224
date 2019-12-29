package com.wxx.hashmap;

import java.lang.annotation.Target;

/**
 * @Description :
 * @Author : wuxinxin
 * @Date: 2019-12-28 09:05
 */
public class MyHashMap implements MyMap {
    //默认的数组的长度
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
    //键值对的数量,Entry的数量
    transient int size;
    //数组的引用,用来指向一个数据,数组的元素都是Entry
    transient Entry[] table = null;

    //无参构造方法
    public MyHashMap() {
        table = new Entry[DEFAULT_INITIAL_CAPACITY];//构造方法中,默认新建一个长度为16的数组
    }

    @Override
    public void put(Object key, Object value) {
        //1.计算hash值
        int hash = key.hashCode();

        //2.计算存储位置,计算需要存到数组中的那个位置
        int index = hash % table.length;

        //3.存储到指定的位置,如果当前的table没有对象就存到数组上
        if (table[index] == null) {
            table[index] = new Entry(key, value, null, hash);//将entry对象放入到数组中
            size++;
        } else {//该数组的位置已经存在了元素, 检查下面的链表是否存在相同的key的Entry对象
            Entry entry = table[index];
            while (entry != null) {
                //比较,找到了就将旧value覆盖,并返回
                if (entry.hash == hash && entry.getKey().equals(key)) {
                    entry.value = value;
                    return;
                }

                //指向下一个节点
                entry = entry.next;
            }
            //如果上面的循环完后都没有找到,那就将这个新节点添加到最前面,不是添加到末尾
            Entry firstEntry = table[index];//原来的第一个节点
            size++;//数量++

            table[index] = new Entry(key, value, firstEntry, hash);//将新节点添加最前面,下一个节点就是原来的第一个节点
        }
    }

    @Override
    public Object get(Object key) {
        //1.计算hash值
        int hash = key.hashCode();
        //2.j计算存储位置
        int index = hash % table.length;

        //这个就是数组某个索引的头节点
        Entry entry = table[index];
        //遍历链表
        while (entry != null) {
            //判断key是否一样,找到了就返回value
            if (entry.hash == hash && entry.key.equals(key)) {
                return entry.value;
            }
            //指向下一个节点
            entry = entry.next;
        }
        //直到最后都没有查到, 就返回null
        return null;
    }

    //打印hashMap
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        for (Entry entry : table) {
            if (entry != null) {
                while (entry != null) {
                    //追加
                    builder.append(entry.key + "=" + entry.value + ",");
                    //指向下一个节点
                    entry = entry.next;
                }
            }
        }

        //将最后一个","删除,先判断是否有元素
        if (builder.length() > 2) {
            builder.deleteCharAt(builder.length() - 1);
        }

        builder.append("}");
        return builder.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    class Entry implements MyMap.Entry {
        final Object key;
        Object value;
        Entry next;
        int hash;

        public Entry(Object key, Object value, Entry next, int hash) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    ", hash=" + hash +
                    '}';
        }
    }


}
