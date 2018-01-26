package com.redobj;

import com.redobj.repository.web.bean.Container;
import com.redobj.repository.web.config.SpringContextConfig;
import com.redobj.repository.web.service.ContainerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfig.class)
public class BoringTest {
    @Autowired
    ContainerService function;

    @Test
    public void test1(){
        Container container = new Container();
        container.setContainerName("二号茶仓");
        container.setContainerEnvironment(0);
        container.setContainerCapacity(100);
        function.addContainer(container);
    }

}
