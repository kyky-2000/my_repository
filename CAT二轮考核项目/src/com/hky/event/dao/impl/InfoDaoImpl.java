package com.hky.event.dao.impl;

import com.hky.event.dao.InfoDao;
import com.hky.event.dao.UtilDao;
import com.hky.event.entity.Condition;
import com.hky.event.entity.Information;
import com.hky.event.entity.MoreInfo;
import com.hky.event.entity.User;
import com.hky.event.service.InfoService;
import com.hky.event.util.DBUtil;
import sun.security.pkcs11.Secmod;

import javax.sound.midi.MidiDevice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InfoDaoImpl implements InfoDao {

    private UtilDao utilDao = new UtilDaoImpl();
    public int findTotalCount(String sql, Object[] params){
        System.out.println(params.length);
        return utilDao.queryForCount(sql, params);
    }

    public List<Information> searchInfo(String sql, Object[] params){

        List<Information> list = utilDao.query(params, sql, Information.class);

        return list;
    }

    public List<String> searchPhotos(){
        String sql = "select * from transfer_info order by salary desc limit 0, 3";
        Object[] params = null;
        return utilDao.query(params, sql, Information.class);
    }

    public int addInfo(Information information){
        String sql = "insert into transfer_info(name, introduce, gameCareer1,  gameCareer2, gameCareer3, salary, status) value(?, " +
                "?, ?, ?, ?, ?, '未通过') ";
        Object[] params = {information.getName(), information.getIntroduce(), information.getGameCareer1(), information.getGameCareer2(),
        information.getGameCareer3(), information.getSalary()};
        return utilDao.update(sql, params);
    }
}
