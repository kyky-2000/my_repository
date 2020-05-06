package com.hky.event.dao.impl;

import com.hky.event.dao.InfoDao;
import com.hky.event.dao.UtilDao;
import com.hky.event.entity.Information;
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
    public int findTotalCount(Map<String, String[]> condition){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int totalCount = 0;

        String sql = "select count(*) from transfer_info where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        ArrayList<String> params = new ArrayList<String>();
        for(String key : keySet){
            if("currentPage".equals(key) || "number".equals(key)){
                continue;
            }

            String value = condition.get(key)[0];

            if(value != null && !"".equals(value)){
                sb.append(" and " + key + " like ? ");
                params.add("%" + value + "%");
            }
        }

        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            for(int i=0; i<params.size(); ++i){
                ps.setString(i+1, params.get(i));
            }
            rs = ps.executeQuery();
            totalCount = rs.getInt(1);

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtil.close(conn, ps, rs);
        }
        return totalCount;
    }

    public List<Information> searchInfo(int start, int number, Map<String, String[]> condition){

        String sql = "select * from transfer_info where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        ArrayList<Object> _params = new ArrayList<Object>();

        //将查找条件加入sql语句
        for(String key : keySet){
            if("currentPage".equals(key) || "number".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if(value != null && !"".equals(value)){
                sb.append(" and " + key + " like ? ");
                _params.add("%" + value + "%");
            }
        }
        //限制只查找一页
        sb.append(" limit ?, ?");
        _params.add(start);
        _params.add(number);
        //这里需要一个params数组来调用查找方法，所以做个转化
        Object[] params = new Object[]{};
        for(int i=0; i<_params.size(); ++i){
            params[i] = _params.get(i);
        }

        Information info = new Information();
        List<Information> list = utilDao.query(params, sql, info);
        return list;
    }
}
