package com.mxy.demo.strategy;

/**
 * @author Bruce_Mi
 * @version 1.0
 * @date 2021/5/27 9:54
 */
@PriceRegion(min=20000,max=30000)
public class SuperVip implements Strategy{


    /**
     * 超级会员价格
     * @param originallyPrice
     * @return
     */
    @Override
    public Double sellPrice(Double originallyPrice) {
        System.out.println("消费满20000为超级会员打8折");
        return originallyPrice * 0.8;
    }
}
