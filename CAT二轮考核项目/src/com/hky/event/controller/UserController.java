package com.hky.event.controller;

import com.hky.event.annotation.Mapping;
import com.hky.event.entity.Condition;
import com.hky.event.entity.MoreInfo;
import com.hky.event.entity.ResultInfo;
import com.hky.event.entity.User;
import com.hky.event.service.UserService;
import com.hky.event.service.impl.UserServiceImpl;
import com.hky.event.util.JsonData;
import com.hky.event.util.SingleTonParent;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.taglibs.standard.lang.jstl.GreaterThanOperator;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Random;

@Mapping("user")
public class UserController {
    private  UserService userService = new UserServiceImpl();
    @Mapping("login")
    public ResultInfo login(User user, HttpServletRequest request){
        String checkCode = user.getCheckCode1();
        String _checkCode = (String) request.getSession().getAttribute("_checkCode");
        if(!checkCode.equalsIgnoreCase(_checkCode)){
            return new ResultInfo(500, "验证码错误", null);
        }
        user = userService.login(user);
        if(user == null){
            return new ResultInfo(500, "账号不存在", null);
        }else if(user.getStatus().equals("被封禁")) {
            return new ResultInfo(500, "您已被封禁，登录失败", null);
        }else if(user.getStatus().equals("未通过")){
            return new ResultInfo(500, "服务器繁忙", null);
        }else {
            return new ResultInfo(200, "登录成功", user);
        }
    }

    @Mapping("checkCode")
    public void checkCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //服务器通知浏览器不要缓存
        response.setHeader("pragma","no-cache");
        response.setHeader("cache-control","no-cache");
        response.setHeader("expires","0");

        //在内存中创建一个长80，宽30的图片，默认黑色背景
        //参数一：长
        //参数二：宽
        //参数三：颜色
        int width = 80;
        int height = 30;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //获取画笔
        Graphics g = image.getGraphics();
        //设置画笔颜色为灰色
        g.setColor(Color.GRAY);
        //填充图片
        g.fillRect(0,0, width,height);

        //产生4个随机验证码，12Ey
        String checkCode = getCheckCode();
        //将验证码放入HttpSession中
        request.getSession().removeAttribute("_checkCode");
        request.getSession().setAttribute("_checkCode",checkCode);

        //设置画笔颜色为黄色
        g.setColor(Color.YELLOW);
        //设置字体的小大
        g.setFont(new Font("黑体",Font.BOLD,24));
        //向图片上写入验证码
        g.drawString(checkCode,15,25);

        //将内存中的图片输出到浏览器
        //参数一：图片对象
        //参数二：图片的格式，如PNG,JPG,GIF
        //参数三：图片输出到哪里去
        ImageIO.write(image,"PNG",response.getOutputStream());
    }

    private String getCheckCode() {
        String base = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int size = base.length();
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= 4; i++) {
            //产生0到size-1的随机值
            int index = r.nextInt(size);
            //在base字符串中获取下标为index的字符
            char c = base.charAt(index);
            //将c放入到StringBuffer中去
            sb.append(c);
        }
        return sb.toString();
    }

    @Mapping("sendMailCode")
    public ResultInfo sendMailCode(User user){
        String mail = user.getMail();
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

        ResultInfo<String> resultInfo = new ResultInfo();
        resultInfo.setCode(200);
        resultInfo.setMsg("发送成功");
        resultInfo.setData(code);
        return resultInfo;
    }

    @Mapping("register")
    public ResultInfo register(User user){
        String mailCode1 = user.getMailCode1();
        String mailCode2 = user.getMailCode2();
        if(!mailCode1.equalsIgnoreCase(mailCode2)){
            return new ResultInfo(500, "您输入的验证码有误", null);
        }

        boolean result = userService.register(user);
        ResultInfo resultInfo = new ResultInfo(200, "注册成功，请耐心等待管理员审核", null);
        if(result){
            return resultInfo;
        }else{
            resultInfo.setCode(500);
            resultInfo.setMsg("服务器繁忙");
            return resultInfo;
        }

    }

    @Mapping("upload")
    public void upload(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String itemPath = null;
        try {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = upload.parseRequest(request);
            for(FileItem item : items){

                if(!item.isFormField()) {
                    itemPath = item.getName();
                    item.write(new File("D:\\servlet\\my_first_web\\web\\theme\\userImages", item.getName()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("head", itemPath);
        ResultInfo resultInfo = new ResultInfo(200, "上传成功", itemPath);
        JsonData jsonData = (JsonData) SingleTonParent.getInstance(JsonData.class);
        response.getWriter().print(jsonData.getJson(resultInfo));

    }

    @Mapping("update")
    public ResultInfo update(User user){
        if(userService.update(user)){
            return new ResultInfo(200, "修改成功", user);
        }else{
            return new ResultInfo(500, "服务器繁忙", null);
        }
    }

    @Mapping("showPersonalData")
    public ResultInfo showPersonalData(User user, HttpServletRequest request){
        MoreInfo moreInfo = userService.showPersonalData(user);
        request.getSession().setAttribute("ID", user.getID());
        ResultInfo resultInfo = new ResultInfo(200, "查找成功", moreInfo);
        return resultInfo;
    }

    @Mapping("searchPersonalData")
    public void searchPersonalData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ID = (Integer) request.getSession().getAttribute("ID");
        System.out.println(ID);
        User user = userService.searchPersonalData(ID);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    @Mapping("reply")
    public ResultInfo reply(Condition condition){
        boolean result = userService.reply(condition);
        if(result)
            return new ResultInfo(200, "修改成功", null);
        else
            return new ResultInfo(500, "服务器繁忙", null);
    }

    @Mapping("updateInfo")
    public ResultInfo updateInfo(Condition condition){
        boolean result = userService.updateInfo(condition);
        if(result == true){
            return new ResultInfo(200, "举报成功", null);
        }else{
            return new ResultInfo(500, "服务器繁忙", null);
        }
    }
}
