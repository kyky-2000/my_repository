package com.hky.event.util;

import java.util.UUID;
public class UUIDUtils {
    //生成随机字符串的工具类
    public static String getUUID(){
        //取消短-
        return UUID.randomUUID().toString().replace("-", "");

    }

}