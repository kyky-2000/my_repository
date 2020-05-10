package com.hky.event.service;

import com.hky.event.entity.Condition;
import com.hky.event.entity.Information;
import com.hky.event.entity.PageBean;
import com.hky.event.entity.User;

import java.util.List;
import java.util.Map;

public interface InfoService {
    /**
     *查询转会信息
     * @param condition
     * @return
     */
    PageBean<Information> searchInfo(Condition condition);

    /**
     * 查找展示在首页轮播图的图片
     * @return
     */
    List searchPhotos();

    /**
     * 申请转会
     * @param information
     * @return
     */
    boolean addInfo(Information information);

}
