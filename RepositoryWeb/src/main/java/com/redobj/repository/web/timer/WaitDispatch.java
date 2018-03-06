package com.redobj.repository.web.timer;

import com.redobj.repository.web.bean.WaitSpider;
import com.redobj.repository.web.bean.WaitSpiderExample;
import com.redobj.repository.web.dao.WaitSpiderMapper;
import com.redobj.repository.web.util.GetContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebListener;
import java.util.List;

import static java.lang.Thread.sleep;

@Component
@WebListener
public class WaitDispatch {
    @Autowired
    private WaitSpiderMapper waitSpiderMapper;
    private boolean run = true;

    public void task(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (run){
                    getWaitQueue();
                    try {
                        sleep(36000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void getWaitQueue(){
        System.out.println("analysis task");
        WaitSpiderExample example = new WaitSpiderExample();
        WaitSpiderExample.Criteria criteria = example.createCriteria();
        criteria.andWaitStatusEqualTo(true);
        List<WaitSpider> queue = waitSpiderMapper.selectByExample(example);
        if(queue == null || queue.size() == 0){
            return;
        }
        for (WaitSpider wait : queue) {
            AnalysisResultSave analysisResultSave = GetContext.<AnalysisResultSave>getBean("analysisResultSave", AnalysisResultSave.class);
            if(analysisResultSave == null){
                return;
            }
            analysisResultSave.setKeyword(wait.getWaitGoods());
            new Thread(analysisResultSave).start();
            wait.setWaitStatus(false);
            waitSpiderMapper.updateByPrimaryKey(wait);
        }
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

}
