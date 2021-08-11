package com.mxy.demo.funcation;

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

    public StaticTest(){
        i = 4;
    }
    public StaticTest(int j){
        i = j;
        ii = j;
    }


    public static void main(String[] args) {

        StaticTest t = new StaticTest(5); //声明对象引用，并实例化


        StaticTest tt = new StaticTest(); //同上

    }

}
