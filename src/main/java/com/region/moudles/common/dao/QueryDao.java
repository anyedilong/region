package com.region.moudles.common.dao;

import com.region.moudles.common.domain.PageModel;
import com.region.until.DateUntil;
import com.region.until.StringUntil;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.io.BufferedReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.sql.Clob;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryDao {
     
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Inject
    private EntityManager entityManager;

    //单条数据
    protected <T> T  queryOne(String sql,Object obj,Class<T> t){
        Map<String,Object> map=new HashMap<String,Object>();
        if(!StringUntil.isNull(obj)){
            if(obj instanceof  Map){
                 map=(Map<String,Object>)obj;
            } else if(obj.getClass() instanceof  Class<?>){
                 getParam(sql,map,obj);
            }
        }
        List<T> list = queryResultList(sql,map,0, 1, t);
        if (null != list && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    //分页
    protected  <T> void queryPage(String sql, Object obj, PageModel page, Class<T> t){
        Map<String,Object> map=new HashMap<String,Object>();
           if(!StringUntil.isNull(obj)){
               if(obj instanceof  Map){
                   map=(Map<String,Object>)obj;
               } else if(obj.getClass() instanceof  Class<?>){
                   getParam(sql,map,obj);
               }
           }

        long count=queryCount(sql, map);
        page.setCount(count);
        List<T> list = queryResultList(sql,map,page.getNumIndex()-1,page.getPageSize(), t);
        if(list!=null&&list.size()>0) {
            page.setList(list);
        }

    }
    protected long queryCount(String sql, Map<String, Object> paramMap) {
        String countSql = String.format("select count(1) from ( %s ) tmp_count", sql);
        Query query = createNativeQuery(countSql, paramMap);
        Object obj = query.getSingleResult();
        if (obj != null) {
            return StringUntil.toLong(obj);
        }
        return 0;
    }
    //集合
    protected  <T> List<T> queryList(String sql,Object obj,Class<T> t){
        Map<String,Object> map=new HashMap<String,Object>();
        if(!StringUntil.isNull(obj)){
            if(obj instanceof  Map){
                map=(Map<String,Object>)obj;
            } else if(obj.getClass() instanceof  Class<?>){
                getParam(sql,map,obj);
            }
        }
        List<T> list = queryResultList(sql,map, 0, 0, t);
        return list;
    }

    /**
     * 结果集
     * @param sql
     * @param map
     * @param firstIndex
     * @param maxResult
     * @param clazz
     * @param <T>
     * @return
     */
    private <T> List<T> queryResultList(String sql,Map<String,Object> map,int firstIndex, int maxResult,Class<T> clazz){
        Query query = createNativeQuery(sql, map);
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        if (firstIndex > 0) {
            query.setFirstResult(firstIndex);
        }

        if (maxResult > 0) {
            query.setMaxResults(maxResult);
        }
        List<Map<String,Object>> listResult=query.getResultList();
        
        logger.info(String.format("SQL为:%s", sql));
		logger.info(String.format("参数为:%s", map));
        
        if(clazz==Map.class){
             return  (List<T>)listResult;
        }
        // 为基本数据类型
        if (clazz.isPrimitive() || clazz == String.class || clazz == Integer.class || clazz == Long.class
                || clazz == Double.class || clazz == Float.class || clazz == Date.class) {
            return mapToBasicType(clazz,listResult);
        }
        if (listResult != null && listResult.size() > 0) {
            return mapToObjectList(clazz, listResult);
        }
        return null;
    }

    public <T> List<T> mapToObjectList(Class<T> clazz, List<Map<String,Object>> listResult){
        if (listResult != null && listResult.size() > 0) {
            List<T> list = new ArrayList<T>();

            Map<String, Field> fieldMap = getField(clazz);
            // 如果为基本数据类型，则返回

            for (Map<String, Object> resultMap : listResult) {

                T obj = mapToObject(fieldMap, clazz, resultMap);
                if (null != obj) {
                    list.add(obj);
                }
            }
            return list;
        }
        return null;
    }

    public <T> List<T> mapToBasicType(Class<T> clazz,List<Map<String, Object>> resultMapList){
             if(resultMapList!=null&&resultMapList.size()>0){
                 List list = new ArrayList();
                 for(Map<String, Object> resultMap : resultMapList){
                     for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
                            list.add(getValue(clazz,entry.getValue()));
                     }
                 }
                 return list;
             }
             return  null;
    }

    public Object getValue(Type type,Object obj){
        if (type == int.class || type == Integer.class) {
            return StringUntil.toInteger(obj);
        } else if (obj instanceof Clob) {
			 return ClobToString((Clob)obj);
		} else if (type == String.class) {
            return StringUntil.toString(obj);
        } else if (type == boolean.class) {
            return StringUntil.toBoolean(obj);
        } else if (type == float.class || type == Float.class) {
            return StringUntil.toFloat(obj);
        } else if (type == double.class || type == Double.class) {
            return StringUntil.toDouble(obj);
        } else if (type == long.class || type == Long.class) {
            return StringUntil.toDouble(obj);
        } else if (type == Date.class) {
            return DateUntil.parseDate(obj);
        } else {
            if (type instanceof Map) {
                Map<String, Field> fieldMap = getField((Class) type);
                return mapToObject(fieldMap, (Class) type, (Map) obj);
            }
        }

        return null;
    }
    private <T> T mapToObject(Map<String, Field> fieldMap, Class<T> clazz, Map<String, Object> resultMap){
        if (resultMap != null) {
            try {
                T object = clazz.newInstance();
                for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
                    String key = entry.getKey();
                    key = key.toUpperCase().replace("_", "");
                    Object value = entry.getValue();
                    if (null == value) {
                        continue;
                    }
                    if (fieldMap.containsKey(key)) {
                        Field field = fieldMap.get(key);
                        // 得到property对应的setter方法
                        try {
                            Method method = clazz.getMethod(getSetMethodName(field.getName()), field.getType());
                            method.invoke(object, getValue(field.getType(), value));
                        } catch (Exception e) {
                        	logger.error(String.format("%s字段转换失败", key));
                        	e.printStackTrace();
                        }
                    }
                }
                return object;
            } catch (InstantiationException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        return null;
    }

    public Map<String,Field>  getField(Class clazz){
        Map<String, Field> fieldMap = new HashMap<String, Field>();
        Field[] f = clazz.getDeclaredFields();
        List<Field[]> flist = new ArrayList<Field[]>();
        flist.add(f);
        Class superClazz = clazz.getSuperclass();
        while (superClazz != null) {
            f = superClazz.getDeclaredFields();
            flist.add(f);
            superClazz = superClazz.getSuperclass();
        }
        // 遍历所有属性
        for (Field[] fields : flist) {
            for (Field field : fields) {
                String fieldName = field.getName();
                // 将其转为 大写
                fieldName = fieldName.toUpperCase().replace("_", "");
                fieldMap.put(fieldName, field);
            }
        }
        return fieldMap;

    }

    /**
     * 调取query
     * @param sql
     * @param map
     * @return
     */
    private Query createNativeQuery(String sql, Map<String, Object> map) {
        Query query = createNativeQuery(sql);

        if (null != map) {
            // 遍历参数
            for (String key : map.keySet()) {
                Object value = map.get(key);
                query.setParameter(key, value);
            }
        }
        return query;
    }
    private Query createNativeQuery(String sql) {
        Assert.notNull(sql, "SQL must not be null!");
        return entityManager.createNativeQuery(sql);
    }

    //obj转map
    public void getParam(String sql,Map<String,Object> map,Object obj){
        Pattern pattern = Pattern.compile("\\:[0-9a-zA-z|-|_|.]*");
         Matcher matcher=pattern.matcher(sql);
         while (matcher.find()){
                  String key=matcher.group(0).substring(1);
                  if(!map.containsKey(key)){
                       Object object=getValue(obj,key);
                       map.put(key, object);

                  }
         }

    }
    //获取对象加内容
    public Object  getValue( Object obj,String key){
          Class clazz=obj.getClass();
          try {
              Method method=clazz.getMethod(getMethodValue(key));
              Object object=method.invoke(obj);
              return  object;
          }catch (Exception e){
              e.printStackTrace();
          }
               return  null;
    }

    //获取get对象值
    public String getMethodValue(String key){
        StringBuffer methodName = new StringBuffer("get");

        if (StringUntil.isNull(key)) {
            return "";
        }
        if(key.length()>1){
              String fiedTwo=key.substring(1,2);
              if(!fiedTwo.equals(fiedTwo.toUpperCase())){
                  String start=key.substring(0,1).toUpperCase();
                  methodName.append(start);
              }else{
                  methodName.append(key.substring(0,1));
              }
              methodName.append(key.substring(1));
              return  methodName.toString();
        }else{
             return    key.toUpperCase();
        }
    }

    /**
     * set赋值
     * @param fieldName
     * @return
     */
    private String getSetMethodName(String fieldName) {
        StringBuffer methodName = new StringBuffer("set");

        if (StringUntil.isNull(fieldName)) {
            return "";
        }

        if (fieldName.length() > 1) {
            // 判断第二个字母
            String fieldTwo = fieldName.substring(1, 2);
            if (!fieldTwo.equals(fieldTwo.toUpperCase())) {
                methodName.append(fieldName.substring(0, 1).toUpperCase());
            } else {
                methodName.append(fieldName.substring(0, 1));
            }
            methodName.append(fieldName.substring(1, fieldName.length()));
            return methodName.toString();
        } else {
            return fieldName.toUpperCase();
        }
    }
    public String ClobToString(Clob clob) {
		try {
			String reString = "";
			Reader is = clob.getCharacterStream();
			BufferedReader br = new BufferedReader(is);
			String s = br.readLine();
			StringBuffer sb = new StringBuffer();
			while (s != null) {
				sb.append(s);
				s = br.readLine();
			}
			reString = sb.toString();
			if(br!=null){
				br.close();
			}
			if(is!=null){
				is.close();
			}
			return reString;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
