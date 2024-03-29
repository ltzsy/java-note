package com.ltzsy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @description: 这里用一句话描述这个类的作用 <br>
 * @version: 1.0 <br>
 * @author: leevi.li <br>
 * @create: 2022/6/28 10:14 <br>
 * @update: 2022/6/28 10:14 <br>
 * @since jdk11.0.5_10
 */
public class DateUtil {

    public static void main(String[] args) {
        String str = getCurrentTimeAddMilli(-1000 * 60 * 60 * 24L,  DATE_FORMAT_yy_MM_dd);
        System.out.println(str);
    }

    /**
     * 日期格式：yyyy-MM-dd HH:mm:ss
     */
    public static final String DATE_FORMAT_yy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式：yyyy-MM-dd
     */
    public static final String DATE_FORMAT_yy_MM_dd = "yyyy-MM-dd";

    /**
     * 日期格式：yyyy/MM/dd HH:mm:ss
     */
    public static final String DATE_FORMAT_yy_MM_dd_HH_mm_ss_1 = "yyyy/MM/dd HH:mm:ss";

    /**
     * 日期格式：yyyy/MM/dd
     */
    public static final String DATE_FORMAT_yy_MM_dd_1 = "yyyy/MM/dd";

    /**
     * @description: 获取Calendard对象 <br>
     * @version: 1.0 <br>
     * @author: leevi.li <br>
     * @create: 2022/6/28 11:33 <br>
     * @update: 2022/6/28 11:33 <br>
     * @param:
     * @return java.util.Calendar
     */
    public static Calendar getCalendar(){
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        Locale locale = Locale.CHINESE;
        Calendar calendar = Calendar.getInstance(timeZone, locale);
        return  calendar;
    }

    /**
     * @description: 获取格式化后的时间 <br>
     * @version: 1.0 <br>
     * @author: leevi.li <br>
     * @create: 2022/6/28 10:50 <br>
     * @update: 2022/6/28 10:50 <br>
     * @param: format 格式
     * @return java.lang.String
     */
    public static String getFormatedCurrentTime(String format){
        Calendar calendar = getCalendar();
        Date date = calendar.getTime();
        return formatDate(date, format);
    }

    /**
     * @description: 格式化时间 <br>
     * @version: 1.0 <br>
     * @author: leevi.li <br>
     * @create: 2022/6/28 15:24 <br>
     * @update: 2022/6/28 15:24 <br>
     * @param: date
     * @param: format
     * @return java.lang.String
     */
    public static String formatDate(Date date, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateStr = sdf.format(date);
        return dateStr;
    }

    /**
     * @description: 获取当前年份 <br>
     * @version: 1.0 <br>
     * @author: leevi.li <br>
     * @create: 2022/6/28 11:34 <br>
     * @update: 2022/6/28 11:34 <br>
     * @param:
     * @return int
     */
    public static int getCurrentYear(){
        Calendar calendar = getCalendar();
        return calendar.get(Calendar.YEAR);
    }

    /**
     * @description: 获取当前月份 <br>
     * @version: 1.0 <br>
     * @author: leevi.li <br>
     * @create: 2022/6/28 11:38 <br>
     * @update: 2022/6/28 11:38 <br>
     * @param:
     * @return int
     */
    public static int getCurrentMonth(){
        Calendar calendar = getCalendar();
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * @description: 获取当前月天数 <br>
     * @version: 1.0 <br>
     * @author: leevi.li <br>
     * @create: 2022/6/28 11:38 <br>
     * @update: 2022/6/28 11:38 <br>
     * @param:
     * @return int
     */
    public static int getCurrentDayOfMonth(){
        Calendar calendar = getCalendar();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * @description: 获取当前年的天数 <br>
     * @version: 1.0 <br>
     * @author: leevi.li <br>
     * @create: 2022/6/28 11:39 <br>
     * @update: 2022/6/28 11:39 <br>
     * @param:
     * @return int
     */
    public static int getCurrentDayOfYear(){
        Calendar calendar = getCalendar();
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * @description: 获取当前时间加上指定毫秒数的格式化时间 <br>
     * @version: 1.0 <br>
     * @author: leevi.li <br>
     * @create: 2022/6/28 15:20 <br>
     * @update: 2022/6/28 15:20 <br>
     * @param: millisecond 毫秒数（可正可负）
     * @param: format 格式
     * @return java.lang.String
     */
    public static String getCurrentTimeAddMilli(Long millisecond, String format){
        Calendar calendar = getCalendar();
        long millis = calendar.getTimeInMillis();
        millis += millisecond;
        calendar.setTimeInMillis(millis);
        Date date = calendar.getTime();
        return formatDate(date, format);
    }

    /**
     * @description: 给指定日期加上指定毫秒数的格式化时间 <br>
     * @version: 1.0 <br>
     * @author: leevi.li <br>
     * @create: 2022/7/18 9:05 <br>
     * @update: 2022/7/18 9:05 <br>
     * @param: date
     * @param: millisecond
     * @param: format
     * @return java.lang.String
     */
    public static String dateAddMilli(String date, Long millisecond, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date d = null;
        try {
            d = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long dl = d.getTime();
        dl += millisecond;
        d.setTime(dl);
        return sdf.format(d);
    }

    /**
     * @description: subtractionForDay <br>
     * @version: 1.0 <br>
     * @author: leevi.li <br>
     * @create: 2022/7/19 9:03 <br>
     * @update: 2022/7/19 9:03 <br>
     * @param: date1
     * @param: date2
     * @return int
     */
    public static int subtractionForDay(String date1, String date2){
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_yy_MM_dd);
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = sdf.parse(date1);
            d2 = sdf.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time1 = d1.getTime();
        long time2 = d2.getTime();
        long subTime = Math.abs(time1 - time2);
        Long subDay = subTime / (60 * 60 * 24 * 1000);
        return subDay.intValue();
    }
}
