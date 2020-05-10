package com.hky.event.dao.impl;

import com.hky.event.dao.ManagerDao;
import com.hky.event.dao.UtilDao;
import com.hky.event.entity.Information;
import com.hky.event.entity.User;

import java.util.List;

public class ManagerDaoImpl implements ManagerDao {
    private UtilDao utilDao = new UtilDaoImpl();
    public List<User> searchUsersByStatus(String status){
        String sql = "select * from user where status = ?";
        Object[] params = {status};
        List<User> list = utilDao.query(params, sql, User.class);
        return list;
    }

    public List<Information> searchInfoByStatus(String status){
        String sql = "select * from transfer_info where status = ?";
        Object[] params = {status};
        List<Information> list = utilDao.query(params, sql, Information.class);
        return list;
    }

    public int update(String sql, Object[] params){
        return utilDao.update(sql, params);
    }
}
