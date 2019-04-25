package com.cuilihuan.applogs.visualize.dao;

import com.cuilihuan.applogs.visualize.bean.AppStartupLog;
import com.cuilihuan.applogs.visualize.bean.AppStartupLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppStartupLogMapper {
    int countByExample(AppStartupLogExample example);

    int deleteByExample(AppStartupLogExample example);

    int insert(AppStartupLog record);

    int insertSelective(AppStartupLog record);

    List<AppStartupLog> selectByExample(AppStartupLogExample example);

    int updateByExampleSelective(@Param("record") AppStartupLog record, @Param("example") AppStartupLogExample example);

    int updateByExample(@Param("record") AppStartupLog record, @Param("example") AppStartupLogExample example);
}