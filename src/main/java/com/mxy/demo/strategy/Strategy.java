package com.mxy.demo.strategy;

/**
 * @author Bruce_Mi
 * @version 1.0
 * @date 2021/5/27 9:48
 */
public interface Strategy {

    /**
     *      假设鹅厂推出了3种会员，分别为会员，超级会员以及金牌会员，
     *      还有就是普通玩家，针对不同类别的玩家，购买《王者农药》皮肤
     *      有不同的打折方式，并且一个顾客每消费10000就增加一个级别，
     *      那么我们就可以使用策略模式，因为策略模式描述的就是算法的不同，
     *      这里我们举例就采用最简单的，以上四种玩家分别采用原价（普通玩家），
     *      九折，八折和七价的收钱方式。
     * @param originallyPrice
     * @return
     */

    Double sellPrice(Double originallyPrice);
}
