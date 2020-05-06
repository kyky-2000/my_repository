package com.hky.event.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hky.event.entity.User;
import com.hky.event.service.UserService;
import com.hky.event.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        String _code = (String)session.getAttribute("code");
        session.removeAttribute("code");
        String code = request.getParameter("code");
        String data = request.getParameter("json");
        System.out.println(data);
        if(!_code.equals(code)){
            request.setAttribute("register_msg", "注册失败");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }

        Map<String, String[]> map = request.getParameterMap();
        String head = request.getParameter("head");
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        String itemPath = null;
        try {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = upload.parseRequest(request);
            for(FileItem item : items){
                if(!item.isFormField()) {
                    String fileName = item.getFieldName();
                    System.out.println(fileName + "->" + item.getName());
                    itemPath = item.getName();
                    item.write(new File("D:\\servlet\\my_first_web\\web\\theme\\userImages", item.getName()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        user.setHead(itemPath);
        String register_msg = userService.register(user);


//        Boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//        if(!isMultipart){
//            System.out.println("没有照片，不传了");
//            return;
//        }

        try {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = upload.parseRequest(request);
            for(FileItem item : items){

                if(!item.isFormField()) {
                    String fileName = item.getFieldName();
                    System.out.println(fileName + "->" + item.getName());
                    item.write(new File("D:/", item.getName()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Map<String, String[]> map = request.getParameterMap();
//        User user = new User();
//
//        try {
//            BeanUtils.populate(user, map);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//        user.setState(0);
//        //  UUIDUtils.getUUID()默认32位，若不够，在+32位
//        String code = UUIDUtils.getUUID()+ UUIDUtils.getUUID();
//        user.setCode(code);
//
//        System.out.println(user.toString());

//        try {
//            userService.regist(user);
//            //页面跳转
//            request.setAttribute("msg", "您已经注册成功！请去邮箱激活~");
//            request.getRequestDispatcher("/msg.jsp").forward(request, response);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
