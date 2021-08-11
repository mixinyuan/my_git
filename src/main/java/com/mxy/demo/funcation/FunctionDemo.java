package com.mxy.demo.funcation;



import org.apache.commons.lang3.StringUtils;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Bruce_Mi
 * @version 1.0
 * @date 2021/5/24 18:04
 */
public class FunctionDemo {

    public static void main(String[] args) {
        String s1 = test("我是对象", x -> {
            char[] chars = x.toCharArray();
            StringBuilder sb = new StringBuilder();
            return sb.append(chars[3]).append(chars[2]).append(chars[1]).append(chars[0]).toString();
        });
        System.out.println(s1);


        char[] chars = myTest("测试一波", String::toCharArray);
        for (char aChar : chars) {
            System.out.println(aChar);
        }


    }
    
    public static <R,T> R test(T t, Function<T,R> function){
        return function.apply(t);
    }

    public static <T,R> R myTest(T t, Fun<T,R> fun1){
        return fun1.fun(t);
    }

    @FunctionalInterface
    public interface Fun<T,R>{
        R fun(T t);
    }
}
