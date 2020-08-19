package com.region.until;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.DateUtils;

import static jdk.nashorn.internal.objects.NativeString.trim;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUntil {


    public static boolean isNull(Object obj) {
        return null == obj || "".equals(obj);
    }

    /**
     * 转换为Integer类型
     */
    public static Integer toInteger(Object val) {
        return toLong(val).intValue();
    }

    /**
     * 转换为Long类型
     */
    public static Long toLong(Object val) {
        return toDouble(val).longValue();
    }

    /**
     * 转换为Double类型
     */
    public static Double toDouble(Object val) {
        if (val == null) {
            return 0.00;
        }
        try {
            return Double.valueOf(trim(val.toString()));
        } catch (Exception e) {
            return 0.00;
        }
    }

    /**
     * 转换为String类型
     */
    public static String toString(Object val) {
        if (val == null) {
            return "";
        }
        return val.toString();
    }

    public static Boolean toBoolean(Object obj) {
        Boolean Bl = new Boolean(toString(obj));
        boolean bl = Bl.booleanValue();
        return bl;
    }

    /**
     * 转换为Float类型
     */
    public static Float toFloat(Object val) {
        return toDouble(val).floatValue();
    }

    /**
     * 转换为字节数组
     *
     * @param str
     * @return
     */
    public static byte[] getBytes(String str) {
        if (str != null) {
            try {
                return str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 转换为字符串
     *
     * @param
     * @return
     */
    public static String toString(byte[] bytes) {
        try {
            return new String(bytes, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static JSONObject checkPage(JSONObject page) {
        if (page == null) {
            page = new JSONObject();
        }
        String pageNo = page.getString("pageNo");
        if (StringUtils.isBlank(pageNo)) {
            page.put("pageNo", 1);
        }
        String pageSize = page.getString("pageSize");
        if (StringUtils.isBlank(pageNo)) {
            page.put("pageSize", 10);
        }
        return page;
    }

    //根据身份证号计算年龄
    public static String getAge(String sfzh) {
        if (StringUtils.isBlank(sfzh))
            return "";
        int leh = sfzh.length();
        String dates = "";
        if (leh == 18) {
            dates = sfzh.substring(6, 10);
            SimpleDateFormat df = new SimpleDateFormat("yyyy");
            String year = df.format(new Date());
            int u = Integer.parseInt(year) - Integer.parseInt(dates);
            return u + "";
        } else if (leh == 15) {
            dates = sfzh.substring(6, 8);
            return dates;
        } else {
            return "";
        }
    }

    public static String getFilePath(String basePath, String fileName) {
        if (StringUtils.isBlank(basePath) || StringUtils.isBlank(fileName))
            return null;
        String year = null;
        String month = null;
        String[] array = fileName.split("\\.");
        for (int j = array.length - 1; j >= 0; j--) {
            String s = array[j];
            if (s.length() == 10) {
                long num = Long.parseLong(s);
                if (num > 1400_000_000 && num < 1600_000_000) {
                    //System.out.println(s);
                    Date date = new Date(num * 1000L);
                    year = DateUntil.formatDate(date, "yyyy");
                    month = DateUntil.formatDate(date, "MM");
                }
            }
        }
        if (year != null && month != null) {
            return year + File.separator + month + File.separator;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getFilePath("1", "1.2.840.113619.2.80.3826543820.13483.1588262451.4"));
    }
}
