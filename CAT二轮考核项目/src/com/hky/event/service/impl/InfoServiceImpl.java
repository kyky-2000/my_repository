package com.hky.event.service.impl;

import com.hky.event.dao.InfoDao;
import com.hky.event.dao.impl.InfoDaoImpl;
import com.hky.event.entity.Condition;
import com.hky.event.entity.Information;
import com.hky.event.entity.PageBean;
import com.hky.event.service.InfoService;

import javax.jnlp.ClipboardService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InfoServiceImpl implements InfoService {
    private InfoDao infoDao = new InfoDaoImpl();
    public PageBean<Information> searchInfo(Condition condition){
        int currentPage = condition.getCurrentPage();
        int number = condition.getNumber();

        if(currentPage <= 0){
            currentPage = 1;
        }
        if(number <= 0){
            number = 9;
        }
        PageBean<Information> pb = new PageBean<Information>();
        pb.setCurrentPage(currentPage);
        pb.setNumber(number);

        //遍历条件，组合到sql语句中
        String sql = "select count(*) from transfer_info where 1 = 1 ";
        String _sql = "select * from transfer_info where 1 = 1 ";

        StringBuilder sb = new StringBuilder(sql);
        StringBuilder _sb = new StringBuilder(_sql);
        List params = new ArrayList();
        if(condition.getName() != null) {
            sb.append(" and name like ? ");
            _sb.append(" and name like ? ");
            params.add("%" + condition.getName() + "%");
        }else if(condition.getGameCareer() != null) {
            sb.append(" and gameCareer1 like ? or gameCareer2 like ? or gameCareer3 like ? ");
            _sb.append(" and gameCareer1 like ? or gameCareer2 like ? or gameCareer3 like ? ");
            params.add("%" + condition.getGameCareer() + "%");
            params.add("%" + condition.getGameCareer() + "%");
            params.add("%" + condition.getGameCareer() + "%");
        }
        sb.append(" and status = '正常' ");
        _sb.append(" and status = '正常' ");
        int totalCount = 0;
        if(params.size() == 0){
            totalCount = infoDao.findTotalCount(sb.toString(), new Object[]{});
        }else
            totalCount = infoDao.findTotalCount(sb.toString(), new Object[]{params.get(0), params.get(1), params.get(2)});
        pb.setTotalCount(totalCount);

        int start = (currentPage - 1) * number;
        condition.setStart(start);
        //限制只查找一页
        _sb.append(" limit ?, ?");
        params.add(start);
        params.add(number);

        List<Information> list = null;
        if(params.size() == 2) {
            list = infoDao.searchInfo(_sb.toString(), new Object[]{params.get(0), params.get(1)});
        }else{
            list = infoDao.searchInfo(_sb.toString(), new Object[]{params.get(0), params.get(1), params.get(2), params.get(3), params.get(4)});
        }
        pb.setList(list);

        int totalPage = (totalCount % number)==0 ? (totalCount / number) : (totalCount / number)+1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    public List searchPhotos(){
         return infoDao.searchPhotos();
    }

    public boolean addInfo(Information information){
        if(1 == infoDao.addInfo(information)){
            return true;
        }else{
            return false;
        }
    }
}
