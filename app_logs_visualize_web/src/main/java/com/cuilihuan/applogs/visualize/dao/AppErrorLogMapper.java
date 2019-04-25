package com.cuilihuan.applogs.visualize.dao;

import com.cuilihuan.applogs.visualize.bean.AppErrorLog;
import com.cuilihuan.applogs.visualize.bean.AppErrorLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppErrorLogMapper {
    int countByExample(AppErrorLogExample example);

    int deleteByExample(AppErrorLogExample example);

    int insert(AppErrorLog record);

    int insertSelective(AppErrorLog record);

    List<AppErrorLog> selectByExample(AppErrorLogExample example);

    int updateByExampleSelective(@Param("record") AppErrorLog record, @Param("example") AppErrorLogExample example);

    int updateByExample(@Param("record") AppErrorLog record, @Param("example") AppErrorLogExample example);
}