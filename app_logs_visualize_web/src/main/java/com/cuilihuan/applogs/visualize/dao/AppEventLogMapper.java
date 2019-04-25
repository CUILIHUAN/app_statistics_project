package com.cuilihuan.applogs.visualize.dao;

import com.cuilihuan.applogs.visualize.bean.AppEventLog;
import com.cuilihuan.applogs.visualize.bean.AppEventLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppEventLogMapper {
    int countByExample(AppEventLogExample example);

    int deleteByExample(AppEventLogExample example);

    int insert(AppEventLog record);

    int insertSelective(AppEventLog record);

    List<AppEventLog> selectByExample(AppEventLogExample example);

    int updateByExampleSelective(@Param("record") AppEventLog record, @Param("example") AppEventLogExample example);

    int updateByExample(@Param("record") AppEventLog record, @Param("example") AppEventLogExample example);
}