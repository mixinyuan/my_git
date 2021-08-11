package com.mxy.demo.test1;

import org.apache.catalina.startup.Bootstrap;
import org.assertj.core.util.Lists;

import java.util.List;
import java.util.concurrent.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Bruce_Mi
 * @version 1.0
 * @date 2021/3/31 10:05
 */
public class PredictDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService es = Executors.newFixedThreadPool(10);
//        Future<Integer> future = es.submit(() -> {
//            return 100;
//        });
//        Integer integer = future.get();
//        System.out.println(integer);


        boolean b = testPredict(-20, str -> str > 2);
        System.out.println(b);


    }



    @FunctionalInterface
    public interface Predict<T>{
        boolean test(T t);
    }

    public  static <T> boolean testPredict(T t,Predict<T> pre){
        return pre.test(t);
    }
}
