package com.hky.event.service;

import com.hky.event.entity.Information;
import com.hky.event.entity.PageBean;

import java.util.Map;

public interface InfoService {
    /**
     *
     * @param currentPage
     * @param number
     * @param condition
     * @return
     */
    PageBean<Information> searchInfo(String currentPage, String number, Map<String, String[]> condition);
}
