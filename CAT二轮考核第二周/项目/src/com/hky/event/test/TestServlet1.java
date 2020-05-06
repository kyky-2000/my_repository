package com.hky.event.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet1 extends TestServlet {
    public String testServlet(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("success......");
        return null;
    }
}
