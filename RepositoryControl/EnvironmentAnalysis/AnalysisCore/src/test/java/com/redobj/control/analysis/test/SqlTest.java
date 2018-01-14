package com.redobj.control.analysis.test;

import com.redobj.control.analysis.core.bean.Environment;
import com.redobj.control.analysis.core.bean.Goods;
import com.redobj.control.analysis.core.config.SpringContextConfig;
import com.redobj.control.analysis.core.dao.EnvironmentMapper;
import com.redobj.control.analysis.core.dao.GoodsMapper;
import com.redobj.control.analysis.core.service.EnvironmentService;
import com.redobj.control.analysis.core.service.GoodsService;
import com.redobj.repository.coreroot.bean.Msg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfig.class)
public class SqlTest {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    EnvironmentService environmentService;
    @Autowired
    GoodsService goodsService;

    @Test
    public void insertTest(){
        Goods goods = new Goods();
        goods.setGoodsName("普洱茶");
        goodsMapper.insertSelective(goods);
    }

    @Test
    public void environmentTest(){
        Environment environment = new Environment();
        environment.setTemperature(23.0);
        environment.settDatetime(new Date());
        environment.settDatasize(180);
        environment.setHumidity(75.0);
        environment.sethDatetime(new Date());
        environment.sethDatasize(100);

        environmentService.environmentSetting(environment);
        System.out.println(environment.getEnvironmentId());

    }

    @Test
    public void goodsGet(){
        Msg msg = goodsService.goodsList();
        List<Goods> goods = (List<Goods>) msg.getExtend().get("goodslist");
        System.out.println(goods.get(0).getGoodsEnvironment().getTemperature());
    }
}
