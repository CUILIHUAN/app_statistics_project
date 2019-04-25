package com.cuilihuan.applogs.visualize.domain;

/**
 * Created by atguigu on 2017/11/9
 */
public class StatBean {
    //统计日期
    private String date ;
    //统计数量
    private long count ;

    private String appVersion;

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {

        this.count = count;
    }

    @Override
    public String toString() {
        return "StatBean{" +
                "date='" + date + '\'' +
                ", count=" + count +
                ", appVersion='" + appVersion + '\'' +
                '}';
    }
}
