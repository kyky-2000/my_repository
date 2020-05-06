package com.hky.event.service.impl;

import com.hky.event.dao.UserDao;
import com.hky.event.dao.impl.UserDaoImpl;
import com.hky.event.entity.User;
import com.hky.event.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    public User login(User user){
        return userDao.login(user.getMail(), user.getPassword());

    }

    public String register(User user){


        boolean result = false;
        if(1 == userDao.register(user))
            result = true;
        return null;
    }

//    //业务层用户注册的方法：
//    public void regist(User user) throws Exception {
//        //将数据存入到数据库
//        userDao.regist(user);
//
//        //发送一封激活邮件
//        /**
//         * 直接用发写好的工具类发送邮件
//         */
//        MailUtils.sendMail(user.getMail(), user.getCode());
//
//    }
//
//    @Override
//    //根据激活码查找用户
//    public User findByCode(String code) throws Exception {
//
//        return userDao.findByCode(code);
//    }
//
//    @Override
//    //业务层修改用户的方法
//    public void update(User user) throws Exception {
//        userDao.update(user);
//
//    }

}
