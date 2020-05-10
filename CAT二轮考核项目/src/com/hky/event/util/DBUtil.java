package com.hky.event.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 工具类，简化数据库登录操作
 */
public class DBUtil {
    private DBUtil(){
    }
    static{
        try{
//            Properties prop=new Properties();
//            prop.load(new FileInputStream("../jdbc.properties"));
//            String driver = prop.getProperty("driver");
//            Class.forName(driver);

            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException{
//        Properties prop=new Properties();
//        try {
//            prop.load(new FileInputStream("../jdbc.properties"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        String url = "jdbc:mysql://localhost:3306/hky_event";
        String user = "root";
        String password = "369";
        return DriverManager.getConnection(url,
                user, password);
    }
    public static void close(Connection conn, Statement stmt, ResultSet rs){
        if(rs != null)
            try{
                rs.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        if(stmt != null)
            try{
                stmt.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        if(conn != null)
            try{
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
    }
}
