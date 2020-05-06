package com.hky.event.web.servlet;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet("/sendCodeServlet")
public class SendCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String mail = request.getParameter("mail");
        String code = getCheckCode();

        HtmlEmail email = new HtmlEmail();
        try {
            email.setHostName("smtp.qq.com");
            email.setCharset("utf-8");
            email.addTo(mail);
            email.setFrom("2243592288@qq.com", "2243592288@qq.com");
            email.setAuthentication("2243592288@qq.com", "rcplvkopbaklebcd");
            email.addHeader("X-Mailer","Microsoft Outlook Express 6.00.2900.2869");
            email.setSubject("验证码来啦");
            email.setMsg(code);
            email.send();
            System.out.println("发送成功");
        } catch (EmailException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        session.setAttribute("_code", code);
        request.setAttribute("register_msg", "验证码发送成功");
    }

    private String getCheckCode() {
        String base = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int size = base.length();
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=4;i++){
            //产生0到size-1的随机值
            int index = r.nextInt(size);
            //在base字符串中获取下标为index的字符
            char c = base.charAt(index);
            //将c放入到StringBuffer中去
            sb.append(c);
        }
        return sb.toString();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
