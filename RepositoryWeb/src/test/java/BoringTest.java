
import com.redobj.repository.web.bean.Container;
import com.redobj.repository.web.bean.Msg;
import com.redobj.repository.web.bean.WaitSpider;
import com.redobj.repository.web.bean.WaitSpiderExample;
import com.redobj.repository.web.config.RepositoryInitializer;
import com.redobj.repository.web.config.SpringContextConfig;
import com.redobj.repository.web.dao.WaitSpiderMapper;
import com.redobj.repository.web.service.ContainerService;
import com.redobj.repository.web.timer.AnalysisResultSave;
import com.redobj.repository.web.util.GetContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RepositoryInitializer.class, SpringContextConfig.class})
public class BoringTest {
    //    @Autowired
//    ContainerService containerService;
    @Autowired
    AnalysisResultSave analysisResultSave;
    @Autowired
    private WaitSpiderMapper waitSpiderMapper;
//    @Test
//    public void test1(){
//        Msg msg = containerService.containerById(11);
//        System.out.println(msg.getCode());
//    }

    @Test
    public void test2() {
        analysisResultSave.setKeyword("西湖龙井");
//        new Thread(analysisResultSave).start();
//        AnalysisResultSave analysisResultSave = new AnalysisResultSave("西湖龙井");
        new Thread(analysisResultSave).run();
    }

    @Test
    public void test3() {
        System.out.println("analysis task");
        WaitSpiderExample example = new WaitSpiderExample();
        WaitSpiderExample.Criteria criteria = example.createCriteria();
        criteria.andWaitStatusEqualTo(true);
        List<WaitSpider> queue = waitSpiderMapper.selectByExample(example);
        if(queue == null || queue.size() == 0){
            return;
        }
        for (WaitSpider wait : queue) {
            System.out.println(wait.getWaitGoods());
        }
    }


}
