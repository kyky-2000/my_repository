package com.hky.event.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hky.event.dao.UserDao;
import com.hky.event.dao.UtilDao;
import com.hky.event.dao.impl.UserDaoImpl;
import com.hky.event.dao.impl.UtilDaoImpl;
import com.hky.event.entity.*;
import com.hky.event.util.JsonData;
import com.hky.event.web.servlet.BaseServlet;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
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

//    public static void main(String[] args) throws Exception{
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
         * 结果：成功
         */
//        try {
//            String json1 = "{\"head\":\"C:\\\\fakepath\\\\slide1.jpg\",\"name\":\"gf\",\"gender\":\"男\",\"age\":\"321\",\"mail\":\"sca\",\"lastTeam\":\"cas\",\"profile\":\"\",\"password\":\"csa\",\"identity\":\"战队管理层\"}";
//            String[] s = json1.split(",");
//            for(int i=0; i<s.length; ++i){
//                System.out.println(s[i]);
//            }
////            ObjectMapper mapper = new ObjectMapper();
////            User user = mapper.readValue(json1, User.class);
////            System.out.println(user);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//    }

    public static void main(String[] args) throws NoSuchMethodException {
        /**
         * 测试resultInfo转化成json1
         * User对象
         * 结果：成功
         */
//        User user1 = new User();
//        user1.setName("try");
//        user1.setAge(100);
//        user1.setStatus("casav");
//        User user2 = new User();
//        user2.setName("try");
//        user2.setAge(100);
//        user2.setStatus("casav");
//        User user3 = new User();
//        user3.setName("try");
//        user3.setAge(100);
//        user3.setStatus("casav");
//        List list = new ArrayList();
//        list.add(user1);
//        list.add(user2);
//        list.add(user3);
//        ResultInfo resultInfo = new ResultInfo(200, "登录成功", list);
//        JsonData jsonData = JsonData.getInstance();
//        String json = jsonData.getJson(resultInfo);
//        System.out.println(json);

        /**
         * 测试resultInfo转化成json2
         * PageBean对象
         * 结果：成功
         */
//        PageBean<Information> pageBean = new PageBean();
//        Information information1 = new Information();
//        information1.setGameCareer1("打野");
//        information1.setGameCareer2("中路");
//        information1.setName("大佬");
//        Information information2 = new Information();
//        information2.setGameCareer1("下路");
//        information2.setGameCareer2("辅助");
//        information2.setName("强人");
//        Information information3 = new Information();
//        information3.setGameCareer1("下路");
//        information3.setGameCareer2("中路");
//        information3.setName("牛逼");
//        List list = new ArrayList();
//        list.add(information1);
//        list.add(information2);
//        list.add(information3);
//
//        pageBean.setCurrentPage(1);
//        pageBean.setList(list);
//        pageBean.setNumber(3);
//        pageBean.setCurrentPage(1);
//
//        ResultInfo<PageBean> resultInfo = new ResultInfo<>(200, "cg？", pageBean);

//        JsonData jsonData = JsonData.getInstance();
//        String json = jsonData.getJson(resultInfo);
//        System.out.println(json);

        /**
         * 测试数组的赋值
         */
//        List<Object> list = new ArrayList<>();
////        System.out.println(list.get(0).toString());
////        Object object = list.get(0);
//        if(list.size() == 0){
//            System.out.println("空了");
//        }


//        User user = new User();
//        if(user == null){
//            System.out.println("空了");
//        }


    }



//    public static String getMethodNameByField(String type, String name){
//        return type + name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
//    }

}

