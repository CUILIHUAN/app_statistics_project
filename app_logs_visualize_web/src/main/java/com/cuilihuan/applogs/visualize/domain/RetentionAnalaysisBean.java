package com.cuilihuan.applogs.visualize.domain;

/**
 * @Auther:Cui LiHuan
 * @Date: 2019/4/27 18:02
 * @Description:
 */
public class RetentionAnalaysisBean {


    /**
     * time : 2019-4-12
     * adduser : 78
     * afteroneday : 12%
     * aftertwoday : 6%
     * afterthreeday : 7%
     * afterfoueday : 8%
     * afterfiveday : 9%
     * aftersixday : 10%
     * aftersevenday : 11%
     * afterfourtyday : 2%
     * aftermonthday : 3%
     */

    private String time;
    private String adduser;
    private String afteroneday;
    private String aftertwoday;
    private String afterthreeday;
    private String afterfoueday;
    private String afterfiveday;
    private String aftersixday;
    private String aftersevenday;
    private String afterfourtyday;
    private String aftermonthday;
    private String[] day = new String[9];

    public void init() {
        afteroneday = day[0];
        aftertwoday = day[1];
        afterthreeday = day[2];
        afterfoueday = day[3];
        afterfiveday = day[4];
        aftersixday = day[5];
        aftersevenday = day[6];
        afterfourtyday = day[7];
        aftermonthday = day[8];
    }

    public String[] getDay() {
        return day;
    }

    public void setDay(String[] day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAdduser() {
        return adduser;
    }

    public void setAdduser(String adduser) {
        this.adduser = adduser;
    }

    public String getAfteroneday() {
        return afteroneday;
    }

    public void setAfteroneday(String afteroneday) {
        this.afteroneday = afteroneday;
    }

    public String getAftertwoday() {
        return aftertwoday;
    }

    public void setAftertwoday(String aftertwoday) {
        this.aftertwoday = aftertwoday;
    }

    public String getAfterthreeday() {
        return afterthreeday;
    }

    public void setAfterthreeday(String afterthreeday) {
        this.afterthreeday = afterthreeday;
    }

    public String getAfterfoueday() {
        return afterfoueday;
    }

    public void setAfterfoueday(String afterfoueday) {
        this.afterfoueday = afterfoueday;
    }

    public String getAfterfiveday() {
        return afterfiveday;
    }

    public void setAfterfiveday(String afterfiveday) {
        this.afterfiveday = afterfiveday;
    }

    public String getAftersixday() {
        return aftersixday;
    }

    public void setAftersixday(String aftersixday) {
        this.aftersixday = aftersixday;
    }

    public String getAftersevenday() {
        return aftersevenday;
    }

    public void setAftersevenday(String aftersevenday) {
        this.aftersevenday = aftersevenday;
    }

    public String getAfterfourtyday() {
        return afterfourtyday;
    }

    public void setAfterfourtyday(String afterfourtyday) {
        this.afterfourtyday = afterfourtyday;
    }

    public String getAftermonthday() {
        return aftermonthday;
    }

    public void setAftermonthday(String aftermonthday) {
        this.aftermonthday = aftermonthday;
    }

    @Override
    public String toString() {
        return "{" +
                "time='" + time + '\'' +
                ", adduser='" + adduser + '\'' +
                ", afteroneday='" + afteroneday + '\'' +
                ", aftertwoday='" + aftertwoday + '\'' +
                ", afterthreeday='" + afterthreeday + '\'' +
                ", afterfoueday='" + afterfoueday + '\'' +
                ", afterfiveday='" + afterfiveday + '\'' +
                ", aftersixday='" + aftersixday + '\'' +
                ", aftersevenday='" + aftersevenday + '\'' +
                ", afterfourtyday='" + afterfourtyday + '\'' +
                ", aftermonthday='" + aftermonthday + '\'' +
                '}';
    }
}
