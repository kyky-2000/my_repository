package com.hky.event.dao.impl;

import com.hky.event.dao.UserDao;
import com.hky.event.entity.User;
import com.hky.event.util.C3P0Util;
import com.hky.event.util.DBUtil;
import com.hky.event.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    public User login(String mail, String password){
        User user = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = DBUtil.getConnection();
            String sql = "select * from user where mail = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, mail);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){
                user = new User();
                user.setID(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setMail(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setLastTeam(rs.getString(5));
                user.setProfile(rs.getString(6));
                user.setAge(rs.getInt(7));
                user.setIdentity(rs.getString(8));
                user.setStatus(rs.getString(9));
                user.setHead(rs.getString(10));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtil.close(conn, ps, rs);
        }
        return user;
    }

//    public boolean register(User user){
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        boolean registerSuccess = false;
//
//        try{
//            conn = DBUtil.getConnection();
//            String sql = "insert into user(name, mail, password, lastTeam, profile, age, identity, head) " +
//                    "value(?, ?, ?, ?, ?, ?, ?, ?)";
//            ps = conn.prepareStatement(sql);
//            ps.setString(1, user.getName());
//            ps.setString(2, user.getMail());
//            ps.setString(3, user.getPassword());
//            ps.setString(4, user.getLastTeam());
//            ps.setString(5, user.getProfile());
//            ps.setInt(6, user.getAge());
//            ps.setString(7, user.getIdentity());
//            ps.setString(8, user.getHead());
//
//            int count = ps.executeUpdate();
//            if(1 == count){
//                registerSuccess = true;
//            }
//        }catch(SQLException e){
//            e.printStackTrace();
//        }finally {
//            DBUtil.close(conn, ps, rs);
//        }
//
//        return registerSuccess;
//    }

    //Dao中保存用户的方法
    public void regist(User user) throws Exception {

        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        //QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        //写SQL语句
        String sql="insert into user(name, mail, password, lastTeam, profile, age, identity, code, gender, state) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Object[] params={user.getName(),user.getMail(),user.getPassword(),user.getLastTeam(),user.getProfile(),
                user.getAge(),user.getIdentity(),user.getCode(),user.getGender(),user.getState()};
        System.out.println(user.toString());
        // 更新语句
        queryRunner.update(sql,params);

    }

    @Override
    //Dao中根据激活码来查询用户的方法
    public User findByCode(String code) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql="select * from user where code = ?";
        User user=queryRunner.query(sql,new BeanHandler<User>(User.class), code);
        return user;
    }

    @Override
    //Dao中修改用户的方法
    public void update(User user) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql="update user set state=?,code=? where uid=?";

        Object[] params={user.getState(),user.getCode(),user.getID()};
        // 更新语句
        queryRunner.update(sql,params);

    }


}
