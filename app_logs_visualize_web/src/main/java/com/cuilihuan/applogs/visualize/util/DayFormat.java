package com.cuilihuan.applogs.visualize.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Auther:Cui LiHuan
 * @Date: 2019/4/23 14:43
 * @Description:
 */
public class DayFormat {
    public static void main(String[] args) throws ParseException {
//        Date date = new Date();
//        date.setTime(1425254400000L);
//        System.out.println(System.currentTimeMillis());
//        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
//        System.out.println(df.parse("2019/04/21").getTime());
//
//        System.out.println(beforeMonth()[0]+"+"+beforeMonth()[1]);

        String[] beforeByHourTime = getBeforeByHourTime(1);
        for (int i = 0; i < beforeByHourTime.length; i++) {
            System.out.println(beforeByHourTime[i]);

        }

    }

    public static String[] beforeMonth() {
        String[] dateString = new String[2];
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

        Calendar c = Calendar.getInstance();
        //过去一月
        c.setTime(new Date());

        dateString[1] = format.format(c.getTime());

        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String mon = format.format(m);
        dateString[0] = mon;

        return dateString;
    }


    /**
     * 将字符串日期转化成Long型的毫秒值
     * @param time
     * @return
     */
    public static Long dateToString(String time) {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        try {
            date = df.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    /**
     * 比较两个日期时间 是否相差一定的天数 若是返回true，否则返回false
     *
     * @param DATE1 起始时间
     * @param DATE2 终止时间
     * @param num   相差的天数
     * @return 返回boolean类型，若为真，则起始时间+天数小于等天终止时间
     */
    public static boolean compare_date(String DATE1, String DATE2, Integer num) {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date startDate = df.parse(DATE1);
            Date endDate = df.parse(DATE2);

            Calendar fromCalendar = Calendar.getInstance();
            fromCalendar.setTime(startDate);
            fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
            fromCalendar.set(Calendar.MINUTE, 0);
            fromCalendar.set(Calendar.SECOND, 0);
            fromCalendar.set(Calendar.MILLISECOND, 0);

            Calendar toCalendar = Calendar.getInstance();
            toCalendar.setTime(endDate);
            toCalendar.set(Calendar.HOUR_OF_DAY, 0);
            toCalendar.set(Calendar.MINUTE, 0);
            toCalendar.set(Calendar.SECOND, 0);
            toCalendar.set(Calendar.MILLISECOND, 0);
            if ((toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24) >= num) {
                return true;
            } else {
                return false;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;

    }

    public static String[] getBeforeSevenDay() {
        String[] arr = new String[7];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar c = null;
        for (int i = 0; i < 7; i++) {
            c = Calendar.getInstance();
            c.add(Calendar.DAY_OF_MONTH, -i - 1);
            arr[6 - i] = sdf.format(c.getTime());
        }
        return arr;
    }

    /**
     * 获取两个时间中的每一天
     *
     * @param startTimeOfString 开始时间
     * @param endTimeOfString   结束时间
     * @return 返回list集合 元素为该段的时间
     */
    public static List<String> getPerDay(String startTimeOfString, String endTimeOfString) {
        //定义一个接受时间的集合
        Date startTime = new Date(startTimeOfString);
        Date endTime = new Date(endTimeOfString);
        List<String> lDate = new ArrayList<String>();
        lDate.add(startTimeOfString);
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(startTime);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(endTime);
        // 测试此日期是否在指定日期之后
        while (endTime.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

            lDate.add(sdf.format(calBegin.getTime()).trim());
        }
        return lDate;
    }


    /**
     * 获取当前时间
     *
     * @return 返回"yyyy/MM/dd”形的字符串
     */
    public static String getCurrentDay() {
        java.util.Calendar c = java.util.Calendar.getInstance();
        java.text.SimpleDateFormat f = new java.text.SimpleDateFormat("yyyy/MM/dd");
        return f.format(c.getTime());
    }

    public static String getBeforeOneDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, -1);
        Date start = c.getTime();
        return format.format(start);
    }

    /**
     * 得到当前时间的前N小时
     * 
     *
     */
    public static String[] getBeforeByHourTime(int ihour){
        String returnstr = "";
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - ihour);
        SimpleDateFormat df = new SimpleDateFormat("HH");
        returnstr = df.format(calendar.getTime());
        String[] date = new String[Integer.valueOf(returnstr)];;
        for (int i = 0; i < date.length; i++) {
            date[i] = "" + (i+1);
        }
        return date;
    }
}
