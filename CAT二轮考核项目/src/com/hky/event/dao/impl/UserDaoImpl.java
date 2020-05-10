package com.hky.event.dao.impl;

import com.hky.event.dao.UserDao;
import com.hky.event.dao.UtilDao;
import com.hky.event.entity.Condition;
import com.hky.event.entity.MoreInfo;
import com.hky.event.entity.User;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {

    private UtilDao utilDao = new UtilDaoImpl();
    public User login(String mail, String password){

        String sql = "select * from user where mail = ? and password = ? and (status = '正常' or status = '被举报')";
        Object[] params = {mail, password};
        User user = null;
        List<User> list = utilDao.query(params, sql, User.class);
        if(list.size() != 0)
            user = list.get(0);
        return user;
    }

    public int register(User user){
        String sql = "insert into user(head, name, mail, password, lastTeam, profile, age, identity, head, gender, joinDate, status) " +
                "value(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '未通过')";
        Object[] params = {user.getHead(), user.getName(), user.getMail(), user.getPassword(), user.getLastTeam(), user.getProfile(),
        user.getAge(), user.getIdentity(), user.getHead(), user.getGender(), user.getJoinDate()};

        return utilDao.update(sql, params);
    }

    public int update(User user){
        String sql = "update user set name = ?, password = ?, lastTeam = ?, profile = ?, age = ?, gender = ? , joinDate = ? where ID = ?";
        Object[] params = {user.getName(), user.getPassword(), user.getLastTeam(), user.getProfile(), user.getAge(),
                 user.getGender(), user.getJoinDate(), user.getID()};
        return utilDao.update(sql, params);
    }

    public User showPersonalData(int ID){
        String sql = "select * from user where ID = ?";
        Object[] params = {ID};
        List<User> list = utilDao.query(params, sql, User.class);
        if(list.size() != 0){
            return list.get(0);
        }else{
            return null;
        }
    }

    public MoreInfo searchHighLight(int ID){
        String sql = "select * from highlight where ID = ?";
        Object[] params = {ID};
        List<MoreInfo> list =  utilDao.query(params, sql, MoreInfo.class);
        return list.get(0);
    }

    public Map<String, String> searchLetters(String name){
        String sql = "select guest, content from letter where master = ?";
        Object[] params = {name};
        Map<String, String> map = utilDao.queryForStringMap(sql, params);
        return map;
    }

    public Map<String, String> searchTransferHistory(String name){
        String sql = "select team, date from transfer_history where name = ?";
        Object[] params = {name};
        Map<String, String> map = utilDao.queryForStringMap(sql, params);
        return map;
    }

    public boolean reply(String master, String guest, String content){
        String sql = "insert into letter(master, guest, content) value(?, ?, ?)";
        Object[] params = {master, guest, content};
        if(1 == utilDao.update(sql, params))
            return true;
        return false;
    }

    public int updateInfo(String name, String status){
        String sql = "update user set status = ? where name = ?";
        Object[] params = {status, name};
        return utilDao.update(sql, params);
    }
}
