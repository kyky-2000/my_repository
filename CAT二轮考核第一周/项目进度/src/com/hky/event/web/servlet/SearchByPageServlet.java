package com.hky.event.web.servlet;

import com.hky.event.entity.Information;
import com.hky.event.entity.PageBean;
import com.hky.event.service.InfoService;
import com.hky.event.service.impl.InfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/searchByPageServlet")
public class SearchByPageServlet extends HttpServlet {
    private InfoService infoService = new InfoServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String currentPage = request.getParameter("currentPage");//当前页码
        String number = request.getParameter("row");//每页显示的记录数

        if(null==currentPage || "".equals(currentPage)){
            currentPage = "1";
        }
        if(null==number || "".equals(number)){
            number = "8";
        }

        Map<String, String[]> condition = request.getParameterMap();
        PageBean<Information> pb = infoService.searchInfo(currentPage, number, condition);

        request.setAttribute("pb", pb);
        request.setAttribute("condition", condition);
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
