package com.redobj.repository.web.dao;

import com.redobj.repository.web.bean.WaitSpider;
import com.redobj.repository.web.bean.WaitSpiderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaitSpiderMapper {
    int countByExample(WaitSpiderExample example);

    int deleteByExample(WaitSpiderExample example);

    int deleteByPrimaryKey(Integer waitId);

    int insert(WaitSpider record);

    int insertSelective(WaitSpider record);

    List<WaitSpider> selectByExample(WaitSpiderExample example);

    WaitSpider selectByPrimaryKey(Integer waitId);

    int updateByExampleSelective(@Param("record") WaitSpider record, @Param("example") WaitSpiderExample example);

    int updateByExample(@Param("record") WaitSpider record, @Param("example") WaitSpiderExample example);

    int updateByPrimaryKeySelective(WaitSpider record);

    int updateByPrimaryKey(WaitSpider record);
}