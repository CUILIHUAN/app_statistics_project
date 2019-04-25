package com.cuilihuan.applogs.visualize.controller;

import com.cuilihuan.applogs.visualize.dao.AppStartupLogMapper;
import com.cuilihuan.applogs.visualize.dao.StatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

/**
 * @Auther:Cui LiHuan
 * @Date: 2019/4/25 10:38
 * @Description:
 */

@Controller
public class test {

    @Autowired
    AppStartupLogMapper appStartupLogMapper;
    @Autowired
    StatMapper statMapper;
    String[] province = {"北京","天津","上海","重庆","河北","" +
            "山西","辽宁","吉林","黑龙江","江苏","" +
            "浙江","安徽","福建","江西","山东","" +
            "河南","湖北","湖南","广东","海南","" +
            "四川","贵州","云南","陕西","甘肃","" +
            "青海","内蒙古","广西","西藏","宁夏","" +
            "新疆","香港","澳门","台湾"};
   @RequestMapping("/test")
    public void insertStartup() {
       for (int i = 0; i < 675; i++) {

           Random random = new Random();
//           statMapper.updateId(i);
           System.out.println(province[random.nextInt(province.length)]);
           statMapper.updateProvince(province[random.nextInt(province.length)],i+2);
       }



//       appStartupLogMapper.selectByExample()


    }

}
