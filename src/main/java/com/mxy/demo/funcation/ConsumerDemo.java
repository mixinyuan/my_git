package com.mxy.demo.funcation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author Bruce_Mi
 * @version 1.0
 * @date 2021/5/24 17:37
 */
public class ConsumerDemo {


    public static void main(String[] args) {
        test(20,x->System.out.println(x+30),System.out::println);

    }

    public static <T> void test(T t, Consumer<T> consumer1, Consumer<T> consumer2){
        consumer1.andThen(consumer2).accept(t);
    }

}
