package com.hky.event.web.servlet;

import com.hky.event.entity.User;
import com.hky.event.service.UserService;
import com.hky.event.service.impl.UserServiceImpl;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        int ID = (Integer) request.getSession().getAttribute("ID");
        User user = userService.searchPersonalData(ID);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/update.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request,response);
	}
}



