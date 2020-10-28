package cn.liziy.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liziyang
 * @date 17:59 2020/9/22
 * 时间工具类
 **/
public class DateUtil {

    public static  String  time1 = " 00:00:00";
    public static  String  time2 = " 23:59:59";

    /**
     * 获取当前时间
     * @return java.lang.String
     */
    public static String  getTime(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取当前时间
        String time = dateFormat.format( now );

        return time;
    }

    public static void main(String[] args) {
        System.out.println("时间："+getTime());
    }
}
