package com.hky.event.web.servlet;

import com.hky.event.annotation.Mapping;
import com.hky.event.entity.ResultInfo;
import com.hky.event.util.GetAllClasses;
import com.hky.event.util.JsonData;
import com.hky.event.util.SingleTonParent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * 中转servlet：接收前端的数据，封装好传到controller层相应的方法
 */
@WebServlet("/baseServlet/*")
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");

        String json = request.getParameter("json");
        String requestURI = request.getRequestURI();
        String[] uri = requestURI.split("/");
        String classPath = uri[2];
        String methodPath = uri[3];
        List<String> classNames = GetAllClasses.getClassName("com.hky.event.controller");
        for(String className : classNames){
            try {
                Class<?> clazz = Class.forName(className);
                if(clazz.isAnnotationPresent(Mapping.class)){
                    String value = clazz.getAnnotation(Mapping.class).value();
                    if(value.equals(classPath)){
                        for(Method method : clazz.getDeclaredMethods()){
                            if(method.isAnnotationPresent(Mapping.class) && method.getAnnotation(Mapping.class).value().equals(methodPath)){
                                Parameter[] parameters = method.getParameters();
                                if(parameters[0].getType().equals(HttpServletRequest.class)){
                                    method.invoke(clazz.newInstance(), request, response);
                                    return;
                                }else{
                                    //    JsonData jsonData = JsonData.getInstance();
                                    JsonData jsonData = (JsonData)SingleTonParent.getInstance(JsonData.class);
                                    ResultInfo resultInfo = null;
                                    if(parameters.length > 1){
                                        resultInfo = (ResultInfo) method.invoke(clazz.newInstance(),
                                                jsonData.packageJson(json, parameters[0].getType()), request);
                                    }else{
                                        resultInfo = (ResultInfo) method.invoke(clazz.newInstance(),
                                            jsonData.packageJson(json, parameters[0].getType()));
                                    }
                                    System.out.println(jsonData.getJson(resultInfo));
                                    response.getWriter().print(jsonData.getJson(resultInfo));
                                }
                            }
                        }
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


//    public List<String> getClassName(String packageName) {
//        String filePath = ClassLoader.getSystemResource("").getPath() + packageName.replace(".", "\\");
//        List<String> fileNames = getClassName(filePath, null);
//        return fileNames;
//    }
//
//    private List<String> getClassName(String filePath, List<String> className) {
//        List<String> myClassName = new ArrayList<String>();
//        File file = new File(filePath);
//        File[] childFiles = file.listFiles();
//        for (File childFile : childFiles) {
//            if (childFile.isDirectory()) {
//                myClassName.addAll(getClassName(childFile.getPath(), myClassName));
//            } else {
//                String childFilePath = childFile.getPath();
//                childFilePath = childFilePath.substring(childFilePath.indexOf("\\production") + 25, childFilePath.lastIndexOf("."));
//                childFilePath = childFilePath.replace("\\", ".");
//                myClassName.add(childFilePath);
//            }
//        }
//
//        return myClassName;
//    }
}
