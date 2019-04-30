package com.cuilihuan.applogs.visualize.service;

import com.cuilihuan.applogs.visualize.dao.StatMapper;
import com.cuilihuan.applogs.visualize.domain.*;
import com.cuilihuan.applogs.visualize.util.DayFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


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
     * 对设备机型进行分析
     *
     * @param appId 应用标识符
     * @return 返回Json数据
     */
    public List<DeviceAnalysisBean> findDeviceAnalysis(String appId) {
        List<DeviceAnalysisBean> list = new ArrayList<>();
        List<StatBean> devices = statMapper.selectDevicesOfNUM(appId);
        int allSum = 0;
        for (int i = 0; i < devices.size(); i++) {
            DeviceAnalysisBean deviceAnalysisBean = new DeviceAnalysisBean();
            deviceAnalysisBean.setName(devices.get(i).getDeviceName());
            allSum += devices.get(i).getCount();
            deviceAnalysisBean.setY((int) devices.get(i).getCount());
            List<StatBean> devicesOfNUMByVersion = statMapper.selectDevicesOfNUMByVersion(appId, devices.get(i).getDeviceName());

            int versionSum = 0;
            Drilldrilldown down = new Drilldrilldown();
            down.setName(devices.get(i).getDeviceName());
            down.setId(devices.get(i).getDeviceName());
            for (int j = 0; j < devicesOfNUMByVersion.size(); j++) {
                List<Object> data = new ArrayList<>();
                data.add(devicesOfNUMByVersion.get(j).getAppVersion());
                data.add(devicesOfNUMByVersion.get(j).getCount());
                versionSum += devicesOfNUMByVersion.get(j).getCount();
                down.getData().add(data);
            }
            for (int j = 0; j < down.getData().size(); j++) {
                long num = (long) down.getData().get(j).remove(1);
                down.getData().get(j).add((float) num / versionSum * 100);
            }

            deviceAnalysisBean.setDrilldrilldown(down);
            list.add(deviceAnalysisBean);
        }

        for (int i = 0; i < list.size(); i++) {
            float num = list.get(i).getY();
            list.get(i).setY(num / allSum * 100);
        }
        return list;

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
     *
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


    /**
     * 查找用户的新鲜度
     *
     * @param appId 应用标识符
     * @return 返回string类型的数据
     */
    public String findUserFreshness(String appId) {
        System.out.println("appId:" + appId);
        String startTime = DayFormat.beforeMonth()[0];
        String endTime = DayFormat.beforeMonth()[1];
        List<String> perDay = DayFormat.getPerDay(startTime, endTime);
        String allnum = ""; //通过拼接，变成Json数据格式的字符串
        for (int i = 0; i < perDay.size(); i++) {
            String[] nums = new String[2];
            nums[0] = String.valueOf(DayFormat.dateToString(perDay.get(i)));
            allnum += ",[" + nums[0];
            int allUsers = statMapper.selectDayOfNewUsersAllUsers(perDay.get(i), appId); //查找总人数
            int newUsers = statMapper.selectDayOfNewUsersAllVersion(perDay.get(i), appId); //查找每天的新增人数
            if (allUsers != 0)
                nums[1] = String.valueOf((float) newUsers / allUsers);
            else
                nums[1] = "0";
            allnum += "," + nums[1] + "]";

        }
        allnum = allnum.substring(1);
        allnum = "[" + allnum + "]";
        System.out.println(allnum);
        return allnum;
    }

    /**
     * 查找日活跃率
     *
     * @param appId
     * @return
     */
    @Override
    public String findUserActiveRate(String appId) {
        String startTime = DayFormat.beforeMonth()[0];
        String endTime = DayFormat.beforeMonth()[1];
        List<String> perDay = DayFormat.getPerDay(startTime, endTime);
        String rate;
        String activeUserRate = "";
        for (int i = 0; i < perDay.size(); i++) {
            activeUserRate += ",[" + DayFormat.dateToString(perDay.get(i));
            int allUsers = statMapper.selectDayOfNewUsersAllUsers(perDay.get(i), appId); //查找总人数
            int activeUsers = statMapper.selectDayOfActiveUsers(perDay.get(i), appId); //查找每天的新增人数
            if (allUsers != 0)
                rate = String.valueOf((float) activeUsers / allUsers);
            else
                rate = "0";
            activeUserRate += "," + rate + "]";

        }
        activeUserRate = activeUserRate.substring(1);
        activeUserRate = "[" + activeUserRate + "]";
        System.out.println(activeUserRate);
        return activeUserRate;
    }

    /**
     * 查找每省的人数
     *
     * @return 返回JSON数据类型
     */
    public Map<String, Object> findProvinceNum() {
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
     * 查找留存用户
     *
     * @param time      时间段
     * @param appId     应用标识符
     * @param versionId 版本标识符
     * @return 返回Json数据格式
     */
    @Override
    public List<RetentionAnalaysisBean> findRetentionAnalaysisBean(String time, String appId, String versionId) {
        List<RetentionAnalaysisBean> list = new ArrayList<>();
        time = time.replaceAll("-", "/");
        String startTime = time.split(" / ")[0];
        String endTime = time.split(" / ")[1];
        List<String> perDay = DayFormat.getPerDay(startTime, endTime);
        int num[] = {1, 2, 3, 4, 5, 6, 7, 14, 30};

        for (int i = 0; i < perDay.size(); i++) {
            RetentionAnalaysisBean bean = new RetentionAnalaysisBean();
            bean.setTime(perDay.get(i));
            List<String> userNum = statMapper.selectDayOfNewUsers(appId, versionId, perDay.get(i));
            bean.setAdduser(String.valueOf(userNum.size()));
            for (int j = 0; j < num.length; j++) {
                if (DayFormat.compare_date(perDay.get(i), DayFormat.getCurrentDay(), num[j]))
                    bean.getDay()[j] = String.valueOf(statMapper.selectPerDaysOfUsage(perDay.get(i), appId, versionId, num[j], userNum));
                else
                    bean.getDay()[j] = "-";
            }
            bean.init();
            list.add(bean);
        }
        return list;
    }

    /**
     * 通过应用标识来查找网络终端对就的类型
     *
     * @param appId 应用标识符
     * @return 返回Json数据
     */
    public Map<String, Object> findnetWorkNumsByAppId(String appId) {
        List<StatBean> list = statMapper.selectNetWorkByAppId(appId);
        String[] versions = {"3.2.1", "3.2.2", "3.2.3"};
        List<String> netWorkNames = getNetWorkNames(list);

        List<Map<String, Object>> dataList = new ArrayList<>();
        System.out.println("netWorkNames:" + netWorkNames);
        for (int i = 0; i < versions.length; i++) {
            Map<String, Object> map = new HashMap<>();
            int[] netWorkOfnums = new int[netWorkNames.size()];
            for (int j = 0; j < netWorkNames.size(); j++) {
                netWorkOfnums[j] = getNetWorkNumsByVersionAndDeviceName(list, netWorkNames.get(j), versions[i]);
            }
            map.put("name", versions[i]);
            map.put("data", netWorkOfnums);

            dataList.add(map);
        }

        Map<String, Object> returnList = new HashMap<>();
        returnList.put("categories", netWorkNames);
        returnList.put("data", dataList);
        return returnList;
    }


    public Map<String, Object> findUsageTimes(String appId, String time) {
        time = time.replaceAll("-", "/");
        List<StatBean> list = statMapper.selectUseTimes(appId, time);
        String[] timePer = {"0-30s", "31-60s", "60-90s", "90-180s", "180以上"};
        String[] appVersion = {"3.2.1", "3.2.2", "3.2.3"};
        List<Object> dataList = new ArrayList<>();
        for (int i = 0; i < appVersion.length; i++) {
            Map<String, Object> map = new HashMap<>();
            int[] data = new int[timePer.length];
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getAppVersion().equals(appVersion[i])) {
                    data[getNumByTrueTime((int) list.get(j).getCount())]++;
                }
            }
            map.put("name", appVersion[i]);
            map.put("data", data);
            dataList.add(map);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("categories", timePer);
        map.put("data", dataList);
        return map;
    }


    public int getNumByTrueTime(int num) {
        if (num > 0 && num <= 30) {
            return 0;
        } else if (num >= 31 && num <= 60) {
            return 1;
        } else if (num >= 61 && num <= 90) {
            return 2;
        } else if (num >= 91 && num <= 180) {
            return 3;
        } else {
            return 4;
        }
    }

    /**
     * 通过版本与设备名来获取对应网络人数
     * @param list 要查询的List
     * @param netWorkName 网络类型
     * @param appVersion 手机标识符
     * @return 返回Json数据类型
     */
    private int getNetWorkNumsByVersionAndDeviceName(List<StatBean> list, String netWorkName, String appVersion) {
        for (int i = 0; i < list.size(); i++) {
            if (netWorkName.equals(list.get(i).getNetWork()) && appVersion.equals(list.get(i).getAppVersion())) {
                return (int) list.get(i).getCount();
            }
        }
        return 0;
    }

    /**
     * 获得所有的网络类型
     * @param list 查询的集合
     * @return 返回所有的网络名
     */
    public List<String> getNetWorkNames(List<StatBean> list) {
        List<String> returnList = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i).getNetWork());
        }
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String str = it.next();
            returnList.add(str);
        }
        return returnList;

    }


    /**
     * 根据版本、时间号来寻找对应的人数
     *
     * @param list       带有版本，时间号的人数集合
     * @param version    版本号
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
