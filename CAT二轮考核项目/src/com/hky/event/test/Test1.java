package com.hky.event.test;

import com.hky.event.util.GetAllClasses;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test1 {

//    public static void main(String[] args) {
//        String packageName = "com.hky.event.controller";
//
//        List<String> classNames = GetAllClasses.getClassName("com.hky.event.controller");
//        for (String className : classNames) {
//            System.out.println(className);
//        }
//    }

    public void bb(HttpServletRequest request){
        Method[] methods = null;

        methods = (Test1.class).getDeclaredMethods();
        for(Method method1 : methods){
            System.out.println(method1);
        }
    }

//    public void aa(HttpServletRequest request){
//    }

    public static List<String> getClassName(String packageName) {
        String filePath = ClassLoader.getSystemResource("").getPath() + packageName.replace(".", "\\");
        List<String> fileNames = getClassName(filePath, null);
        return fileNames;
    }

    private static List<String> getClassName(String filePath, List<String> className) {
        List<String> myClassName = new ArrayList<String>();
        File file = new File(filePath);
        File[] childFiles = file.listFiles();
        for (File childFile : childFiles) {
            if (childFile.isDirectory()) {
                myClassName.addAll(getClassName(childFile.getPath(), myClassName));
            } else {
                String childFilePath = childFile.getPath();
                childFilePath = childFilePath.substring(childFilePath.indexOf("\\production") + 25, childFilePath.lastIndexOf("."));
                childFilePath = childFilePath.replace("\\", ".");
                myClassName.add(childFilePath);
            }
        }

        return myClassName;
    }
}