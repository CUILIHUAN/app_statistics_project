package com.cuilihuan.applogs.visualize.bean;

import com.cuilihuan.applogs.visualize.domain.JsonBean;

import java.util.Arrays;
import java.util.List;

/**
 * AppLog实体类
 * 内部含有各种日志时间的集合。
 */
public class AppLogEntity extends AppBaseLog{
//
    private List<AppErrorLog> appErrorLogs;
    private List<AppEventLog> appEventLogs;
    private List<AppPageLog> appPageLogs;
    private List<AppStartupLog> appStartupLogs;
    private List<AppUsageLog> appUsageLogs;



    public List<AppErrorLog> getAppErrorLogs() {
        return appErrorLogs;
    }

    public void setAppErrorLogs(List<AppErrorLog> appErrorLogs) {
        this.appErrorLogs = appErrorLogs;
    }

    public List<AppEventLog> getAppEventLogs() {
        return appEventLogs;
    }

    public void setAppEventLogs(List<AppEventLog> appEventLogs) {
        this.appEventLogs = appEventLogs;
    }

    public List<AppPageLog> getAppPageLogs() {
        return appPageLogs;
    }

    public void setAppPageLogs(List<AppPageLog> appPageLogs) {
        this.appPageLogs = appPageLogs;
    }

    public List<AppStartupLog> getAppStartupLogs() {
        return appStartupLogs;
    }

    public void setAppStartupLogs(List<AppStartupLog> appStartupLogs) {
        this.appStartupLogs = appStartupLogs;
    }

    public List<AppUsageLog> getAppUsageLogs() {
        return appUsageLogs;
    }

    public void setAppUsageLogs(List<AppUsageLog> appUsageLogs) {
        this.appUsageLogs = appUsageLogs;
    }
}
