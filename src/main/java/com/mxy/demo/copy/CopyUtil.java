package com.mxy.demo.copy;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruce_Mi
 * @version 1.0
 * @date 2021/5/24 17:08
 */
public class CopyUtil {



    /**
     * 对象复制
     */
    public static <T> T copy(Object source,Class<T> target){
        if(source == null){
            return null;
        }
        T obj = null;
        try {
             obj = target.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(source,obj);
        return obj;
    }

    /**
     * 列表复制
     */
    public static <T> List<T> copyList(List source, Class<T> clazz){
        List<T> target = new ArrayList<>();
        if(!CollectionUtils.isEmpty(source)){
            for (Object o : source) {
                T obj = copy(o,clazz);
                target.add(obj);
            }
        }
        return target;

    }
}
