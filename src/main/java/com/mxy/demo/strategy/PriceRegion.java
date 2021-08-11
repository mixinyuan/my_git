package com.mxy.demo.strategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Bruce_Mi
 * @version 1.0
 * @date 2021/5/27 11:21
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PriceRegion {

    int max() default Integer.MAX_VALUE;

    int min() default Integer.MIN_VALUE;
}
