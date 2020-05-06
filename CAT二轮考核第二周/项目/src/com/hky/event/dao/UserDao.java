package com.hky.event.dao;

import com.hky.event.entity.User;

public interface UserDao {
    /**
     * 登录
     * @param mail
     * @param password
     * @return
     */
    User login(String mail, String password);

    /**
     * 用户注册
     * @param user
     * @return
     */
    int register(User user);

//    void regist(User user) throws Exception;
//
//    User findByCode(String code) throws Exception;
//
//    void update(User user)throws Exception;
}
