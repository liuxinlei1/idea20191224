package com.wxx.hashmap;

/**
 * @Description :
 * @Author : wuxinxin
 * @Date: 2019-12-28 09:02
 */
public interface MyMap {
    
    public void put(Object key,Object value);
    
    public Object get(Object key);
    
    public int size();
    
    public boolean isEmpty();
    
    interface Entry{
        public Object getKey();
        public Object getValue();
    }
}
