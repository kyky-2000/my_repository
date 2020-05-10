package com.hky.event.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.hky.event.entity.User;
import com.hky.event.util.JsonData;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {

    /**
     * 测试图片上传及展示
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String head = request.getParameter("head");
//        System.out.println(head);
//        String itemPath = null;
        try {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = upload.parseRequest(request);
            System.out.println(items.size());
            for(FileItem item : items){

                if(!item.isFormField()) {
                    String fileName = item.getFieldName();
                    System.out.println(fileName + "->" + item.getName());
//                    itemPath = item.getName();
                    item.write(new File("D:\\servlet\\my_first_web\\web\\theme\\userImages", item.getName()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().print("{\"result\": \" success\" }");
//        request.setAttribute("image", itemPath);
//        request.getRequestDispatcher("/test1.jsp").forward(request, response);
    }

//        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//        System.out.println(isMultipart);
//
//        if (isMultipart) {
//
//            ServletFileUpload upload = new ServletFileUpload();
//
//            upload.setHeaderEncoding("UTF-8");
//
//            int i = 0;
//
//            try {
//
//                FileItemIterator iter = upload.getItemIterator(request);
//
//                while (iter.hasNext()) {
//
//                    i++;
//
//                    FileItemStream fi = iter.next();
//
//                    InputStream in = null;
//
//                    OutputStream fileOut = null;
//
//                    try {
//
//                        String fileName = fi.getName();
//
//                        File file = new File("D:/servlet/my_first_web/web/theme/userImages/" + fileName.substring(0, fileName.lastIndexOf(".")) + "_" + i + fileName.substring(fileName.lastIndexOf(".")));
//
//                       System.out.println("D:/servlet/my_first_web/web/theme/userImages/" + fileName.substring(0, fileName.lastIndexOf(".")) + "_" + i + fileName.substring(fileName.lastIndexOf(".")));
//                        in = fi.openStream();
//
//                        ByteArrayOutputStream bstream = new ByteArrayOutputStream();
//
//
//                        Streams.copy(in, bstream, true);
//
//                        fileOut = new FileOutputStream(file);
//
//                        bstream.writeTo(fileOut);
//
//                    } catch (IOException e) {
//
//                        throw new RuntimeException("file copy error!", e);
//
//                    } finally {
//
//                        if (in != null) {
//
//                            try {
//
//                                in.close();
//
//                            } catch (IOException e) {
//
//                                e.printStackTrace();
//
//                            }
//
//                        }
//
//                        if (fileOut != null) {
//
//                            try {
//
//                                fileOut.close();
//
//                            } catch (IOException e) {
//
//                                e.printStackTrace();
//
//                            }
//
//                        }
//
//                    }
//
//                }
//
//            } catch (Exception e) {
//
//                throw new RuntimeException("upload file error.", e);
//
//            }
//
//        }
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
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        request.setCharacterEncoding("utf-8");
//
//
//        //将json封装成java对象
//        String json = request.getParameter("json");
//        System.out.println(json);
//        JsonData<User> jsonData = new JsonData<User>();
//        User user = (User)jsonData.packageJson(json, User.class);
//
//        //执行相应的方法
//        String methodName = request.getParameter("method");
//        Class clazz = this.getClass();
//        try {
//            Method method = clazz.getMethod(methodName, User.class);
//            try {
//                method.invoke(this, user);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//    }


//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        try {
//            List<FileItem> items = upload.parseRequest(request);
//            System.out.println("1:=========" + items.size());
//            Map param = new HashMap();
//            for (Object object : items) {
//                FileItem fileItem = (FileItem) object;
//                System.out.println("2:=========" + fileItem.toString());
//                System.out.println("3：fileItem.getFieldName():==" + fileItem.getFieldName());
//
//                if (fileItem.isFormField()) {
//                    param.put(fileItem.getFieldName(),
//                            fileItem.getString("utf-8"));// 如果你页面编码是utf-8的
//                    System.out.println("4: param.get(fileItem.getFieldName())==="
//                            + param.get(fileItem.getFieldName()));
//                } else {
//
////                    String picturename = fileItem.getName();
//
////                    String path = "D:\\temp\\" + picturename;
////                    System.out.println("=======================" + path + "==========");
//                    String path2 = "D:\\servlet\\my_first_web\\web\\theme\\userImages\\"
//                            + fileItem.getName();
//                    fileItem.write(new File(path2));
//                }
//            }
//        } catch (FileUploadException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

//    public String testServlet(User user){
//        System.out.println(user.toString());
//        return null;
//    }
}
