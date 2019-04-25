package com.cuilihuan.applogs.visualize.service;

import com.cuilihuan.applogs.visualize.dao.StatMapper;
import com.cuilihuan.applogs.visualize.domain.InfoPorovinceAndNumBean;
import com.cuilihuan.applogs.visualize.domain.StatBean;
import com.cuilihuan.applogs.visualize.util.DayFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by atguigu on 2017/11/9
 */
@Service("statService")
public class StatServiceImpl implements StatService {
    @Autowired
    StatMapper statMapper;


    /**
     * 查询新增用户
     */
    public StatBean findNewUsers() {
        return statMapper.findNewUsers();
    }

    @Override
    public List<StatBean> findThisWeekNewUsers(String sdk34734) {
        return statMapper.findThisWeekNewUsers(sdk34734);
    }

    @Override
    public void insertLogs() {

    }

    /**
     * 查找每周的活跃人数
     *
     * @param appId app标识符
     * @return 封装好的json
     */
    @Override
    public Map<String, Object> findThisWeekActiveUsers(String appId) {
        Map<String, Object> map = new HashMap<>();
        List<StatBean> list = statMapper.selectThisWeekActive(appId);
        String[] date = DayFormat.getBeforeSevenDay();
        String[] num = new String[date.length];
        for (int i = 0; i < date.length; i++) {
            num[i] = getActiveByDate(date[i], list);
        }
        map.put("time", date);
        map.put("date", num);
        return map;
    }


    /**
     * 查看每个版本对应的沉默用户人数
     *
     * @param appId 要计算的APP标识符
     * @return 返回带有人数的Map集合
     */
    public Map<String, Object> findSilenceUsers(String appId) {
        List<StatBean> list = statMapper.selectSilenceUser(appId);
        System.out.println(list + "===");
        Map<String, Object> map = new HashMap<>();
        String[] appVersion = {"3.2.1", "3.2.2", "3.2.3"};
        String[] peopleNum = new String[appVersion.length];
        for (int i = 0; i < appVersion.length; i++) {
            //求每个版本对应的沉默用户人数
            peopleNum[i] = getPeopleNumByVersion(appVersion[i], list);
        }
        map.put("appVersion", appVersion);
        map.put("data", peopleNum);
        return map;
    }

    /**
     * 查找每天启动的次数
     * @param appId 应用标识符
     * @return 返回Map数据
     */
    @Override
    public Map<String, Object> findStartUpNum(String appId) {
        List<StatBean> list = statMapper.selectStartUpNum(appId);
        Map<String, Object> map = new HashMap<>();

        //时间集合
        List<String> dateString = new ArrayList<>();
        if (list.size() > 0) {
            dateString = DayFormat.getPerDay(list.get(0).getDate(), list.get(list.size() - 1).getDate());
        }

        //版本号
        String[] version = {"3.2.1", "3.2.2", "3.2.3"};

        //数据集合
        Map<String, List<String>> dateOfList = new HashMap<>();
        for (int i = 0; i < version.length; i++) {
            dateOfList.put(version[i], new ArrayList<String>());
        }
        for (int i = 0; i < dateString.size(); i++) {
            for (int j = 0; j < version.length; j++) {
                dateOfList.get(version[j]).add(getNumOfUserByVersionAndTime(list, version[j], dateString.get(i)));
            }
        }
        map.put("version", version);
        map.put("time", dateString);
        map.put("data", dateOfList);
        return map;
    }


    public Map<String,Object> findProvinceNum() {
        List<InfoPorovinceAndNumBean> list = statMapper.selectProvinceNum();
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        if (list.size() > 0) {
            map.put("maxnum", list.get(0).getCount());
        } else {
            map.put("maxnum", "10");
        }
        return map;
    }

    /**
     * 根据版本、时间号来寻找对应的人数
     * @param list 带有版本，时间号的人数集合
     * @param version 版本号
     * @param dateString 时间
     * @return 返回人数
     */
    private String getNumOfUserByVersionAndTime(List<StatBean> list, String version, String dateString) {
        for (int i = 0; i < list.size(); i++) {
            if (dateString.equals(list.get(i).getDate())) {
                if (version.equals(list.get(i).getAppVersion())) {
                    return String.valueOf(list.get(i).getCount());
                }

            }
        }
        return "0";
    }



    /**
     * 根据传入的版本号来获取对应的沉默用户人数
     *
     * @param s    版本号
     * @param list 要查找的集合
     * @return 返回的对应人数
     */
    private String getPeopleNumByVersion(String s, List<StatBean> list) {
        for (int i = 0; i < list.size(); i++) {
            if (s.equals(list.get(i).getAppVersion())) {
                return String.valueOf(list.get(i).getCount());
            }
        }
        return "0";
    }


    /**
     * 根据时间来获得对应的人数，如果没有，则返回0
     *
     * @param s    时间
     * @param list 要查找的人数集合
     * @return 返回对应的人数
     */
    private String getActiveByDate(String s, List<StatBean> list) {

        for (int i = 0; i < list.size(); i++) {
            //判断若找到那个时间点，就把对就的人数返回来
            if (s.equals(list.get(i).getDate())) {
                return String.valueOf(list.get(i).getCount());
            }
        }
        return "0";
    }


}
