package com.hky.event.service.impl;

import com.hky.event.dao.ManagerDao;
import com.hky.event.dao.impl.ManagerDaoImpl;
import com.hky.event.entity.Condition;
import com.hky.event.entity.Information;
import com.hky.event.entity.User;
import com.hky.event.service.ManagerService;

import java.util.List;

public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao = new ManagerDaoImpl();
    public List<User> searchUsersByStatus(Condition condition){
        List<User> list = managerDao.searchUsersByStatus(condition.getStatus());
        return list;
    }
    public List<Information> searchInfoByStatus(Condition condition){
        List<Information> list = managerDao.searchInfoByStatus(condition.getStatus());
        return list;
    }

    public boolean delete(Condition condition){
        String sql;
        if(condition.getName().equals("User")){
            sql = "delete from user where ID = ?";
        }else{
            sql = "delete from transfer_info where ID = ?";
        }
        Object[] params = {condition.getID()};
        if(managerDao.update(sql, params) == 1){
            return true;
        }else{
            return false;
        }
    }

    public boolean update(Condition condition){
        String sql;
        if(condition.getName().equals("User")){
            sql = "update user set status = ? where ID = ?";
        }else{
            sql = "update transfer_info set status = ? where ID = ?";
        }
        Object[] params = {condition.getStatus(), condition.getID()};
        if(managerDao.update(sql, params) == 1){
            return true;
        }else{
            return false;
        }
    }

}
