package com.hky.event.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GetAllClasses {

    public static List<String> getClassName(String packageName) {
//        String path = ClassLoader.getSystemResource("").getPath();
//        String filePath = path + packageName.replace(".", "\\");
        List<String> fileNames = getClassName(null, null);
        return fileNames;
    }

    private static List<String> getClassName(String filePath, List<String> className) {
        List<String> myClassName = new ArrayList<String>();
        filePath = "D:\\servlet\\my_first_web\\out\\production\\my_first_web\\com\\hky\\event\\controller";
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
