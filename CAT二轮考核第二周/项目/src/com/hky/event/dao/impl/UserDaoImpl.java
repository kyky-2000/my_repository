package com.hky.event.dao.impl;

import com.hky.event.dao.UserDao;
import com.hky.event.dao.UtilDao;
import com.hky.event.entity.User;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private UtilDao utilDao = new UtilDaoImpl();
    public User login(String mail, String password){

        String sql = "select * from user where mail = ? and password = ?";
        Object[] params = {mail, password};
        User user = new User();
        List<User> list = utilDao.query(params, sql, user);
        user = list.get(0);
        return user;
    }

    public int register(User user){
        String sql = "insert into user(name, mail, password, lastTeam, profile, age, identity, head, gender) " +
                "value(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] params = {user.getName(), user.getMail(), user.getPassword(), user.getLastTeam(), user.getProfile(),
        user.getAge(), user.getIdentity(), user.getHead(), user.getGender()};

        return new UtilDaoImpl().update(sql, params);
    }


}
