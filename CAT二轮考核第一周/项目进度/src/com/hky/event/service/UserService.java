package com.hky.event.service;

import com.hky.event.entity.User;

public interface UserService {

    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);

//    /**
//     * 用户注册
//     * @param user
//     * @return
//     */
//    boolean register(User user);

    void regist(User user) throws Exception;

    User findByCode(String code) throws Exception;

    void update(User user)throws Exception;
}
