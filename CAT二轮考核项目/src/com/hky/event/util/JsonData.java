package com.hky.event.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hky.event.entity.ResultInfo;
import com.hky.event.entity.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装  反序列json字符串并将其封装为任意对象  的工具类
 * @param <T>
 */
public class JsonData<T> extends SingleTonParent{

//    private JsonData(){};
//
//    private static class JsonDataInstance{
//        private static final JsonData INSTANCE = new JsonData();
//    }
//
//    public static JsonData getInstance(){
//        return JsonDataInstance.INSTANCE;
//    }

    /**
     * 接收json字符串，返回任意数据对象
     * @param jsonString
     * @param objectClass
     * @return
     */
    public T packageJson(String jsonString, Class<T> objectClass){

        if(jsonString==null || jsonString.equalsIgnoreCase("")){
            return null;
        }
        System.out.println(jsonString);
        jsonString = jsonString.substring(1, jsonString.length()-1);
        String[] strings = jsonString.split(",");
        Map<String, String> map = new HashMap<String, String>();
        for(int i=0; i<strings.length; ++i){
            String[] strings1 = strings[i].split(":");
            map.put(strings1[0].substring(1, strings1[0].length()-1), strings1[1].substring(1, strings1[1].length()-1));
        }

        Object obj = null;
        try {
            obj = objectClass.newInstance();
            for(String key : map.keySet()){
                Field field = objectClass.getDeclaredField(key);
                String fieldName = key;
                String methodName = getMethodNameByField("set", fieldName);
                Method method = objectClass.getDeclaredMethod(methodName, field.getType());
                String typeName = field.getType().getName();
                if(typeName.equals("int")) {
                    method.invoke(obj, Integer.parseInt(map.get(key)));
                }
                else
                    method.invoke(obj, map.get(key));
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e){
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        } catch (InstantiationException e){
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
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

    public String getJson(ResultInfo resultInfo){
        int code = resultInfo.getCode();
        String msg = resultInfo.getMsg();
        T data = (T)resultInfo.getData();
        String json = null;

        ObjectMapper objectMapper = new ObjectMapper();

        try {
//            if(data.getClass().equals(User.class)){
//                dataJson = objectMapper.writeValueAsString(data);
//            }
            Map<String, Object> map = new HashMap<>();
            map.put("code", code);
            map.put("msg", msg);
            map.put("data", data);
            json = objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 测试效果
     * @param args
     */
//    public static void main(String[] args) {
//        String jsonString = "{\"name\":\"gf\",\"gender\":\"男\",\"age\":\"321\",\"mail\":\"sca\",\"lastTeam\":\"cas\",\"profile\":\"\",\"password\":\"csa\",\"identity\":\"战队管理层\"}";
//        User user = new User();
////        JsonData<User> jsonData = new JsonData<User>();
//        try {
//            user = (User)((JsonData)SingleTonParent.getInstance(JsonData.class)).packageJson(jsonString, User.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(user);
//    }

}
