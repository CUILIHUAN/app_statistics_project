package com.cuilihuan.applogs.visualize.dao;

import com.cuilihuan.applogs.visualize.domain.InfoPorovinceAndNumBean;
import com.cuilihuan.applogs.visualize.domain.StatBean;
import org.apache.ibatis.annotations.Param;import org.springframework.stereotype.Component;

import java.util.List;



public interface StatMapper {
    public StatBean findNewUsers();

    List<StatBean> findThisWeekNewUsers(String sdk34734);

    List<StatBean> selectThisWeekActive(String appId);

    List<StatBean> selectSilenceUser(String appId);

    List<StatBean> selectStartUpNum(String appId);

    void updateProvince(String province,Integer id);


    List<InfoPorovinceAndNumBean> selectProvinceNum();

    List<String> selectDayOfNewUsers(@Param("appId")String appId, @Param("version")String version, @Param("time")String time);

    Integer selectPerDaysOfUsage(@Param("time") String time, @Param("appId") String appId, @Param("version") String version, @Param("dayNum") int dayNum, @Param("deviceIds")List<String> deviceIds);

    Integer selectDayOfNewUsersAllVersion(@Param("time")String time, @Param("appId")String appId);

    Integer selectDayOfNewUsersAllUsers(@Param("time") String time, @Param("appId")String appId);

    Integer selectDayOfActiveUsers(@Param("time")String time, @Param("appId")String appId);

    List<StatBean> selectDevicesOfNUM(@Param("appId")String appId);

    List<StatBean> selectDevicesOfNUMByVersion(@Param("appId")String appId, @Param("deviceStyle")String deviceStyle);

    List<StatBean> selectNetWorkByAppId(@Param("appId")String appId);


    List<StatBean> selectUseTimes(@Param("appId")String appId, @Param("time")String time);
}
