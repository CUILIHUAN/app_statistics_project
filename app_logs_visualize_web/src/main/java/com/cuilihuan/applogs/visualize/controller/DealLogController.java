package com.cuilihuan.applogs.visualize.controller;

import com.cuilihuan.app.common.GeoInfo;
import com.cuilihuan.app.utils.GeoUtil;
import com.cuilihuan.applogs.visualize.bean.*;
import com.cuilihuan.applogs.visualize.dao.*;
import com.cuilihuan.applogs.visualize.domain.JsonBean;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Auther:Cui LiHuan
 * @Date: 2019/4/20 17:23
 * @Description:
 */


@Controller
public class DealLogController {
    @Autowired
    AppErrorLogMapper appErrorLogMapper;
    @Autowired
    AppEventLogMapper appEventLogMapper;
    @Autowired
    AppPageLogMapper appPageLogMapper;
    @Autowired
    AppStartupLogMapper appStartupLogMapper;
    @Autowired
    AppUsageLogMapper appUsageLogMapper;

    // 缓存地址信息
    private Map<String, GeoInfo> cache = new HashMap<String, GeoInfo>();

    @RequestMapping("/index")
    @ResponseBody
    public void collect(@RequestBody String logString, HttpServletRequest req) {


        Gson gs = new Gson();
        JsonBean e = gs.fromJson(logString, JsonBean.class);

        AppErrorLog appErrorLog = new AppErrorLog();
        BeanUtils.copyProperties(e.getAppErrorLogs().get(0), appErrorLog);
        appErrorLogMapper.insert(appErrorLog);

        AppEventLog appEventLog = new AppEventLog();
        BeanUtils.copyProperties(e.getAppEventLogs().get(0), appEventLog);
        appEventLog.setParamKeyValueMap(e.getAppEventLogs().get(0).getParamKeyValueMap().toString());
        appEventLogMapper.insert(appEventLog);

        AppPageLog appPageLog = new AppPageLog();
        BeanUtils.copyProperties(e.getAppPageLogs().get(0), appPageLog);
        appPageLogMapper.insert(appPageLog);


        AppStartupLog appStartupLog = new AppStartupLog();
        BeanUtils.copyProperties(e.getAppStartupLogs().get(0), appStartupLog);
        // 1 获取客户端ip地址
        String clientIP = req.getRemoteAddr();

        // 2 从缓存中获取数据
        GeoInfo geoInfo = cache.get(clientIP);

        // 如果该客户端ip地址没有获取过国家和省份信息，则通过工具类获取；
        // 如果该客户端ip地址已经获取过国家和省份信息，则直接从缓存对象中获取
        if (geoInfo == null) {
            geoInfo = new GeoInfo();
            geoInfo.setCountry(GeoUtil.getCountry(clientIP));
            geoInfo.setProvince(GeoUtil.getProvince(clientIP));

            // 缓存数据
            cache.put(clientIP, geoInfo);
        }

        // 3 设置国家、省份和客户端ip地址信息

        String[] province = {"北京", "天津", "上海", "重庆", "" +
                "山西", "辽宁",   "江苏", "" +
                "浙江", "安徽", "福建", "江西", "山东", "" +
                 "湖北", "湖南", "广东",  "" +
                "四川", "贵州",  "陕西", "甘肃", "" +
                 "香港", "澳门", "台湾"};
        Random random = new Random();
        appStartupLog.setCountry(geoInfo.getCountry());

        System.out.println("geoInfo.getProvince" + geoInfo.getProvince());
//        if ("".equals(geoInfo.getProvince())) {

//            appStartupLog.setProvince(geoInfo.getProvince());
//        } else {
        appStartupLog.setProvince(province[random.nextInt(province.length)]);
//        }

        appStartupLog.setIpAddress(clientIP);

        appStartupLogMapper.insert(appStartupLog);

        AppUsageLog appUsageLog = new AppUsageLog();
        BeanUtils.copyProperties(e.getAppUsageLogs().get(0), appUsageLog);
        appUsageLogMapper.insert(appUsageLog);


    }
}
