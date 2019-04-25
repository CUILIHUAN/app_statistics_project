package com.cuilihuan.applogs.visualize.dao;

import com.cuilihuan.applogs.visualize.bean.AppUsageLog;
import com.cuilihuan.applogs.visualize.bean.AppUsageLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppUsageLogMapper {
    int countByExample(AppUsageLogExample example);

    int deleteByExample(AppUsageLogExample example);

    int insert(AppUsageLog record);

    int insertSelective(AppUsageLog record);

    List<AppUsageLog> selectByExample(AppUsageLogExample example);

    int updateByExampleSelective(@Param("record") AppUsageLog record, @Param("example") AppUsageLogExample example);

    int updateByExample(@Param("record") AppUsageLog record, @Param("example") AppUsageLogExample example);
}