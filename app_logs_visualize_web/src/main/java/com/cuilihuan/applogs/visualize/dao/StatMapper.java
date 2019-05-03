package com.cuilihuan.applogs.visualize.dao;

import com.cuilihuan.applogs.visualize.domain.ErrorBean;
import com.cuilihuan.applogs.visualize.domain.InfoPorovinceAndNumBean;
import com.cuilihuan.applogs.visualize.domain.StatBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface StatMapper {
    public StatBean findNewUsers();

    List<StatBean> findThisWeekNewUsers(String sdk34734);

    List<StatBean> selectThisWeekActive(String appId);

    List<StatBean> selectSilenceUser(String appId);

    List<StatBean> selectStartUpNum(String appId);

    void updateProvince(String province, Integer id);


    List<InfoPorovinceAndNumBean> selectProvinceNum();

    List<String> selectDayOfNewUsers(@Param("appId") String appId, @Param("version") String version, @Param("time") String time);

    Integer selectPerDaysOfUsage(@Param("time") String time, @Param("appId") String appId, @Param("version") String version, @Param("dayNum") int dayNum, @Param("deviceIds") List<String> deviceIds);

    Integer selectDayOfNewUsersAllVersion(@Param("time") String time, @Param("appId") String appId);

    Integer selectDayOfNewUsersAllUsers(@Param("time") String time, @Param("appId") String appId);

    Integer selectDayOfActiveUsers(@Param("time") String time, @Param("appId") String appId);

    List<StatBean> selectDevicesOfNUM(@Param("appId") String appId);

    List<StatBean> selectDevicesOfNUMByVersion(@Param("appId") String appId, @Param("deviceStyle") String deviceStyle);

    List<StatBean> selectNetWorkByAppId(@Param("appId") String appId);


    List<StatBean> selectUseTimes(@Param("appId") String appId, @Param("time") String time);

    List<StatBean> selectUsageRate(@Param("time") String time, @Param("appId") String appId, @Param("days")Integer days);

    List<ErrorBean> selectErrorDetails(@Param("appId")String appId, @Param("startTime")String startTime, @Param("endTime")String endTime);

    List<StatBean> selectEachTimePeriod();

    List<StatBean> selectEachAddUsers();

    int selectAllUsers();

    int selectAllStartUps();

    int selectAddUserToday(@Param("time")String time);

    int selectStartUpCurrentTime(@Param("time")String time);
}
