package com.hky.event.service;

import com.hky.event.entity.Condition;
import com.hky.event.entity.MoreInfo;
import com.hky.event.entity.User;

public interface UserService {

    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 用户注册
     * @param user
     * @return
     */
    boolean register(User user);

//    void regist(User user) throws Exception;
//
//    User findByCode(String code) throws Exception;

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    boolean update(User user);

    /**
     * 个人主页展示信息
     * @param user
     * @return
     */
    MoreInfo showPersonalData(User user);

    /**
     * 回复私信
     * @param condition
     * @return
     */
    boolean reply(Condition condition);

    /**
     * 修改信息之前进行回写
     * @param ID
     * @return
     */
    User searchPersonalData(int ID);

    /**
     * 举报用户处理
     * @param condition
     * @return
     */
    boolean updateInfo(Condition condition);
}
