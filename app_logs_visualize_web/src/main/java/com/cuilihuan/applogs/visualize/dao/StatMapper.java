package com.cuilihuan.applogs.visualize.dao;

import com.cuilihuan.applogs.visualize.domain.InfoPorovinceAndNumBean;
import com.cuilihuan.applogs.visualize.domain.StatBean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by atguigu on 2017/11/9
 */

public interface StatMapper {
    public StatBean findNewUsers();

    List<StatBean> findThisWeekNewUsers(String sdk34734);

    List<StatBean> selectThisWeekActive(String appId);

    List<StatBean> selectSilenceUser(String appId);

    List<StatBean> selectStartUpNum(String appId);

    void updateProvince(String province,Integer id);

    List<InfoPorovinceAndNumBean> selectProvinceNum();

}
