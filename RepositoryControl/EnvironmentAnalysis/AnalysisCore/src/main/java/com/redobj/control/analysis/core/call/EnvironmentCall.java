package com.redobj.control.analysis.core.call;

import com.redobj.control.analysis.core.bean.Goods;
import com.redobj.control.analysis.core.bean.WaitSpider;
import com.redobj.repository.coreroot.bean.Msg;
import com.redobj.control.analysis.core.service.EnvironmentService;
import com.redobj.control.analysis.core.service.GoodsService;
import com.redobj.control.analysis.core.service.WaitService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 环境调用接口
 */
public class EnvironmentCall {
    @Autowired
    EnvironmentService environmentService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    WaitService waitService;

    public Msg goodsAdd(Goods goods){
        return null;
    }

    /**
     * 商品操作接口
     * 如果没有相同名字的商品 则执行加入操作
     * 否则返回商品
     * @param goods
     * @return
     */
    public Msg goodsOpera(Goods goods){
        Goods tempGoods = goodsService.goodsByName(goods.getGoodsName());
        if(goods == null){
            goodsService.goodsAdd(goods);
            return Msg.fail().add("msg","没有找到对应的货物数据，已新增商品").add("goods",goods);
        }
        if(goods.getGoodsEnv() == 0){
            WaitSpider waitSpider = new WaitSpider();
            if(!waitService.isWait(tempGoods.getGoodsName())){
                waitSpider.setWaitGoods(tempGoods.getGoodsName());
                waitSpider.setWaitStatus(true);
                waitService.addWait(waitSpider);
            }
            return Msg.notAll().add("msg","该商品还没有对应的环境数据，已加入等待队列等待数据源更新").add("goods",tempGoods);
        }
            return Msg.success().add("goods",tempGoods);
    }



}
