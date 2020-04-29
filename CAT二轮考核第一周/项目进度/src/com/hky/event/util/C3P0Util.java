package com.hky.event.util;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
    /**
     * 配置文件的名字只能叫c3p0-config.xml ，位置只能放在src的根目录下�??
     * 默认是去找default-config的配�?
     */
    private static ComboPooledDataSource dataSource=new ComboPooledDataSource();

    public static DataSource getDataSource(){
        return dataSource;

    }
}