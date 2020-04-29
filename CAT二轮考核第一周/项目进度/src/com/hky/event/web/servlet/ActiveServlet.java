package com.hky.event.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hky.event.entity.User;
import com.hky.event.service.UserService;
import com.hky.event.service.impl.UserServiceImpl;

@WebServlet("/activeServlet")
public class ActiveServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //接收激活码
            String code = request.getParameter("code");
            //根据激活码查用户
            System.out.println("code值："+code);
            UserService userService = new UserServiceImpl();

            User user=userService.findByCode(code);

            if(user!=null){
                //已经查询到，修改用户状态
                user.setState(1);//状态变为1
                user.setCode(null);//状态码，点击一次就失效了
                userService.update(user);
                request.setAttribute("msg", "恭喜你已经激活成功！请登录~");

            }else{
                //根据激活码没有查询到该用户
                request.setAttribute("msg", "您的激活码有误，请重新激活！");
            }
            //页面跳转
            request.getRequestDispatcher("/msg.jsp").forward(request, response);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

}