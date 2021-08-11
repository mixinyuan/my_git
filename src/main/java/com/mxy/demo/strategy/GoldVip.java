package com.mxy.demo.strategy;

/**
 * @author Bruce_Mi
 * @version 1.0
 * @date 2021/5/27 9:54
 */
@PriceRegion(min=30000)
public class GoldVip implements Strategy{


    /**
     * 金牌会员价格
     * @param originallyPrice
     * @return
     */
    @Override
    public Double sellPrice(Double originallyPrice) {
        System.out.println("消费满30000为金牌会员打七折");
        return originallyPrice * 0.7;
    }
}
