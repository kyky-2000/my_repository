package com.hky.event.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.hky.event.entity.User;
import com.hky.event.util.JsonData;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {

    /**
     * 测试图片上传及展示
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String head = request.getParameter("head");
//        System.out.println(head);
//        String itemPath = null;
//        try {
//            FileItemFactory factory = new DiskFileItemFactory();
//            ServletFileUpload upload = new ServletFileUpload(factory);
//            List<FileItem> items = upload.parseRequest(request);
//            for(FileItem item : items){
//
//                if(!item.isFormField()) {
//                    String fileName = item.getFieldName();
//                    System.out.println(fileName + "->" + item.getName());
//                    itemPath = item.getName();
//                    item.write(new File("D:\\servlet\\my_first_web\\web\\theme\\userImages", item.getName()));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        request.setAttribute("image", itemPath);
//        request.getRequestDispatcher("/test1.jsp").forward(request, response);
//    }


    /**
     * 测试json传输数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        request.setCharacterEncoding("utf-8");
//        //测试单选框的选择情况
//        //        String gender = request.getParameter("gender");
////        System.out.println(gender);
//
//
//        String json = request.getParameter("json");
//        System.out.println(json);
//        String json1 = "{\"head\":\"C:\\\\fakepath\\\\slide1.jpg\",\"name\":\"gf\",\"gender\":\"男\",\"age\":\"321\",\"mail\":\"sca\",\"lastTeam\":\"cas\",\"code\":\"sca\",\"profile\":\"\",\"password\":\"csa\",\"identity\":\"战队管理层\",\"test\":\"试试\"}";
//        ObjectMapper mapper = new ObjectMapper();
//        User user = null;
//        try {
//            user = mapper.readValue(json1, User.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(user);
//    }

    /**
     * 测试利用反射转发servlet
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");

        //将json封装成java对象
        String json = request.getParameter("json");
        System.out.println(json);
        JsonData<User> jsonData = new JsonData<User>();
        User user = (User)jsonData.packageJson(json, User.class);

        //执行相应的方法
        String methodName = request.getParameter("method");
        Class clazz = this.getClass();
        try {
            Method method = clazz.getMethod(methodName, User.class);
            try {
                method.invoke(this, user);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    public String testServlet(User user){
        System.out.println(user.toString());
        return null;
    }
}
