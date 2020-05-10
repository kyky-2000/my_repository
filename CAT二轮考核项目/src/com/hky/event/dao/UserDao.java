package com.hky.event.dao;

import com.hky.event.entity.MoreInfo;
import com.hky.event.entity.User;

import java.util.Map;

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

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 查询个人信息
     * @param ID
     * @return
     */
    User showPersonalData(int ID);

    /**
     * 查询高光时刻的照片
     * @param ID
     * @return
     */
    MoreInfo searchHighLight(int ID);

    /**
     * 查询用户收到的私信
     * @param name
     * @return
     */
    Map<String, String> searchLetters(String name);

    /**
     * 查询转会历史
     * @param name
     * @return
     */
    Map<String, String> searchTransferHistory(String name);

    /**
     * 回复私信
     * @param master
     * @param guest
     * @param content
     * @return
     */
    boolean reply(String master, String guest, String content);

    /**
     * 用户举报处理
     * @param name
     * @param status
     * @return
     */
    int updateInfo(String name, String status);
}
