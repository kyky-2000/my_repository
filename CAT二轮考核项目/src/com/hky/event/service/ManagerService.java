package com.hky.event.service;

import com.hky.event.entity.Condition;
import com.hky.event.entity.Information;
import com.hky.event.entity.User;

import java.util.List;

public interface ManagerService {

    /**
     * 管理员查找要处理的用户
     * @param condition
     * @return
     */
    List<User> searchUsersByStatus(Condition condition);

    /**
     * 管理员查找要处理的转会信息
     * @param condition
     * @return
     */
    List<Information> searchInfoByStatus(Condition condition);

    /**
     * 删除数据库的用户信息或转会信息
     * @param condition
     * @return
     */
    boolean delete(Condition condition);

    /**
     * 修改用户信息或转回信息的状态
     * @param condition
     * @return
     */
    boolean update(Condition condition);
}
