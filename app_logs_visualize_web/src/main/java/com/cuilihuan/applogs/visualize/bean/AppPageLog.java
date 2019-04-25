package com.cuilihuan.applogs.visualize.bean;

public class AppPageLog {
    private Long createdAtMs;

    private String appId;

    private String tenantId;

    private String deviceId;

    private String appVersion;

    private String appChannel;

    private String appPlatform;

    private String osType;

    private String deviceStyle;

    private Integer pageViewCntInSession;

    private String pageId;

    private Integer visitIndex;

    private String nextPage;

    private Long stayDurationSecs;

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

    public Integer getPageViewCntInSession() {
        return pageViewCntInSession;
    }

    public void setPageViewCntInSession(Integer pageViewCntInSession) {
        this.pageViewCntInSession = pageViewCntInSession;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId == null ? null : pageId.trim();
    }

    public Integer getVisitIndex() {
        return visitIndex;
    }

    public void setVisitIndex(Integer visitIndex) {
        this.visitIndex = visitIndex;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage == null ? null : nextPage.trim();
    }

    public Long getStayDurationSecs() {
        return stayDurationSecs;
    }

    public void setStayDurationSecs(Long stayDurationSecs) {
        this.stayDurationSecs = stayDurationSecs;
    }
}