package com.redobj.control.analysis.core.service;

import com.redobj.control.analysis.core.bean.WaitSpider;
import com.redobj.control.analysis.core.bean.WaitSpiderExample;
import com.redobj.control.analysis.core.dao.WaitSpiderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 等待队列 service
 */
@Component
public class WaitService {
    @Autowired
    private WaitSpiderMapper mapper;

    /**
     * 添加到 wait 队列
     * @param waitSpider
     */
    public void addWait(WaitSpider waitSpider){
            mapper.insertSelective(waitSpider);
    }

    /**
     * 判断 等待 是否已存在
     * @param name
     * @return
     */
    public boolean isWait(String name){
        WaitSpiderExample example = new WaitSpiderExample();
        WaitSpiderExample.Criteria criteria = example.createCriteria();
        criteria.andWaitGoodsEqualTo(name);
        return mapper.countByExample(example)!=0;
    }
}
