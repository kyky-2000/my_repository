package com.hky.event.service.impl;

import com.hky.event.dao.InfoDao;
import com.hky.event.dao.impl.InfoDaoImpl;
import com.hky.event.entity.Information;
import com.hky.event.entity.PageBean;
import com.hky.event.service.InfoService;

import java.util.List;
import java.util.Map;

public class InfoServiceImpl implements InfoService {
    private InfoDao infoDao = new InfoDaoImpl();
    public PageBean<Information> searchInfo(String _currentPage, String _number, Map<String, String[]> condition){
        int currentPage = Integer.parseInt(_currentPage);
        int number = Integer.parseInt(_number);

        if(currentPage <= 0){
            currentPage = 1;
        }

        PageBean<Information> pb = new PageBean<Information>();

        pb.setCurrentPage(currentPage);
        pb.setNumber(number);

        int totalCount = infoDao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        int start = (currentPage - 1) * number;
        List<Information> list = infoDao.searchInfo(start, number, condition);
        pb.setList(list);

        int totalPage = (totalCount % number)==0 ? (totalCount / number) : (totalCount / number)+1;
        pb.setTotalPage(totalPage);

        return pb;
    }
}
