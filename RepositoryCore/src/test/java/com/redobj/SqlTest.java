package com.redobj;


import com.redobj.repository.core.bean.Container;
import com.redobj.repository.core.bean.Environment;
import com.redobj.repository.core.bean.Goods;
import com.redobj.repository.core.bean.SaveIndex;
import com.redobj.repository.core.config.SpringContextConfig;
import com.redobj.repository.core.dao.GoodsMapper;
import com.redobj.repository.core.service.ContainerService;
import com.redobj.repository.core.service.EnvironmentService;
import com.redobj.repository.core.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfig.class)
public class SqlTest {
    @Autowired
    ContainerService containerService;
    @Autowired
    EnvironmentService environmentService;
    @Autowired
    GoodsService goodsService;

    @Test
    public void containerTest(){
        List<Container> containers = containerService.getAllContainer();
        for (Container c:containers
             ) {
            System.out.println(c.getContainerName()+" "+c.getEnvironment().getEnvironmentName()+" "+c.getEnvironment().getTemperature());
        }
        Container c = containerService.getContainerById(1);
        System.out.println(c.getContainerName()+" "+c.getEnvironment().getEnvironmentName()+" "+c.getEnvironment().getTemperature());
    }

    @Test
    public void environmentTest(){
        List<Environment> environments = environmentService.getAllEnvironment();
        for (Environment e:environments
             ) {
            System.out.println(e);
        }
    }

    @Test
    public void goodsTest(){
        List<Goods> goods = goodsService.getAllGoods();
        for (Goods g:goods
                ) {
            System.out.println(g.getGoodsName());
        }

        Map<Integer, Integer> saveMap = goods.get(0).getSaveIndex();
        for (Integer i: saveMap.keySet()
             ) {
            System.out.println(i+":"+saveMap.get(i));
        }
    }

    @Test
    public void goodsTest2(){
        Goods goods = new Goods();
        goods.setGoodsName("大红袍");
        goods.setGoodsStock(100);
        goods.setGoodsDate(new Date());
        SaveIndex saveIndex = new SaveIndex();
        saveIndex.put(3,100);
        goods.setSaveIndex(saveIndex);
        System.out.println(goodsService.enter(goods).getCode());
    }

}
