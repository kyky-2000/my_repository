package com.hky.event.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hky.event.dao.UserDao;
import com.hky.event.dao.UtilDao;
import com.hky.event.dao.impl.UserDaoImpl;
import com.hky.event.dao.impl.UtilDaoImpl;
import com.hky.event.entity.User;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    /**
     * 测试邮件发送
      * @param args
     * @throws Exception
     */
//    public static void main(String[] args) {
//        try {
//            HtmlEmail email = new HtmlEmail();
//            email.setHostName("smtp.qq.com");
//            email.setCharset("utf-8");
//            String mail = "3533547008@qq.com";
//            email.addTo(mail);
//            email.setFrom("2243592288@qq.com", "2243592288@qq.com");
//            email.setAuthentication("2243592288@qq.com", "rcplvkopbaklebcd");
//            email.setSubject("来看看");
//            email.setMsg("1234");
//            email.send();
//            System.out.println("发送成功");
//        } catch (EmailException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) throws Exception{
        /**
         * 测试反射封装数据
         */
//        User user = new User();
//        Class userClass = user.getClass();
//        Field[] fields = userClass.getDeclaredFields();
//        for(int j=0; j<fields.length; ++j){
//            Field field = fields[j];
//            String type = field.getType().getName();
//            String methodName = getMethodNameByField("get", field.getName());
//            Method method = userClass.getMethod(methodName);
//            System.out.println(field.getName());
//            if(type.equals("int")){
//                method.invoke(user, 1);
//            }else if(type.equals("java.lang.String")){
//                method.invoke(user, "oooo");
//            }
//        }
//        for(int i=0; i<fields.length; ++i){
//            Field field = fields[i];
//            String methodName = getMethodNameByField("get", field.getName());
//            Method method = userClass.getMethod(methodName);
//
//            System.out.println(methodName);
//        }
//        System.out.println(user.toString());


        /**
         * 测试UtilDao的效果
         */
//        UtilDao utilDao = new UtilDaoImpl();
//        User user = new User();
//        String sql1 = "select * from user";
//        String sql2 = "update user set identity = '职业选手' where name = ? and age = ?";
//        Object[] params = {"uzi", 25};
//        utilDao.update(sql2, params);
//        List<User> list = (List<User>)utilDao.query(null, sql1, user);
//        for(int i=0; i<list.size(); ++i){
//            System.out.println(list.get(i).toString());
//        }

        /**
         * 测试用jsckson将json封装成java对象
         */
        try {
            String json1 = "{\"head\":\"C:\\\\fakepath\\\\slide1.jpg\",\"name\":\"gf\",\"gender\":\"男\",\"age\":\"321\",\"mail\":\"sca\",\"lastTeam\":\"cas\",\"profile\":\"\",\"password\":\"csa\",\"identity\":\"战队管理层\"}";
            String[] s = json1.split(",");
            for(int i=0; i<s.length; ++i){
                System.out.println(s[i]);
            }
//            ObjectMapper mapper = new ObjectMapper();
//            User user = mapper.readValue(json1, User.class);
//            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



//    public static String getMethodNameByField(String type, String name){
//        return type + name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
//    }

}

