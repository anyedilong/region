package com.region.until.validate;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 校验工具类
 */
public class ValidateUtil {


    /**
     * 数据校验
     *
     * @param obj
     */
    public static void compare(Object obj, String[] patternArray) {
        if (obj == null) {

        }
        if (obj instanceof Map) {

        }
        if (obj instanceof Collection) {

        }
        if (obj.getClass() instanceof Class<?>) {
            vldClass(obj);
        }
    }

    private static void vldClass(Object obj) {
        Class clazz = obj.getClass();
        if (clazz == String.class || clazz == Float.class || clazz == Integer.class || clazz == Long.class || clazz == Double.class || clazz.isPrimitive()) {

        } else {

        }
    }

    private void getFild(Class clazz){
        Field[] fields=clazz.getDeclaredFields();
        List<Field[]> list=new ArrayList<>();
           list.add(fields);
          Class superclass=clazz.getSuperclass();
          while (superclass!=null){
               Field[] fields1=superclass.getDeclaredFields();
               list.add(fields1);
              superclass=superclass.getSuperclass();
          }
          for(Field[] fied:list){

        }

    }


    /**
     * 利用正则表达式判断字符串是否是数字
     *
     * @param str
     * @return
     */
    public boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}
