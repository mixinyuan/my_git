package com.mxy.demo.strategy.factory;

import com.mxy.demo.strategy.*;
import com.mxy.demo.strategy.player.Player;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruce_Mi
 * @version 1.0
 * @date 2021/5/27 10:35
 */
public class StrategyFactory {

    private static final String STRATEGY_PACKAGE = "com.mxy.demo.strategy";

    private ClassLoader classLoader = getClass().getClassLoader();

    private volatile static StrategyFactory instance = null;

    // 双重校验锁
    public static StrategyFactory getInstance(){
        if(instance == null){
            synchronized (StrategyFactory.class){
                if(instance == null){
                    instance = new StrategyFactory();
                }
            }
        }
        return instance;
    }
    //静态内部类
//    public static StrategyFactory getInstance(){
//        return StrategyFactoryInstance.instance;
//    }
//
//    private static class StrategyFactoryInstance{
//        private static StrategyFactory instance = new StrategyFactory();
//    }
    //单例
    private StrategyFactory(){
        init();
    }
    //所有的策略列表
    private  List< Class<? extends Strategy>> strategyList;

    /**
     * 根据输入金额获取对应的策略类
     * @param player
     * @return
     */
    public  Strategy crateStrategy(Player player){
        for (Class<? extends Strategy> clazz : strategyList) {
            PriceRegion priceRegion = handleAnnotation(clazz);
            if(player.getTotalAmount() >= priceRegion.min() && player.getTotalAmount() < priceRegion.max()){
                try {
                    return clazz.newInstance();
                } catch (Exception e) {
                    throw new RuntimeException("策略获取失败!");
                }
            }
        }
        throw new RuntimeException("策略获得失败");
    }
    /**
     * 返回策略类的注解
     * @param clazz
     * @return
     */
    public  PriceRegion handleAnnotation(Class<? extends Strategy> clazz){
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        if(annotations == null || annotations.length == 0){
            return null;
        }
        for (int i = 0; i < annotations.length; i++) {
            if(annotations[i] instanceof PriceRegion){
                return (PriceRegion)annotations[i];
            }
        }
        return null;
    }
    /**
     * 初始化策略列表
     */
    public void init(){
        strategyList = new ArrayList<>();
        //获取到包下所有的class文件
        String[] resources = getResources();
        Class<Strategy> strategyClazz;
        try {
            strategyClazz = (Class<Strategy>)classLoader.loadClass(Strategy.class.getName());
        } catch (Exception e) {
            throw new RuntimeException("未找到策略接口");
        }
        for (int i = 0; i < resources.length; i++) {
            try {
//                Class<?> clazz = classLoader.loadClass(STRATEGY_PACKAGE +"."+ resources[i].replace(".class",""));
                Class<?> clazz = Class.forName(STRATEGY_PACKAGE + "." + resources[i].replace(".class", ""));
                if(Strategy.class.isAssignableFrom(clazz) && clazz != strategyClazz){
                    strategyList.add((Class<? extends Strategy>) clazz);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取包下面所以的.class文件名(不包含全路径)
     * @return
     */
    private String[] getResources(){
        try {
            File file = new File(classLoader.getResource(STRATEGY_PACKAGE.replace(".", "/")).toURI());
            //只获取.class文件
//            File[] files = file.listFiles(pathname -> pathname.getName().endsWith(".class"));
            return file.list((dir, name) -> name.endsWith(".class"));
        } catch (URISyntaxException e) {
            throw new RuntimeException("未找到策略资源");
        }
    }

}