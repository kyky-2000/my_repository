package com.hky.event.dao;

import java.util.List;

public interface UtilDao<T> {
    /**
     * 封装查询方法
     * @param params
     * @param sql
     * @param object
     * @return
     */
    List<T> query(Object[] params, String sql, Object object);

    /**
     * 封装增删改方法
     * @param sql
     * @param params
     * @return
     */
    int update(String sql, Object[] params);

    /**
     * 获取getter、setter方法，名称的方法
     * @param type
     * @param name
     * @return
     */
    String getMethodNameByField(String type, String name);
}
