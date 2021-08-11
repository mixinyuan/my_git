package com.mxy.demo.strategy.player;

import com.mxy.demo.strategy.*;
import com.mxy.demo.strategy.factory.StrategyFactory;


/**
 * @author Bruce_Mi
 * @version 1.0
 * @date 2021/5/27 10:18
 */
public class Player {

    // 总共消费金额
    private Double totalAmount = 0D;

    //单次消费金额
    private Double amount  = 0D;

    private Strategy strategy;

    //开始消费
    public void buy(Double amount){
        this.amount = amount;
        this.totalAmount += amount;
        strategy = StrategyFactory.getInstance().crateStrategy(this);
    }
    /**
     * 打折后应该的消费金额
     * @return
     */
    public Double getAmount(){
        return strategy.sellPrice(amount);
    }

    public Double getTotalAmount(){
        return this.totalAmount;
    }
    public static void main(String[] args){
//        Class<Player> clazz = Player.class;
//        Class<Player> aClass2 = (Class<Player>)ClassLoader.getSystemClassLoader().loadClass(clazz.getName());
//
//        Class<? extends Player> aClass = new Player().getClass();
//        Class<?> aClass1 = Class.forName("com.mxy.demo.strategy.player.Player");
        Player player = new Player();
        player.buy(5000D);
        System.out.println("总消费金额:"+player.getTotalAmount()+"=========>"+ "本次消费打折后应该为"+ player.getAmount());
        player.buy(15000D);
        System.out.println("总消费金额:"+player.getTotalAmount()+"=========>"+ "本次消费打折后应该为"+ player.getAmount());
        player.buy(9000D);
        System.out.println("总消费金额:"+player.getTotalAmount()+"=========>"+ "本次消费打折后应该为"+ player.getAmount());
        player.buy(2000D);
        System.out.println("总消费金额:"+player.getTotalAmount()+"=========>"+ "本次消费打折后应该为"+ player.getAmount());
    }

}
