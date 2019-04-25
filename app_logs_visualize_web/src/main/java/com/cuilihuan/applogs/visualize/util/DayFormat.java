package com.cuilihuan.applogs.visualize.util;

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
    public static void main(String[] args) {
        Date startDate = new Date("2019/04/09");
        Date endDate = new Date("2019/04/23 ");
        List<String> perDay = getPerDay("2019/04/09", "2019/04/23");
        System.out.println(perDay);
    }
    public static  String [] getBeforeSevenDay(){
        String [] arr = new String[7];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar c = null;
        for (int i=0;i<7;i++){
            c= Calendar.getInstance();
            c.add(Calendar.DAY_OF_MONTH, - i-1);
            arr[6-i] =sdf.format(c.getTime());
        }
        return arr;
    }

    /**
     * 获取两个时间中的每一天
     * @param startTimeOfString 开始时间
     * @param endTimeOfString 结束时间
     * @return 返回list集合 元素为该段的时间
     */
    public static List<String> getPerDay(String startTimeOfString, String endTimeOfString ){
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
        while (endTime.after(calBegin.getTime()))  {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

            lDate.add(sdf.format(calBegin.getTime()).trim());
        }
        return lDate;
    }
}
