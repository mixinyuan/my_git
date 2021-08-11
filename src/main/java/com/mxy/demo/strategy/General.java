package com.mxy.demo.strategy;

/**
 * @author Bruce_Mi
 * @version 1.0
 * @date 2021/5/27 9:54
 */
@PriceRegion(max = 10000)
public class General implements Strategy{


    /**
     * 原价
     * @param originallyPrice
     * @return
     */
    @Override
    public Double sellPrice(Double originallyPrice) {
        System.out.println("消费未满10000为原价不打折");
        return originallyPrice;
    }
}
