package com.redobj.repository.core.service;

import com.redobj.repository.core.bean.*;
import com.redobj.repository.core.dao.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    WaitService waitService;
    @Autowired
    ContainerService containerService;



    public List<Goods> getAllGoods(){
        return goodsMapper.selectByExampleWithEnv(null);
    }


    public Msg enter(Goods goods){
        if(checkGoodsIndex(goods.getSaveIndex())){
            return Msg.fail(Msg.MSG_OUTOFSIZE);
        }else{
            goodsEnter(goods.getSaveIndex());
        }
        Goods oldGoods = checkGoods(goods.getGoodsName());
        if(oldGoods == null){
            goods.setGoodsDate(new Date());
            goodsMapper.insertSelective(goods);
            WaitSpider spider = new WaitSpider();
            spider.setWaitGoods(goods.getGoodsName());
            spider.setWaitStatus(true);
            waitService.put(spider);
            return Msg.success().setCode(Msg.MSG_CREATE);
        }else{
            oldGoods.setGoodsStock(oldGoods.getGoodsStock()+goods.getGoodsStock());
            SaveIndex oldIndex = oldGoods.getSaveIndex();
            SaveIndex newIndex = goods.getSaveIndex();
            for(Integer i:newIndex.keySet()){
                oldIndex.put(i,newIndex.get(i));
            }
            oldGoods.setSaveIndex(oldIndex);
            oldGoods.setGoodsDate(new Date());
            goodsMapper.updateByPrimaryKeySelective(oldGoods);
            return Msg.success().setCode(Msg.MSG_UPDATE);
        }

    }

    private void goodsEnter(SaveIndex saveIndex) {
        for(Integer i:saveIndex.keySet()){
            containerService.enterGoods(i,saveIndex.get(i));
        }
    }

    private boolean checkGoodsIndex(SaveIndex saveIndex) {
        for(Integer i:saveIndex.keySet()){
            if(containerService.checkCapacity(i,saveIndex.get(i))){
                return false;
            }
        }
            return true;
    }

    private Goods checkGoods(String goodsName) {
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsNameEqualTo(goodsName);
        List<Goods> goods = goodsMapper.selectByExampleWithEnv(example);
        if(goods!=null && goods.size() > 0){
            return goods.get(0);
        }else{
            return null;
        }
    }
}
