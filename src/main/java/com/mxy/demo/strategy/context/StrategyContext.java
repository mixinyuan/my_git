package com.mxy.demo.strategy.context;

import com.mxy.demo.strategy.*;

/**
 * @author Bruce_Mi
 * @version 1.0
 * @date 2021/5/27 10:01
 */
public class StrategyContext {


    //持有一个具体策略的对象
    private Strategy strategy;

    /**
     * 构造函数，传入一个具体策略对象
     * @param strategy    具体策略对象
     */
    public StrategyContext(Strategy strategy){
        this.strategy = strategy;
    }

    /**
     * 策略方法
     */
    public Double sellPrice(Double originallyPrice){
        return this.strategy.sellPrice(originallyPrice);
    }

}
