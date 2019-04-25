package com.cuilihuan.applogs.visualize.domain;

import java.util.List;

/**
 * @Auther:Cui LiHuan
 * @Date: 2019/4/20 17:19
 * @Description:
 */
public class JsonBean {

    private List<AppErrorLogsBean> appErrorLogs;
    private List<AppEventLogsBean> appEventLogs;
    private List<AppPageLogsBean> appPageLogs;
    private List<AppStartupLogsBean> appStartupLogs;
    private List<AppUsageLogsBean> appUsageLogs;

    public List<AppErrorLogsBean> getAppErrorLogs() {
        return appErrorLogs;
    }

    public void setAppErrorLogs(List<AppErrorLogsBean> appErrorLogs) {
        this.appErrorLogs = appErrorLogs;
    }

    public List<AppEventLogsBean> getAppEventLogs() {
        return appEventLogs;
    }

    public void setAppEventLogs(List<AppEventLogsBean> appEventLogs) {
        this.appEventLogs = appEventLogs;
    }

    public List<AppPageLogsBean> getAppPageLogs() {
        return appPageLogs;
    }

    public void setAppPageLogs(List<AppPageLogsBean> appPageLogs) {
        this.appPageLogs = appPageLogs;
    }

    public List<AppStartupLogsBean> getAppStartupLogs() {
        return appStartupLogs;
    }

    public void setAppStartupLogs(List<AppStartupLogsBean> appStartupLogs) {
        this.appStartupLogs = appStartupLogs;
    }

    public List<AppUsageLogsBean> getAppUsageLogs() {
        return appUsageLogs;
    }

    public void setAppUsageLogs(List<AppUsageLogsBean> appUsageLogs) {
        this.appUsageLogs = appUsageLogs;
    }

    @Override
    public String toString() {
        return "JsonBean{" +
                "appErrorLogs=" + appErrorLogs +
                ", appEventLogs=" + appEventLogs +
                ", appPageLogs=" + appPageLogs +
                ", appStartupLogs=" + appStartupLogs +
                ", appUsageLogs=" + appUsageLogs +
                '}';
    }

    public static class AppErrorLogsBean {
        /**

         * appChannel : youmeng2
         * appId : sdk34734
         * appPlatform : ios
         * appVersion : 3.2.1
         * createdAtMs : 1555770034756
         * deviceId : device2238
         * deviceStyle : iPhone 6
         * errorBrief : at cn.lift.appIn.control.CommandUtil.getInfo(CommandUtil.java:67)
         * errorDetail : java.lang.NullPointerException\n    at cn.lift.appIn.web.AbstractBaseController.validInbound(AbstractBaseController.java:72)\n at cn.lift.dfdf.web.AbstractBaseController.validInbound
         * osType : 8.3
         * tenantId : cake
         */

        private String appChannel;
        private String appId;
        private String appPlatform;
        private String appVersion;
        private long createdAtMs;
        private String deviceId;
        private String deviceStyle;
        private String errorBrief;
        private String errorDetail;
        private String osType;
        private String tenantId;

        public String getAppChannel() {
            return appChannel;
        }

        public void setAppChannel(String appChannel) {
            this.appChannel = appChannel;
        }

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getAppPlatform() {
            return appPlatform;
        }

        public void setAppPlatform(String appPlatform) {
            this.appPlatform = appPlatform;
        }

        public String getAppVersion() {
            return appVersion;
        }

        public void setAppVersion(String appVersion) {
            this.appVersion = appVersion;
        }

        public long getCreatedAtMs() {
            return createdAtMs;
        }

        public void setCreatedAtMs(long createdAtMs) {
            this.createdAtMs = createdAtMs;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public String getDeviceStyle() {
            return deviceStyle;
        }

        public void setDeviceStyle(String deviceStyle) {
            this.deviceStyle = deviceStyle;
        }

        public String getErrorBrief() {
            return errorBrief;
        }

        public void setErrorBrief(String errorBrief) {
            this.errorBrief = errorBrief;
        }

        public String getErrorDetail() {
            return errorDetail;
        }

        public void setErrorDetail(String errorDetail) {
            this.errorDetail = errorDetail;
        }

        public String getOsType() {
            return osType;
        }

        public void setOsType(String osType) {
            this.osType = osType;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }
    }

    public static class AppEventLogsBean {
        /**
         * appChannel : youmeng1
         * appId : sdk34734
         * appPlatform : ios
         * appVersion : 3.2.1
         * createdAtMs : 1555770034755
         * deviceId : device2242
         * deviceStyle : iPhone 6
         * eventDurationSecs : 45
         *
         *
         * eventId : popMenu
         * osType : 8.3
         * paramKeyValueMap : {"testparam3key":"testparam3value","testparam4key":"testparam4value"}
         * tenantId : cake
         */

        private String appChannel;
        private String appId;
        private String appPlatform;
        private String appVersion;
        private long createdAtMs;
        private String deviceId;
        private String deviceStyle;
        private String eventDurationSecs;
        private String eventId;
        private String osType;
        private ParamKeyValueMapBean paramKeyValueMap;
        private String tenantId;

        public String getAppChannel() {
            return appChannel;
        }

        public void setAppChannel(String appChannel) {
            this.appChannel = appChannel;
        }

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getAppPlatform() {
            return appPlatform;
        }

        public void setAppPlatform(String appPlatform) {
            this.appPlatform = appPlatform;
        }

        public String getAppVersion() {
            return appVersion;
        }

        public void setAppVersion(String appVersion) {
            this.appVersion = appVersion;
        }

        public long getCreatedAtMs() {
            return createdAtMs;
        }

        public void setCreatedAtMs(long createdAtMs) {
            this.createdAtMs = createdAtMs;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public String getDeviceStyle() {
            return deviceStyle;
        }

        public void setDeviceStyle(String deviceStyle) {
            this.deviceStyle = deviceStyle;
        }

        public String getEventDurationSecs() {
            return eventDurationSecs;
        }

        public void setEventDurationSecs(String eventDurationSecs) {
            this.eventDurationSecs = eventDurationSecs;
        }

        public String getEventId() {
            return eventId;
        }

        public void setEventId(String eventId) {
            this.eventId = eventId;
        }

        public String getOsType() {
            return osType;
        }

        public void setOsType(String osType) {
            this.osType = osType;
        }

        public ParamKeyValueMapBean getParamKeyValueMap() {
            return paramKeyValueMap;
        }

        public void setParamKeyValueMap(ParamKeyValueMapBean paramKeyValueMap) {
            this.paramKeyValueMap = paramKeyValueMap;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        public static class ParamKeyValueMapBean {
            /**
             * testparam3key : testparam3value
             * testparam4key : testparam4value
             */

            private String testparam3key;
            private String testparam4key;

            public String getTestparam3key() {
                return testparam3key;
            }

            public void setTestparam3key(String testparam3key) {
                this.testparam3key = testparam3key;
            }

            public String getTestparam4key() {
                return testparam4key;
            }

            public void setTestparam4key(String testparam4key) {

                this.testparam4key = testparam4key;
            }

            @Override
            public String toString() {
                return "ParamKeyValueMapBean{" +
                        "testparam3key='" + testparam3key + '\'' +
                        ", testparam4key='" + testparam4key + '\'' +
                        '}';
            }
        }

    }

    public static class AppPageLogsBean {
        /**
         * appChannel : youmeng1
         * appId : sdk34734
         * appPlatform : ios
         * appVersion : 3.2.1
         * createdAtMs : 1555770034755
         * deviceId : device2245
         * deviceStyle : 红米手机1s
         * nextPage : test.html
         * osType : 7.1.1
         * pageId : main.html
         * stayDurationSecs : 45
         * tenantId : cake
         * visitIndex : 0
         */

        private String appChannel;
        private String appId;
        private String appPlatform;
        private String appVersion;
        private long createdAtMs;
        private String deviceId;
        private String deviceStyle;
        private String nextPage;
        private String osType;
        private String pageId;
        private String stayDurationSecs;
        private String tenantId;
        private String visitIndex;

        public String getAppChannel() {
            return appChannel;
        }

        public void setAppChannel(String appChannel) {
            this.appChannel = appChannel;
        }

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getAppPlatform() {
            return appPlatform;
        }

        public void setAppPlatform(String appPlatform) {
            this.appPlatform = appPlatform;
        }

        public String getAppVersion() {
            return appVersion;
        }

        public void setAppVersion(String appVersion) {
            this.appVersion = appVersion;
        }

        public long getCreatedAtMs() {
            return createdAtMs;
        }

        public void setCreatedAtMs(long createdAtMs) {
            this.createdAtMs = createdAtMs;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public String getDeviceStyle() {
            return deviceStyle;
        }

        public void setDeviceStyle(String deviceStyle) {
            this.deviceStyle = deviceStyle;
        }

        public String getNextPage() {
            return nextPage;
        }

        public void setNextPage(String nextPage) {
            this.nextPage = nextPage;
        }

        public String getOsType() {
            return osType;
        }

        public void setOsType(String osType) {
            this.osType = osType;
        }

        public String getPageId() {
            return pageId;
        }

        public void setPageId(String pageId) {
            this.pageId = pageId;
        }


        public String getStayDurationSecs() {
            return stayDurationSecs;
        }

        public void setStayDurationSecs(String stayDurationSecs) {
            this.stayDurationSecs = stayDurationSecs;
        }

        public String getVisitIndex() {
            return visitIndex;
        }

        public void setVisitIndex(String visitIndex) {
            this.visitIndex = visitIndex;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }


    }

    public static class AppStartupLogsBean {
        /**
         * appChannel : youmeng2
         * appId : sdk34734
         * appPlatform : android
         * appVersion : 3.2.2
         * brand : 魅族
         * carrier : 中国移动
         * country : America
         * createdAtMs : 1555770034754
         * deviceId : device2284
         * deviceStyle : iPhone 6
         * network : WiFi
         * osType : 8.3
         * province : jiangxi
         * screenSize : 1136*640
         * tenantId : cake
         */

        private String appChannel;
        private String appId;
        private String appPlatform;
        private String appVersion;
        private String brand;
        private String carrier;
        private String country;
        private long createdAtMs;
        private String deviceId;
        private String deviceStyle;
        private String network;
        private String osType;
        private String province;
        private String screenSize;
        private String tenantId;

        public String getAppChannel() {
            return appChannel;
        }

        public void setAppChannel(String appChannel) {
            this.appChannel = appChannel;
        }

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getAppPlatform() {
            return appPlatform;
        }

        public void setAppPlatform(String appPlatform) {
            this.appPlatform = appPlatform;
        }

        public String getAppVersion() {
            return appVersion;
        }

        public void setAppVersion(String appVersion) {
            this.appVersion = appVersion;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getCarrier() {
            return carrier;
        }

        public void setCarrier(String carrier) {
            this.carrier = carrier;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public long getCreatedAtMs() {
            return createdAtMs;
        }

        public void setCreatedAtMs(long createdAtMs) {
            this.createdAtMs = createdAtMs;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public String getDeviceStyle() {
            return deviceStyle;
        }

        public void setDeviceStyle(String deviceStyle) {
            this.deviceStyle = deviceStyle;
        }

        public String getNetwork() {
            return network;
        }

        public void setNetwork(String network) {
            this.network = network;
        }

        public String getOsType() {
            return osType;
        }

        public void setOsType(String osType) {
            this.osType = osType;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getScreenSize() {
            return screenSize;
        }

        public void setScreenSize(String screenSize) {
            this.screenSize = screenSize;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }
    }

    public static class AppUsageLogsBean {
        /**
         * appChannel : youmeng1
         * appId : sdk34734
         * appPlatform : android
         * appVersion : 3.2.1
         * createdAtMs : 1555770034756
         * deviceId : device2266
         * deviceStyle : iPhone 6
         * osType : 7.1.1
         * singleUseDurationSecs : 142
         * tenantId : cake
         */

        private String appChannel;
        private String appId;
        private String appPlatform;
        private String appVersion;
        private long createdAtMs;
        private String deviceId;
        private String deviceStyle;
        private String osType;
        private long singleUseDurationSecs;
        private String tenantId;

        public String getAppChannel() {
            return appChannel;
        }

        public void setAppChannel(String appChannel) {
            this.appChannel = appChannel;
        }

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getAppPlatform() {
            return appPlatform;
        }

        public void setAppPlatform(String appPlatform) {
            this.appPlatform = appPlatform;
        }

        public String getAppVersion() {
            return appVersion;
        }

        public void setAppVersion(String appVersion) {
            this.appVersion = appVersion;
        }

        public long getCreatedAtMs() {
            return createdAtMs;
        }

        public void setCreatedAtMs(long createdAtMs) {
            this.createdAtMs = createdAtMs;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public String getDeviceStyle() {
            return deviceStyle;
        }

        public void setDeviceStyle(String deviceStyle) {
            this.deviceStyle = deviceStyle;
        }

        public String getOsType() {
            return osType;
        }

        public void setOsType(String osType) {
            this.osType = osType;
        }

        public long getSingleUseDurationSecs() {
            return singleUseDurationSecs;
        }

        public void setSingleUseDurationSecs(long singleUseDurationSecs) {
            this.singleUseDurationSecs = singleUseDurationSecs;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }
    }

}
