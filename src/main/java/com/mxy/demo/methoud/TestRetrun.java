package com.mxy.demo.methoud;

/**
 * @author Bruce_Mi
 * @version 1.0
 * @desc:测试返回
 * @date 2021/7/1 10:05
 */
public class TestRetrun {


    public static void testMax(int i, int j){
//        i = 20;
        testMin(i);
        i = i + j;
        System.out.println("i ==>"+ i);
    }


    public static void testMin(int i){
        if(i > 20){
            return;
        }

        System.out.println("------------>+打印消息！" +i);
    }

    public static void main(String[] args) {
        testMax(10,20);
    }

}
