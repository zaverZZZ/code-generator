package org.zaver.code.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : PackageName
 * @Description TODO
 * @Date : 2019/4/6 16:04
 * @Author ABC
 * @Version 1.0
 * @Explanation ：
 */
public enum Enums {
    TABLE_PREFIX(""),
    PACKAGE_NAME("com.zaver.test"),
    MODELPACK_NAME("model"),
    DAOPACK_NAME("dao"),
    MAPPERPACK_NAME("mapper"),
    SERVICEPACK_NAME("service"),
    IMPLPACK_NAME("impl"),
    CONTROLLERPACK_NAME("controller"),
    JAVA_FILE("java"),
    XML_FILE("xml");
    //private int id;
    private String value;

    Enums(String value){
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    /*public void setValue(String value) {
        this.value = value;
    }*/
/*
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }



    *//**通过ID获取对应的枚举,不存在则返回null *//*
    public static Enums valueOf(int id){
        Enums[] values = Enums.values();
        for (Enums obj : values) {
            if(obj.getId() == id){
                return obj;
            }
        }
        return null;
    }


    *//**通过ID获取NAME,不存在则返回"" *//*
    public static String getName(int id) {
        Enums[] values = Enums.values();
        for (Enums obj : values) {
            if(obj.getId() == id){
                return obj.getName();
            }
        }
        return "";
    }


    *//**获取该枚举类id:name键值对的List*//*
    public static List<Map<Integer,String>> getValuesList(){
        List<Map<Integer,String>> list = new ArrayList<Map<Integer,String>>();
        Enums[] values = Enums.values();
        for (Enums obj : values) {
            Map<Integer,String> map = new HashMap<Integer,String>();
            map.put(obj.getId(), obj.getName());
            list.add(map);
        }
        return list;

    }

    *//**获取该枚举类id:name键值对的List*//*
    public static Map<String,String> niceVoList(){
        HashMap<String,String> map  = new HashMap<String,String>();
        Enums[] values = Enums.values();
        for (Enums obj : values) {

            map.put(obj.getId()+"", obj.getName());

        }
        return map;

    }


    @Override
    *//**如果使用JsonUtils.toJSONString必须这样重写toString方法*//*
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"id\":").append(this.id).append(",\"name\":\"").append(this.name).append("\"}");
        return builder.toString();
    }*/
}
