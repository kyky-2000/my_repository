package com.hky.event.dao;

import com.hky.event.entity.Information;

import java.util.List;
import java.util.Map;

public interface InfoDao {
    /**
     * 查询总信息条数
     * @param condition
     * @return
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 查询一页的选手转会信息
     * @param start
     * @param number
     * @param condition
     * @return
     */
    List<Information> searchInfo(int start, int number, Map<String, String[]> condition);


}
