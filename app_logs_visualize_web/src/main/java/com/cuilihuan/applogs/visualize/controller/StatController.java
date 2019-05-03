package com.cuilihuan.applogs.visualize.controller;

import com.cuilihuan.applogs.visualize.domain.*;
import com.cuilihuan.applogs.visualize.service.StatService;
import com.cuilihuan.applogs.visualize.util.DayFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/stat")
public class StatController {

    @Resource(name = "statService")
    private StatService ss;

    @RequestMapping("/test")
    @ResponseBody
    public void test(@RequestBody JsonBean e) {
        System.out.println("aaa");
        System.out.println(e);
    }

    /**
     * appid = "sdk34734"
     * 本周每天新增用户数
     */
    @RequestMapping("/newusers")
    @ResponseBody
    public StatBean findNewUsers() {
        StatBean bean = ss.findNewUsers();
        return bean;
    }

    /**
     * 查看每日的活跃率
     *
     * @param appId 应用标识符
     * @return 返回string类型的字符串
     */
    @RequestMapping("/activerateofday")
    @ResponseBody
    public String findActiveRateOfDay(String appId) {
        return ss.findUserActiveRate(appId);
    }


    /**
     * 统计每天的活跃度
     *
     * @param appId 应用标识符
     * @return 返回string类型的数据
     */
    @RequestMapping("/userfreshness")
    @ResponseBody
    public String findUserFreshness(String appId) {
        return ss.findUserFreshness(appId);
    }

    /**
     * 统计每周的新增用户数量
     */
    @RequestMapping("/week1")
    @ResponseBody
    public Map<String, Object> stat3(String selectId) {

        List<StatBean> list = ss.findThisWeekNewUsers(selectId);
        System.out.println(list);
        Map<String, Object> map = new HashMap<String, Object>();
        String[] dayBeforeSeven = DayFormat.getBeforeSevenDay();
        String[] version = {"3.2.1", "3.2.2", "3.2.3"};
        String[][] date = new String[version.length][dayBeforeSeven.length];
        for (int i = 0; i < version.length; i++) {
            for (int j = 0; j < dayBeforeSeven.length; j++) {
                date[i][j] = findDate(version[i], dayBeforeSeven[j], list);
            }
        }
        map.put("version", version);
        map.put("dayBeforeSeven", dayBeforeSeven);
        map.put("date", date);

        System.out.println(map);
        return map;
    }

    /**
     * 获得每周的活跃人数
     *
     * @param appId 要查找的APP的id号
     * @return 返回带有json数据的对象
     */
    @RequestMapping("/theweekofactiveusers")
    @ResponseBody
    public Map<String, Object> numOfWeekActiveUsers(String appId) {
        Map<String, Object> map = ss.findThisWeekActiveUsers(appId);
        return map;
    }


    /**
     * 获得每个版本的沉默用户
     *
     * @param appId 要查找的APP标识符
     * @return 返回JSON数据对象
     */
    @RequestMapping("/numofsilenceusers")
    @ResponseBody
    public Map<String, Object> numOfSilenceUsers(String appId) {
        Map<String, Object> map = ss.findSilenceUsers(appId);
        return map;
    }

    /**
     * 查看启动人数
     *
     * @param appId 应用标识
     * @return 返回Json数据
     */
    @RequestMapping("/numofstartup")
    @ResponseBody
    public Map<String, Object> numOfStartup(String appId) {
        Map<String, Object> map = ss.findStartUpNum(appId);
        return map;
    }


    /**
     * 获得每省的使用人数
     *
     * @return 返回json数据格式
     */
    @RequestMapping("/provinceofnum")
    @ResponseBody
    public Map<String, Object> provinceOfNum() {
        Map<String, Object> map = ss.findProvinceNum();
        return map;
    }

    /**
     * 查询在某一时间段内的留存用户
     *
     * @param timeframe     时间段
     * @param appidselect   应用号
     * @param versionselect 版本号
     * @return 返回json数据格式
     */
    @RequestMapping("/retentionanalaysis")
    @ResponseBody
    public List<RetentionAnalaysisBean> retentionAnalaysis(String timeframe, String appidselect, String versionselect) {
        System.out.println(timeframe + "　" + appidselect + " " + versionselect);
        return ss.findRetentionAnalaysisBean(timeframe, appidselect, versionselect);
    }


    /**
     * 查询设备
     * @param appId 应用标识符
     * @return 返回List集合
     */
    @RequestMapping("/deviceanalysis")
    @ResponseBody
    public List<DeviceAnalysisBean> DeviceAnalysis(String appId) {
        return ss.findDeviceAnalysis(appId);
    }


    /**
     * 查询使用的网络
     * @param appId 应用标识
     * @return 返回Map集合
     */
    @RequestMapping("/networknums")
    @ResponseBody
    public Map<String, Object> netWorkNums(String appId) {
        return ss.findnetWorkNumsByAppId(appId);
    }

    /**
     * 查询使用时间
     * @param appId 应用标识
     * @param time 时间
     * @return 返回Map对象
     */
    @RequestMapping("/usagetimes")
    @ResponseBody
    public Map<String, Object> usageTimes(String appId, String time) {
        return ss.findUsageTimes(appId, time);
    }


    /**
     * 查询使用率
     * @param appId 应用标识
     * @param time 时间
     * @return 返回map对象
     */
    @RequestMapping("/usagerate")
    @ResponseBody
    public Map<String, Object> usageRate(String appId, String time) {
        return ss.findUsageRate(appId, time);
    }


    /**
     * 查询错误信息
     * @param appId 应用标识
     * @param time 时间
     * @return 返回List集合
     */
    @RequestMapping("/errordetail")
    @ResponseBody
    public List<ErrorBean> errorDetail(String appId, String time) {
        return ss.findErrorDetail(time, appId);
    }

    /**
     * 查询实时统计信息
     * @return
     */
    @RequestMapping("/eachtimeinfo")
    @ResponseBody
    public Map<String,Object> eachTimeInfo() {
        return ss.findEachTimeInfo();
    }
    private String findDate(String s, String s1, List<StatBean> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAppVersion().equals(s) && list.get(i).getDate().equals(s1)) {
                return String.valueOf(list.get(i).getCount());
            }
        }
        return "0";
    }
}
