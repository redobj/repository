package com.redobj.repository.core.service;

import com.redobj.repository.core.bean.WaitSpider;
import com.redobj.repository.core.bean.WaitSpiderExample;
import com.redobj.repository.core.dao.WaitSpiderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WaitService {
    @Autowired
    private WaitSpiderMapper waitSpiderMapper;
    @Autowired
    private EnvironmentService environmentService;

    /**
     * 把商品加入等待列表
     * @param ws
     */
    public void put(WaitSpider ws){
        if(checkGoods(ws.getWaitGoods())){
            waitSpiderMapper.insertSelective(ws);
        }
    }

    /**
     * 检查等待队列
     * 如果商品已在等待队列 或 已在环境信息中存储 ，则不可再加入，返回false
     * 反之返回true
     * @param waitGoods 商品名
     * @return
     */
    private boolean checkGoods(String waitGoods) {
        WaitSpiderExample example = new WaitSpiderExample();
        WaitSpiderExample.Criteria criteria = example.createCriteria();
        criteria.andWaitGoodsEqualTo(waitGoods).andWaitStatusEqualTo(true);
        return (waitSpiderMapper.countByExample(example) == 0) && (!environmentService.checkEnvByName(waitGoods)) ;
    }

}
