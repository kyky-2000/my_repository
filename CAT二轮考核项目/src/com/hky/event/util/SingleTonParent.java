package com.hky.event.util;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhao.wu on 2016/11/18.
 */
public class SingleTonParent{
    private static Map<Class<? extends SingleTonParent>, SingleTonParent> INSTANCES_MAP = new HashMap<>();

    public synchronized static <E extends SingleTonParent> SingleTonParent getInstance(Class<E> instanceClass) throws Exception {
        if(INSTANCES_MAP.containsKey(instanceClass)){
            return INSTANCES_MAP.get(instanceClass);
        } else {
            E instance = instanceClass.newInstance();
            INSTANCES_MAP.put(instanceClass, instance);
            return instance;
        }
    }

    protected SingleTonParent(){
    }
}