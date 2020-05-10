package com.hky.event.dao;

import java.util.List;
import java.util.Map;

public interface UtilDao<T> {
    /**
     * 封装查询方法
     * @param params
     * @param sql
     * @param objClass
     * @return
     */
    List<T> query(Object[] params, String sql, Class<?> objClass);

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

    /**
     * 查询记录的条数
     * @param sql
     * @param params
     * @return
     */
    int queryForCount(String sql, Object[] params);

    /**
     * 查询用户私信
     * @param sql
     * @param params
     * @return
     */
    Map<String, String> queryForStringMap(String sql, Object[] params);
}
