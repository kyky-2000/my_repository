package com.hky.event.dao;

import com.hky.event.entity.Information;
import com.hky.event.entity.User;

import java.util.List;

public interface ManagerDao {

    /**
     * 管理员查找需要处理的所有用户
     * @param status
     * @return
     */
    List<User> searchUsersByStatus(String status);

    /**
     * 管理员查找需要处理的所有订单
     * @param status
     * @return
     */
    List<Information> searchInfoByStatus(String status);

    /**
     * 修改用户或转会信息的状态或直接删除
     * @param sql
     * @param params
     * @return
     */
    int update(String sql, Object[] params);
}
