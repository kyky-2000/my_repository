package com.hky.event.dao.impl;

import com.hky.event.dao.InfoDao;
import com.hky.event.entity.Information;
import com.hky.event.service.InfoService;
import com.hky.event.util.DBUtil;
import sun.security.pkcs11.Secmod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InfoDaoImpl implements InfoDao {
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
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Information> list = null;

        String sql = "select * from transfer_info where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        ArrayList<Object> params = new ArrayList<Object>();
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

        sb.append(" limit ?, ?");

        params.add(start);
        params.add(number);
        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            int i = 0;
            for(i=0; i<params.size()-2; ++i){
                ps.setString(i+1, params.get(i).toString());
            }
            ps.setInt(i+1, ((Integer)params.get(i)));
            ps.setInt(i+2, ((Integer)params.get(i+1)));
            list = new ArrayList<Information>();
            rs = ps.executeQuery();
            while(rs.next()){
                Information info = new Information();
                info.setpID(rs.getInt(1));
                info.setpName(rs.getString(2));
                info.setpIntroduce(rs.getString(3));
                info.setGameCareer1(rs.getString(4));
                info.setGameCareer2(rs.getString(5));
                info.setGameCareer3(rs.getString(6));
                info.setPhoto(rs.getString(7));
                list.add(info);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtil.close(conn, ps, rs);
        }
        return list;
    }
}
