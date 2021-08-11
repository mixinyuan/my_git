package com.mxy.demo.hashmap;

import lombok.Data;



/**
 * @author Bruce_Mi
 * @version 1.0
 * @date 2021/5/25 11:41
 */
@Data
public class MyHashMap<K,V> {
    public static void main(String[] args) {
        MyHashMap<String,Object> myHashMap = new MyHashMap();
        myHashMap.put("key","自测map");
        myHashMap.put("哈哈","嘎嘎");
        myHashMap.put("xx","嘎嘎发的发");
        myHashMap.put("ooo","股份公司");
        myHashMap.put("bbb","公司");

        System.out.println(myHashMap);

    }
    //声明链表
     static class Node<K,V> {
        //保存该节点的Key、Value
        final K key;
        V value;
        //指向下一个节点
        Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return key + "=" + value;
        }
    }
    //默认数组长度
    private final int CAPACITY = 30;
    //声明数组
    Node[] nodes = new Node[CAPACITY];
    /**
     * put方法
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        int idx = getIndex(key);
        Node now = nodes[idx];
        Node tmp = now;
        if (tmp != null) {
            Node prev = null;
            while (tmp != null) {
                if (tmp.key == key) {
                    tmp.value = value;
                    return;
                }
                prev = tmp;
                tmp = tmp.next;
            }
            tmp = prev;
        }

        Node node = new Node(key, value);
        if (tmp != null) {
            tmp.next = node;
        } else {
            nodes[idx] = node;
        }
    }
    /**
     * get方法
     * @param key
     * @return
     */
    public V get(K key) {
        int idx = getIndex(key);
        Node now = nodes[idx];
        if (now != null) {
            if (now.key == key) {
                return (V)now.value;
            } else {
                while (now != null) {
                    if (now.key == key) {
                        return (V)now.value;
                    }
                    now = now.next;
                }
            }
        }

        return null;
    }
    /**
     * 删除值
     * @param key
     */
    public void remove(K key) {
        //得到索引
        int idx = getIndex(key);
        //拿到首节点
        Node now = nodes[idx];

        if (now != null) {
            //保存前节点
            Node prev = null;
            //遍历查找
            while (now != null) {
                //如果找到
                if (now.key == key) {
                    //这里有两种情况
                    //1. 如果要删除的节点是首节点，那么直接让当前数组下标对应的首节点位为其下一个节点
                    //2. 如果不是，那么让前一个节点的下一个节点指向当前要删除节点的下一个节点就实现了删除效果
                    if (prev != null) {
                        prev.next = now.next;
                    }else {
                        nodes[idx] = now.next;
                    }
                    //不管是怎么删除的，都让当前节点的下一个节点为null
                    now.next = null;
                    return;
                }
                //如果没找到，让前节点指向当前节点，当前节点指向其下一个节点
                prev = now;
                now = now.next;
            }
        }
    }
    /**
     * 得到下标
     * @param key
     * @return
     */
    private int getIndex(K key) {
//        if(key == null){
//            return 0;
//        }
        int h;
        return key == null ? 0 : ((h=key.hashCode()) ^ (h >>> 16)) % CAPACITY;
//        int hash = key.hashCode();
//        //高16位异或低16位
//        hash ^= (hash >>> 16);
//        //与数组长度取模，得到对应的索引下标
//        return hash % CAPACITY;
    }




}
