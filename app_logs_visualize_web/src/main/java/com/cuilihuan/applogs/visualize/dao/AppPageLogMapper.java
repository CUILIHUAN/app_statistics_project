package com.cuilihuan.applogs.visualize.dao;

import com.cuilihuan.applogs.visualize.bean.AppPageLog;
import com.cuilihuan.applogs.visualize.bean.AppPageLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppPageLogMapper {
    int countByExample(AppPageLogExample example);

    int deleteByExample(AppPageLogExample example);

    int insert(AppPageLog record);

    int insertSelective(AppPageLog record);

    List<AppPageLog> selectByExample(AppPageLogExample example);

    int updateByExampleSelective(@Param("record") AppPageLog record, @Param("example") AppPageLogExample example);

    int updateByExample(@Param("record") AppPageLog record, @Param("example") AppPageLogExample example);
}