package com.redobj;

import com.redobj.repository.core.bean.Container;
import com.redobj.repository.core.config.SpringContextConfig;
import com.redobj.repository.core.function.ContainerFunction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfig.class)
public class FunctionTest {
    @Autowired
    ContainerFunction function;

    @Test
    public void test(){
//        List<Container> containers = function.getContainers();
//        for (Container c:containers
//             ) {
//            System.out.println(c.getEnvironment());
//        }
    }
}
