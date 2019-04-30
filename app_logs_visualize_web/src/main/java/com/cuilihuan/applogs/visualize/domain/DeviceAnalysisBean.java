package com.cuilihuan.applogs.visualize.domain;


/**
 * @Auther:Cui LiHuan
 * @Date: 2019/4/29 22:00
 * @Description:
 */
public class DeviceAnalysisBean {
    String name;
    float y;
    Drilldrilldown drilldrilldown;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Drilldrilldown getDrilldrilldown() {
        return drilldrilldown;
    }

    public void setDrilldrilldown(Drilldrilldown drilldrilldown) {
        this.drilldrilldown = drilldrilldown;
    }
}

