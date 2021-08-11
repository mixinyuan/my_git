package com.mxy.demo.funcation;


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
        boolean mytTest(T t);
    }

    /**
     * 自定义函数式接口方法
     * @param t
     * @param pre
     * @param <T>
     * @return
     */
    public  static <T> boolean testPredict(T t,Predict<T> pre){
        return pre.mytTest(t);
    }

    /**
     * 原生的
     * @param t
     * @param pre
     * @param <T>
     * @return
     */
    public  static <T> boolean Predict(T t,Predicate<T> pre){
        return pre.test(t);
    }
}
