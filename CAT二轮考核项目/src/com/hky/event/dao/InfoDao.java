package com.hky.event.dao;

import com.hky.event.entity.Condition;
import com.hky.event.entity.Information;

import java.util.List;
import java.util.Map;

public interface InfoDao {
    /**
     * 查询总信息条数
     * @param sql
     * @param params
     * @return
     */
    int findTotalCount(String sql, Object[] params);

    /**
     * 查询一页的选手转会信息
     * @param sql
     * @param params
     * @return
     */
    List<Information> searchInfo(String sql, Object[] params);

    /**
     * 查找放在首页轮播图的三张图片
     * @return
     */
    List<String> searchPhotos();

    /**
     * 申请转会
     * @param information
     * @return
     */
    int addInfo(Information information);

}
