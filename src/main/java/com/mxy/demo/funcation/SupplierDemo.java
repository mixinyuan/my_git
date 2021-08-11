package com.mxy.demo.funcation;

import lombok.Data;

import java.util.function.Supplier;

/**
 * @author Bruce_Mi
 * @version 1.0
 * @date 2021/5/24 17:55
 */
public class SupplierDemo {

    public static void main(String[] args) {
        User user = test(User::new);
    }

    public static <T> T test(Supplier<T> t){
        return t.get();
    }

}

@Data
class User{

    private Long id;

    private String name;
}