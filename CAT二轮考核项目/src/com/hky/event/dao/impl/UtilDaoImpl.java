package com.hky.event.dao.impl;

import com.hky.event.annotation.Mapping;
import com.hky.event.dao.UtilDao;
import com.hky.event.util.DBUtil;
import com.hky.event.util.JsonData;
import org.apache.commons.beanutils.converters.SqlDateConverter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilDaoImpl<T> implements UtilDao<T>{
//    private UtilDaoImpl(){};
//
//    private static class JsonDataInstance{
//        private static final JsonData INSTANCE = new JsonData();
//    }
//
//    public static JsonData getInstance(){
//        return JsonDataInstance.INSTANCE;
//    }

    public int update(String sql, Object[] params){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            for(int i=0; params!=null&&i<params.length; ++i){
                ps.setObject(i+1, params[i]);
            }
            count = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtil.close(conn, ps, rs);
        }
        return count;
    }

    public List<T> query(Object[] params, String sql, Class objClass){
        List<T> list = new ArrayList<>();
//        Class objClass = object.getClass();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            for(int i=0; params!=null&&i<params.length; ++i){
                ps.setObject(i+1, params[i]);
            }
            rs = ps.executeQuery();
            while(rs.next()){
                Object obj = objClass.newInstance();
                Field[] fields = objClass.getFields();
                for(int i=0; i<fields.length; ++i){
                    Field field = fields[i];
                    String typeName = field.getType().getName();
                    String methodName = getMethodNameByField("set", field.getName());
                    Method method = objClass.getMethod(methodName, field.getType());
                    if(typeName.equals("int")) {
                        method.invoke(obj, rs.getInt(field.getName()));
                    }else if(typeName.equals("java.lang.String")){
                        method.invoke(obj, rs.getString(field.getName()));
                    }
                }
                list.add((T)obj);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NoSuchMethodException e){
            e.printStackTrace();
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }catch(InvocationTargetException e) {
            e.printStackTrace();
        }catch(InstantiationException e){
            e.printStackTrace();
        }finally{
            DBUtil.close(conn, ps, rs);
        }
        return list;
    }

    public String getMethodNameByField(String type, String name){
        return type + name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
    }

    public int queryForCount(String sql, Object[] params){
        System.out.println(params.length);
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            for(int i=0; i<params.length; ++i){
                ps.setObject(i+1, params[i]);
            }
            rs = ps.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        return count;
    }

    public Map<String, String> queryForStringMap(String sql, Object[] params) {
        Map<String, String> map = new HashMap<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            for(int i=0; i<params.length; ++i){
                ps.setObject(i+1, params[i]);
            }
            rs = ps.executeQuery();
            while(rs.next()){
                map.put(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

}
