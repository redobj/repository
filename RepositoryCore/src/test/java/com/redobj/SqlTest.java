package com.redobj;


import com.redobj.repository.core.bean.Container;
import com.redobj.repository.core.bean.Environment;
import com.redobj.repository.core.config.SpringContextConfig;
import com.redobj.repository.core.dao.GoodsMapper;
import com.redobj.repository.core.service.ContainerService;
import com.redobj.repository.core.service.EnvironmentService;
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
    ContainerService containerService;
    @Autowired
    EnvironmentService environmentService;

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

}
