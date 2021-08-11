package com.mxy.demo.test1;

import lombok.Data;

/**
 * @author Bruce_Mi
 * @version 1.0
 * @date 2021/5/21 12:28
 */
@Data
public class StaticTest {

     static int i;

     int ii = 20;

    public  StaticTest(){
        i = 4;
    }
    public  StaticTest(int j){
        i = j;
        ii = j;
    }


    public static void main(String[] args) {

        StaticTest t = new StaticTest(5); //声明对象引用，并实例化


        StaticTest tt = new StaticTest(); //同上
        t.i = 50;
        System.out.println(t.i+"==============+ii=>"+t.ii);
        StaticTest.i = 20;
        System.out.println(tt.i+"==============+ii=>"+tt.ii);
        System.out.println(t.i+"==============+ii=>"+t.ii);
    }

}
