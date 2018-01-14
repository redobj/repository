package com.redobj.control.analysis.core.service;

import com.redobj.control.analysis.core.bean.Goods;
import com.redobj.control.analysis.core.bean.GoodsExample;
import com.redobj.repository.coreroot.bean.Msg;
import com.redobj.control.analysis.core.dao.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Goods 货物Service
 */
@Component
public class GoodsService {
    @Autowired
    private GoodsMapper mapper;

    /**
     * 根据 goodsname 获得货物数据
     * @param goodsName
     * @return
     */
    public Goods goodsByName(String goodsName){
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsNameEqualTo(goodsName);
        List<Goods> goodses = mapper.selectByExampleWithEnv(example);
        if(goodses.size()!=0){
            return goodses.get(0);
        }else {
            return null;
        }
    }

    /**
     * 增加货物
     * @param goods
     */
    public void goodsAdd(Goods goods){
        mapper.insertSelective(goods);
    }

    /**
     * 获得所有的 货物 数据
     * @return
     */
    public Msg goodsList(){
        List<Goods> goodsList = mapper.selectByExampleWithEnv(null);
        if(goodsList!=null && goodsList.size()>0){
            return Msg.success().add("goodslist",goodsList);
        }else{
            return Msg.fail();
        }
    }

}
