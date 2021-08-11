package com.mxy.demo.strategy;

/**
 * @author Bruce_Mi
 * @version 1.0
 * @date 2021/5/27 9:54
 */
@PriceRegion(max=20000,min = 10000)
public class Vip implements Strategy{


    /**
     * 普通会员价格
     * @param originallyPrice
     * @return
     */
    @Override
    public Double sellPrice(Double originallyPrice) {
        System.out.println("消费满10000为普通会员打9折");
        return originallyPrice * 0.9;
    }



}
