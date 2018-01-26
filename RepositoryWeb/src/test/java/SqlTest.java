

import com.redobj.repository.web.bean.Container;
import com.redobj.repository.web.bean.Environment;
import com.redobj.repository.web.bean.Goods;
import com.redobj.repository.web.bean.SaveIndex;
import com.redobj.repository.web.config.SpringContextConfig;
import com.redobj.repository.web.dao.GoodsMapper;
import com.redobj.repository.web.service.ContainerService;
import com.redobj.repository.web.service.EnvironmentService;
//import com.redobj.repository.web.service.GoodsService;
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
//    @Autowired
//    GoodsService goodsService;



}
