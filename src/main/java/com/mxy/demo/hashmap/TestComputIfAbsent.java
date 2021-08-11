package com.mxy.demo.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bruce_Mi
 * @version 1.0
 * @desc:
 * @date 2021/8/10 16:33
 */
public class TestComputIfAbsent {

    public static Map<String,List<String>> map1 = new HashMap<>();
    public static Map<String,List<String>> map2 = new HashMap<>();

    public static void main(String[] args) {
//        // 创建一个 HashMap
//        HashMap<String, Integer> prices = new HashMap<>();
//
//        // 往HashMap中添加映射关系
//        prices.put("Shoes", 180);
//        prices.put("Bag", 300);
//        prices.put("Pant", 150);
//        System.out.println("HashMap: " + prices);
//
//        // Shoes中的映射关系已经存在
//        // Shoes并没有计算新值
//        int shoePrice = prices.computeIfAbsent("20", (key) -> Integer.parseInt(key));
//        System.out.println("Price of Shoes: " + shoePrice);
//
//        // 输出更新后的 HashMap
//        System.out.println("Updated HashMap: " + prices);
        map1();
        map2();
    }

    public static void map1(){
        map1.computeIfAbsent("张三",(k)->getValue1(k));
        map1.computeIfAbsent("张三",(k)->getValue1(k));
        map1.computeIfAbsent("张三",(k)->getValue1(k));
        map1.computeIfAbsent("张三",(k)->getValue1(k));
        map1.computeIfAbsent("sxx",(k)->getValue1(k));
        System.out.println("map1"+ "====================>"+ map1);
    }

    public static List<String> getValue1(String str){
        List<String> list = new ArrayList<>();
        list.add(str);
        return list;
    }

    public static List<String> getValue2(){
        return new ArrayList<>();
    }
    public static void map2(){
        map2.computeIfAbsent("张三", (k) -> getValue2()).add("zhagnsn");
        map2.computeIfAbsent("张三",(k)->getValue2()).add("李四");
        map2.computeIfAbsent("张三",(k)->getValue2()).add("fga");
        map2.computeIfAbsent("张三",(k)->getValue2()).add("454");
        map2.computeIfAbsent("sxx",(k)->getValue2()).add("gg");
        System.out.println("map2"+ "====================>"+ map2);
    }
}
