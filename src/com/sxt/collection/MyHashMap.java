package com.sxt.collection;

import java.util.HashMap;
import java.util.Map;

public class MyHashMap {
    Map map = new HashMap();
    //HashMap 键值对形式 底层是数组加链表
    int size;
    MyEntry[] array = new MyEntry[size];

    //put方法
    public void put(Object key,Object value){
        MyEntry myEntry = new MyEntry(key,value);
        array[size++] = myEntry;
    }

    //get方法
    public Object get(Object key){
        for (int i = 0; i <size; i++) {
            if(array[i].key.equals(key)){
                return array[i].value;
            }
        }
        return null;
    }
    //containsKey
    public boolean containsKey(Object key){
        for (int i = 0; i <size; i++) {
            if(array[i].key.equals(key)){
                return true;
            }
        }
        return false;
    }
}



class MyEntry {
    Object key;
    Object value;

    public MyEntry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public MyEntry() {
    }
}