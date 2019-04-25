package com.cuilihuan.applogs.visualize.bean;

public class AppErrorLog {
    private Long createdAtMs;

    private String appId;

    private String tenantId;

    private String deviceId;

    private String appVersion;

    private String appChannel;

    private String appPlatform;

    private String osType;

    private String deviceStyle;

    private String errorBrief;

    private String errorDetail;

    public AppErrorLog() {
    }

    public AppErrorLog(Long createdAtMs, String appId, String tenantId, String deviceId, String appVersion, String appChannel, String appPlatform, String osType, String deviceStyle, String errorBrief, String errorDetail) {
        this.createdAtMs = createdAtMs;
        this.appId = appId;
        this.tenantId = tenantId;
        this.deviceId = deviceId;
        this.appVersion = appVersion;
        this.appChannel = appChannel;
        this.appPlatform = appPlatform;
        this.osType = osType;
        this.deviceStyle = deviceStyle;
        this.errorBrief = errorBrief;
        this.errorDetail = errorDetail;
    }

    public Long getCreatedAtMs() {
        return createdAtMs;
    }

    public void setCreatedAtMs(Long createdAtMs) {
        this.createdAtMs = createdAtMs;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion == null ? null : appVersion.trim();
    }

    public String getAppChannel() {
        return appChannel;
    }

    public void setAppChannel(String appChannel) {
        this.appChannel = appChannel == null ? null : appChannel.trim();
    }

    public String getAppPlatform() {
        return appPlatform;
    }

    public void setAppPlatform(String appPlatform) {
        this.appPlatform = appPlatform == null ? null : appPlatform.trim();
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType == null ? null : osType.trim();
    }

    public String getDeviceStyle() {
        return deviceStyle;
    }

    public void setDeviceStyle(String deviceStyle) {
        this.deviceStyle = deviceStyle == null ? null : deviceStyle.trim();
    }

    public String getErrorBrief() {
        return errorBrief;
    }

    public void setErrorBrief(String errorBrief) {
        this.errorBrief = errorBrief == null ? null : errorBrief.trim();
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail == null ? null : errorDetail.trim();
    }
}