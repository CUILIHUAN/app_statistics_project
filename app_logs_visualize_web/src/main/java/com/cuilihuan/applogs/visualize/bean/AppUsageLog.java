package com.cuilihuan.applogs.visualize.bean;

public class AppUsageLog {
    private Long createdAtMs;

    private String appId;

    private String tenantId;

    private String deviceId;

    private String appVersion;

    private String appChannel;

    private String appPlatform;

    private String osType;

    private String deviceStyle;

    private Long singleUseDurationSecs;

    private Long singleUploadTraffic;

    private Long singleDownloadTraffic;

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

    public Long getSingleUseDurationSecs() {
        return singleUseDurationSecs;
    }

    public void setSingleUseDurationSecs(Long singleUseDurationSecs) {
        this.singleUseDurationSecs = singleUseDurationSecs;
    }

    public Long getSingleUploadTraffic() {
        return singleUploadTraffic;
    }

    public void setSingleUploadTraffic(Long singleUploadTraffic) {
        this.singleUploadTraffic = singleUploadTraffic;
    }

    public Long getSingleDownloadTraffic() {
        return singleDownloadTraffic;
    }

    public void setSingleDownloadTraffic(Long singleDownloadTraffic) {
        this.singleDownloadTraffic = singleDownloadTraffic;
    }
}