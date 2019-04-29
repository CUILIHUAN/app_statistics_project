package com.cuilihuan.applogs.visualize.service;

import com.cuilihuan.applogs.visualize.domain.RetentionAnalaysisBean;
import com.cuilihuan.applogs.visualize.domain.StatBean;

import java.util.List;
import java.util.Map;


public interface StatService {
    public StatBean findNewUsers();

    List<StatBean> findThisWeekNewUsers(String sdk34734);

    void insertLogs();

    Map<String, Object> findThisWeekActiveUsers(String appId);

    Map<String, Object> findSilenceUsers(String appId);

    Map<String, Object> findStartUpNum(String appId);

    Map<String, Object> findProvinceNum();

    List<RetentionAnalaysisBean> findRetentionAnalaysisBean(String time, String appId, String versionId);

    public String findUserFreshness(String appId);

    String findUserActiveRate(String appId);
}
