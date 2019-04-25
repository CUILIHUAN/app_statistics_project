package com.cuilihuan.applogs.visualize.bean;

import java.util.ArrayList;
import java.util.List;

public class AppPageLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppPageLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCreatedAtMsIsNull() {
            addCriterion("createdAtMs is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtMsIsNotNull() {
            addCriterion("createdAtMs is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtMsEqualTo(Long value) {
            addCriterion("createdAtMs =", value, "createdAtMs");
            return (Criteria) this;
        }

        public Criteria andCreatedAtMsNotEqualTo(Long value) {
            addCriterion("createdAtMs <>", value, "createdAtMs");
            return (Criteria) this;
        }

        public Criteria andCreatedAtMsGreaterThan(Long value) {
            addCriterion("createdAtMs >", value, "createdAtMs");
            return (Criteria) this;
        }

        public Criteria andCreatedAtMsGreaterThanOrEqualTo(Long value) {
            addCriterion("createdAtMs >=", value, "createdAtMs");
            return (Criteria) this;
        }

        public Criteria andCreatedAtMsLessThan(Long value) {
            addCriterion("createdAtMs <", value, "createdAtMs");
            return (Criteria) this;
        }

        public Criteria andCreatedAtMsLessThanOrEqualTo(Long value) {
            addCriterion("createdAtMs <=", value, "createdAtMs");
            return (Criteria) this;
        }

        public Criteria andCreatedAtMsIn(List<Long> values) {
            addCriterion("createdAtMs in", values, "createdAtMs");
            return (Criteria) this;
        }

        public Criteria andCreatedAtMsNotIn(List<Long> values) {
            addCriterion("createdAtMs not in", values, "createdAtMs");
            return (Criteria) this;
        }

        public Criteria andCreatedAtMsBetween(Long value1, Long value2) {
            addCriterion("createdAtMs between", value1, value2, "createdAtMs");
            return (Criteria) this;
        }

        public Criteria andCreatedAtMsNotBetween(Long value1, Long value2) {
            addCriterion("createdAtMs not between", value1, value2, "createdAtMs");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("appId is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("appId is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("appId =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("appId <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("appId >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("appId >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("appId <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("appId <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("appId like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("appId not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("appId in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("appId not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("appId between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("appId not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("tenantId is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenantId is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("tenantId =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("tenantId <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("tenantId >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("tenantId >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("tenantId <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("tenantId <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("tenantId like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("tenantId not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("tenantId in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("tenantId not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("tenantId between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("tenantId not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNull() {
            addCriterion("deviceId is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("deviceId is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(String value) {
            addCriterion("deviceId =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(String value) {
            addCriterion("deviceId <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(String value) {
            addCriterion("deviceId >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("deviceId >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(String value) {
            addCriterion("deviceId <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("deviceId <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLike(String value) {
            addCriterion("deviceId like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotLike(String value) {
            addCriterion("deviceId not like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<String> values) {
            addCriterion("deviceId in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<String> values) {
            addCriterion("deviceId not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(String value1, String value2) {
            addCriterion("deviceId between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(String value1, String value2) {
            addCriterion("deviceId not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andAppVersionIsNull() {
            addCriterion("appVersion is null");
            return (Criteria) this;
        }

        public Criteria andAppVersionIsNotNull() {
            addCriterion("appVersion is not null");
            return (Criteria) this;
        }

        public Criteria andAppVersionEqualTo(String value) {
            addCriterion("appVersion =", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotEqualTo(String value) {
            addCriterion("appVersion <>", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionGreaterThan(String value) {
            addCriterion("appVersion >", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionGreaterThanOrEqualTo(String value) {
            addCriterion("appVersion >=", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionLessThan(String value) {
            addCriterion("appVersion <", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionLessThanOrEqualTo(String value) {
            addCriterion("appVersion <=", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionLike(String value) {
            addCriterion("appVersion like", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotLike(String value) {
            addCriterion("appVersion not like", value, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionIn(List<String> values) {
            addCriterion("appVersion in", values, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotIn(List<String> values) {
            addCriterion("appVersion not in", values, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionBetween(String value1, String value2) {
            addCriterion("appVersion between", value1, value2, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppVersionNotBetween(String value1, String value2) {
            addCriterion("appVersion not between", value1, value2, "appVersion");
            return (Criteria) this;
        }

        public Criteria andAppChannelIsNull() {
            addCriterion("appChannel is null");
            return (Criteria) this;
        }

        public Criteria andAppChannelIsNotNull() {
            addCriterion("appChannel is not null");
            return (Criteria) this;
        }

        public Criteria andAppChannelEqualTo(String value) {
            addCriterion("appChannel =", value, "appChannel");
            return (Criteria) this;
        }

        public Criteria andAppChannelNotEqualTo(String value) {
            addCriterion("appChannel <>", value, "appChannel");
            return (Criteria) this;
        }

        public Criteria andAppChannelGreaterThan(String value) {
            addCriterion("appChannel >", value, "appChannel");
            return (Criteria) this;
        }

        public Criteria andAppChannelGreaterThanOrEqualTo(String value) {
            addCriterion("appChannel >=", value, "appChannel");
            return (Criteria) this;
        }

        public Criteria andAppChannelLessThan(String value) {
            addCriterion("appChannel <", value, "appChannel");
            return (Criteria) this;
        }

        public Criteria andAppChannelLessThanOrEqualTo(String value) {
            addCriterion("appChannel <=", value, "appChannel");
            return (Criteria) this;
        }

        public Criteria andAppChannelLike(String value) {
            addCriterion("appChannel like", value, "appChannel");
            return (Criteria) this;
        }

        public Criteria andAppChannelNotLike(String value) {
            addCriterion("appChannel not like", value, "appChannel");
            return (Criteria) this;
        }

        public Criteria andAppChannelIn(List<String> values) {
            addCriterion("appChannel in", values, "appChannel");
            return (Criteria) this;
        }

        public Criteria andAppChannelNotIn(List<String> values) {
            addCriterion("appChannel not in", values, "appChannel");
            return (Criteria) this;
        }

        public Criteria andAppChannelBetween(String value1, String value2) {
            addCriterion("appChannel between", value1, value2, "appChannel");
            return (Criteria) this;
        }

        public Criteria andAppChannelNotBetween(String value1, String value2) {
            addCriterion("appChannel not between", value1, value2, "appChannel");
            return (Criteria) this;
        }

        public Criteria andAppPlatformIsNull() {
            addCriterion("appPlatform is null");
            return (Criteria) this;
        }

        public Criteria andAppPlatformIsNotNull() {
            addCriterion("appPlatform is not null");
            return (Criteria) this;
        }

        public Criteria andAppPlatformEqualTo(String value) {
            addCriterion("appPlatform =", value, "appPlatform");
            return (Criteria) this;
        }

        public Criteria andAppPlatformNotEqualTo(String value) {
            addCriterion("appPlatform <>", value, "appPlatform");
            return (Criteria) this;
        }

        public Criteria andAppPlatformGreaterThan(String value) {
            addCriterion("appPlatform >", value, "appPlatform");
            return (Criteria) this;
        }

        public Criteria andAppPlatformGreaterThanOrEqualTo(String value) {
            addCriterion("appPlatform >=", value, "appPlatform");
            return (Criteria) this;
        }

        public Criteria andAppPlatformLessThan(String value) {
            addCriterion("appPlatform <", value, "appPlatform");
            return (Criteria) this;
        }

        public Criteria andAppPlatformLessThanOrEqualTo(String value) {
            addCriterion("appPlatform <=", value, "appPlatform");
            return (Criteria) this;
        }

        public Criteria andAppPlatformLike(String value) {
            addCriterion("appPlatform like", value, "appPlatform");
            return (Criteria) this;
        }

        public Criteria andAppPlatformNotLike(String value) {
            addCriterion("appPlatform not like", value, "appPlatform");
            return (Criteria) this;
        }

        public Criteria andAppPlatformIn(List<String> values) {
            addCriterion("appPlatform in", values, "appPlatform");
            return (Criteria) this;
        }

        public Criteria andAppPlatformNotIn(List<String> values) {
            addCriterion("appPlatform not in", values, "appPlatform");
            return (Criteria) this;
        }

        public Criteria andAppPlatformBetween(String value1, String value2) {
            addCriterion("appPlatform between", value1, value2, "appPlatform");
            return (Criteria) this;
        }

        public Criteria andAppPlatformNotBetween(String value1, String value2) {
            addCriterion("appPlatform not between", value1, value2, "appPlatform");
            return (Criteria) this;
        }

        public Criteria andOsTypeIsNull() {
            addCriterion("osType is null");
            return (Criteria) this;
        }

        public Criteria andOsTypeIsNotNull() {
            addCriterion("osType is not null");
            return (Criteria) this;
        }

        public Criteria andOsTypeEqualTo(String value) {
            addCriterion("osType =", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeNotEqualTo(String value) {
            addCriterion("osType <>", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeGreaterThan(String value) {
            addCriterion("osType >", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("osType >=", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeLessThan(String value) {
            addCriterion("osType <", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeLessThanOrEqualTo(String value) {
            addCriterion("osType <=", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeLike(String value) {
            addCriterion("osType like", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeNotLike(String value) {
            addCriterion("osType not like", value, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeIn(List<String> values) {
            addCriterion("osType in", values, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeNotIn(List<String> values) {
            addCriterion("osType not in", values, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeBetween(String value1, String value2) {
            addCriterion("osType between", value1, value2, "osType");
            return (Criteria) this;
        }

        public Criteria andOsTypeNotBetween(String value1, String value2) {
            addCriterion("osType not between", value1, value2, "osType");
            return (Criteria) this;
        }

        public Criteria andDeviceStyleIsNull() {
            addCriterion("deviceStyle is null");
            return (Criteria) this;
        }

        public Criteria andDeviceStyleIsNotNull() {
            addCriterion("deviceStyle is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceStyleEqualTo(String value) {
            addCriterion("deviceStyle =", value, "deviceStyle");
            return (Criteria) this;
        }

        public Criteria andDeviceStyleNotEqualTo(String value) {
            addCriterion("deviceStyle <>", value, "deviceStyle");
            return (Criteria) this;
        }

        public Criteria andDeviceStyleGreaterThan(String value) {
            addCriterion("deviceStyle >", value, "deviceStyle");
            return (Criteria) this;
        }

        public Criteria andDeviceStyleGreaterThanOrEqualTo(String value) {
            addCriterion("deviceStyle >=", value, "deviceStyle");
            return (Criteria) this;
        }

        public Criteria andDeviceStyleLessThan(String value) {
            addCriterion("deviceStyle <", value, "deviceStyle");
            return (Criteria) this;
        }

        public Criteria andDeviceStyleLessThanOrEqualTo(String value) {
            addCriterion("deviceStyle <=", value, "deviceStyle");
            return (Criteria) this;
        }

        public Criteria andDeviceStyleLike(String value) {
            addCriterion("deviceStyle like", value, "deviceStyle");
            return (Criteria) this;
        }

        public Criteria andDeviceStyleNotLike(String value) {
            addCriterion("deviceStyle not like", value, "deviceStyle");
            return (Criteria) this;
        }

        public Criteria andDeviceStyleIn(List<String> values) {
            addCriterion("deviceStyle in", values, "deviceStyle");
            return (Criteria) this;
        }

        public Criteria andDeviceStyleNotIn(List<String> values) {
            addCriterion("deviceStyle not in", values, "deviceStyle");
            return (Criteria) this;
        }

        public Criteria andDeviceStyleBetween(String value1, String value2) {
            addCriterion("deviceStyle between", value1, value2, "deviceStyle");
            return (Criteria) this;
        }

        public Criteria andDeviceStyleNotBetween(String value1, String value2) {
            addCriterion("deviceStyle not between", value1, value2, "deviceStyle");
            return (Criteria) this;
        }

        public Criteria andPageViewCntInSessionIsNull() {
            addCriterion("pageViewCntInSession is null");
            return (Criteria) this;
        }

        public Criteria andPageViewCntInSessionIsNotNull() {
            addCriterion("pageViewCntInSession is not null");
            return (Criteria) this;
        }

        public Criteria andPageViewCntInSessionEqualTo(Integer value) {
            addCriterion("pageViewCntInSession =", value, "pageViewCntInSession");
            return (Criteria) this;
        }

        public Criteria andPageViewCntInSessionNotEqualTo(Integer value) {
            addCriterion("pageViewCntInSession <>", value, "pageViewCntInSession");
            return (Criteria) this;
        }

        public Criteria andPageViewCntInSessionGreaterThan(Integer value) {
            addCriterion("pageViewCntInSession >", value, "pageViewCntInSession");
            return (Criteria) this;
        }

        public Criteria andPageViewCntInSessionGreaterThanOrEqualTo(Integer value) {
            addCriterion("pageViewCntInSession >=", value, "pageViewCntInSession");
            return (Criteria) this;
        }

        public Criteria andPageViewCntInSessionLessThan(Integer value) {
            addCriterion("pageViewCntInSession <", value, "pageViewCntInSession");
            return (Criteria) this;
        }

        public Criteria andPageViewCntInSessionLessThanOrEqualTo(Integer value) {
            addCriterion("pageViewCntInSession <=", value, "pageViewCntInSession");
            return (Criteria) this;
        }

        public Criteria andPageViewCntInSessionIn(List<Integer> values) {
            addCriterion("pageViewCntInSession in", values, "pageViewCntInSession");
            return (Criteria) this;
        }

        public Criteria andPageViewCntInSessionNotIn(List<Integer> values) {
            addCriterion("pageViewCntInSession not in", values, "pageViewCntInSession");
            return (Criteria) this;
        }

        public Criteria andPageViewCntInSessionBetween(Integer value1, Integer value2) {
            addCriterion("pageViewCntInSession between", value1, value2, "pageViewCntInSession");
            return (Criteria) this;
        }

        public Criteria andPageViewCntInSessionNotBetween(Integer value1, Integer value2) {
            addCriterion("pageViewCntInSession not between", value1, value2, "pageViewCntInSession");
            return (Criteria) this;
        }

        public Criteria andPageIdIsNull() {
            addCriterion("pageId is null");
            return (Criteria) this;
        }

        public Criteria andPageIdIsNotNull() {
            addCriterion("pageId is not null");
            return (Criteria) this;
        }

        public Criteria andPageIdEqualTo(String value) {
            addCriterion("pageId =", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdNotEqualTo(String value) {
            addCriterion("pageId <>", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdGreaterThan(String value) {
            addCriterion("pageId >", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdGreaterThanOrEqualTo(String value) {
            addCriterion("pageId >=", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdLessThan(String value) {
            addCriterion("pageId <", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdLessThanOrEqualTo(String value) {
            addCriterion("pageId <=", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdLike(String value) {
            addCriterion("pageId like", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdNotLike(String value) {
            addCriterion("pageId not like", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdIn(List<String> values) {
            addCriterion("pageId in", values, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdNotIn(List<String> values) {
            addCriterion("pageId not in", values, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdBetween(String value1, String value2) {
            addCriterion("pageId between", value1, value2, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdNotBetween(String value1, String value2) {
            addCriterion("pageId not between", value1, value2, "pageId");
            return (Criteria) this;
        }

        public Criteria andVisitIndexIsNull() {
            addCriterion("visitIndex is null");
            return (Criteria) this;
        }

        public Criteria andVisitIndexIsNotNull() {
            addCriterion("visitIndex is not null");
            return (Criteria) this;
        }

        public Criteria andVisitIndexEqualTo(Integer value) {
            addCriterion("visitIndex =", value, "visitIndex");
            return (Criteria) this;
        }

        public Criteria andVisitIndexNotEqualTo(Integer value) {
            addCriterion("visitIndex <>", value, "visitIndex");
            return (Criteria) this;
        }

        public Criteria andVisitIndexGreaterThan(Integer value) {
            addCriterion("visitIndex >", value, "visitIndex");
            return (Criteria) this;
        }

        public Criteria andVisitIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("visitIndex >=", value, "visitIndex");
            return (Criteria) this;
        }

        public Criteria andVisitIndexLessThan(Integer value) {
            addCriterion("visitIndex <", value, "visitIndex");
            return (Criteria) this;
        }

        public Criteria andVisitIndexLessThanOrEqualTo(Integer value) {
            addCriterion("visitIndex <=", value, "visitIndex");
            return (Criteria) this;
        }

        public Criteria andVisitIndexIn(List<Integer> values) {
            addCriterion("visitIndex in", values, "visitIndex");
            return (Criteria) this;
        }

        public Criteria andVisitIndexNotIn(List<Integer> values) {
            addCriterion("visitIndex not in", values, "visitIndex");
            return (Criteria) this;
        }

        public Criteria andVisitIndexBetween(Integer value1, Integer value2) {
            addCriterion("visitIndex between", value1, value2, "visitIndex");
            return (Criteria) this;
        }

        public Criteria andVisitIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("visitIndex not between", value1, value2, "visitIndex");
            return (Criteria) this;
        }

        public Criteria andNextPageIsNull() {
            addCriterion("nextPage is null");
            return (Criteria) this;
        }

        public Criteria andNextPageIsNotNull() {
            addCriterion("nextPage is not null");
            return (Criteria) this;
        }

        public Criteria andNextPageEqualTo(String value) {
            addCriterion("nextPage =", value, "nextPage");
            return (Criteria) this;
        }

        public Criteria andNextPageNotEqualTo(String value) {
            addCriterion("nextPage <>", value, "nextPage");
            return (Criteria) this;
        }

        public Criteria andNextPageGreaterThan(String value) {
            addCriterion("nextPage >", value, "nextPage");
            return (Criteria) this;
        }

        public Criteria andNextPageGreaterThanOrEqualTo(String value) {
            addCriterion("nextPage >=", value, "nextPage");
            return (Criteria) this;
        }

        public Criteria andNextPageLessThan(String value) {
            addCriterion("nextPage <", value, "nextPage");
            return (Criteria) this;
        }

        public Criteria andNextPageLessThanOrEqualTo(String value) {
            addCriterion("nextPage <=", value, "nextPage");
            return (Criteria) this;
        }

        public Criteria andNextPageLike(String value) {
            addCriterion("nextPage like", value, "nextPage");
            return (Criteria) this;
        }

        public Criteria andNextPageNotLike(String value) {
            addCriterion("nextPage not like", value, "nextPage");
            return (Criteria) this;
        }

        public Criteria andNextPageIn(List<String> values) {
            addCriterion("nextPage in", values, "nextPage");
            return (Criteria) this;
        }

        public Criteria andNextPageNotIn(List<String> values) {
            addCriterion("nextPage not in", values, "nextPage");
            return (Criteria) this;
        }

        public Criteria andNextPageBetween(String value1, String value2) {
            addCriterion("nextPage between", value1, value2, "nextPage");
            return (Criteria) this;
        }

        public Criteria andNextPageNotBetween(String value1, String value2) {
            addCriterion("nextPage not between", value1, value2, "nextPage");
            return (Criteria) this;
        }

        public Criteria andStayDurationSecsIsNull() {
            addCriterion("stayDurationSecs is null");
            return (Criteria) this;
        }

        public Criteria andStayDurationSecsIsNotNull() {
            addCriterion("stayDurationSecs is not null");
            return (Criteria) this;
        }

        public Criteria andStayDurationSecsEqualTo(Long value) {
            addCriterion("stayDurationSecs =", value, "stayDurationSecs");
            return (Criteria) this;
        }

        public Criteria andStayDurationSecsNotEqualTo(Long value) {
            addCriterion("stayDurationSecs <>", value, "stayDurationSecs");
            return (Criteria) this;
        }

        public Criteria andStayDurationSecsGreaterThan(Long value) {
            addCriterion("stayDurationSecs >", value, "stayDurationSecs");
            return (Criteria) this;
        }

        public Criteria andStayDurationSecsGreaterThanOrEqualTo(Long value) {
            addCriterion("stayDurationSecs >=", value, "stayDurationSecs");
            return (Criteria) this;
        }

        public Criteria andStayDurationSecsLessThan(Long value) {
            addCriterion("stayDurationSecs <", value, "stayDurationSecs");
            return (Criteria) this;
        }

        public Criteria andStayDurationSecsLessThanOrEqualTo(Long value) {
            addCriterion("stayDurationSecs <=", value, "stayDurationSecs");
            return (Criteria) this;
        }

        public Criteria andStayDurationSecsIn(List<Long> values) {
            addCriterion("stayDurationSecs in", values, "stayDurationSecs");
            return (Criteria) this;
        }

        public Criteria andStayDurationSecsNotIn(List<Long> values) {
            addCriterion("stayDurationSecs not in", values, "stayDurationSecs");
            return (Criteria) this;
        }

        public Criteria andStayDurationSecsBetween(Long value1, Long value2) {
            addCriterion("stayDurationSecs between", value1, value2, "stayDurationSecs");
            return (Criteria) this;
        }

        public Criteria andStayDurationSecsNotBetween(Long value1, Long value2) {
            addCriterion("stayDurationSecs not between", value1, value2, "stayDurationSecs");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}