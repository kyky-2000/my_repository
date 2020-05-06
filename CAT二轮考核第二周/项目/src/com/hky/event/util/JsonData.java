package com.hky.event.util;

import com.hky.event.entity.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 封装  反序列json字符串并将其封装为任意对象  的工具类
 * @param <T>
 */
public class JsonData<T> {

    /**
     * 接收json字符串，返回任意数据对象
     * @param jsonString
     * @param objectClass
     * @return
     */
    public T packageJson(String jsonString, Class<T> objectClass){
//        Class objectClass = object.getClass();

        jsonString = jsonString.substring(1, jsonString.length()-1);
        String[] strings = jsonString.split(",");
        List key = new ArrayList();
        List<String> set = new ArrayList<String>();
        for(int i=0; i<strings.length; ++i){
            String[] strings1 = strings[i].split(":");
            key.add(strings1[0].substring(1, strings1[0].length()-1));
            set.add(strings1[1].substring(1, strings1[1].length()-1));
        }

        Object obj = null;
        try {
            obj = objectClass.newInstance();
            Field[] fields = objectClass.getDeclaredFields();
            for(int i=0; i<key.size(); ++i){
                Field field = null;
                for(int j=0; j<fields.length; ++j){
                    if(fields[j].getName().equals(key.get(i))){
                        field = fields[j];
                    }
                }
                String fieldName = (String)key.get(i);
                String methodName = getMethodNameByField("set", fieldName);
                Method method = objectClass.getDeclaredMethod(methodName, field.getType());
                String typeName = field.getType().getName();
                if(typeName.equals("int"))
                    method.invoke(obj, Integer.parseInt(set.get(i)));
                else
                    method.invoke(obj, (String)set.get(i));
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e){
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        } catch (InstantiationException e){
            e.printStackTrace();
        }


        return (T)obj;
    }

    /**
     * 获取getter、setter方法名称
     * @param type
     * @param name
     * @return
     */
    public String getMethodNameByField(String type, String name){
        return type + name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
    }

    /**
     * 测试效果
     * @param args
     */
//    public static void main(String[] args) {
//        String jsonString = "{\"name\":\"gf\",\"gender\":\"男\",\"age\":\"321\",\"mail\":\"sca\",\"lastTeam\":\"cas\",\"profile\":\"\",\"password\":\"csa\",\"identity\":\"战队管理层\"}";
//        User user = new User();
//        JsonData<User> jsonData = new JsonData<User>();
//        user = jsonData.packageJson(jsonString, User.class);
//        System.out.println(user);
//    }

}
