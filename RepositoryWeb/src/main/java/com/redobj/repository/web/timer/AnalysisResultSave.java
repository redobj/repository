package com.redobj.repository.web.timer;

import com.redobj.repository.core.function.AnalysisFunction;
import com.redobj.repository.web.bean.Environment;
import com.redobj.repository.web.bean.EnvironmentExample;
import com.redobj.repository.web.constant.Global;
import com.redobj.repository.web.dao.EnvironmentMapper;
import com.redobj.repository.web.dao.WaitSpiderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

public class AnalysisResultSave implements Runnable {
    @Autowired
    EnvironmentMapper environmentMapper;
    @Autowired
    WaitSpiderMapper waitSpiderMapper;
    private String keyword ;

    public AnalysisResultSave(String keyword) {
        this.keyword = keyword;
    }

    public AnalysisResultSave() {

    }


    public boolean checkResult(Global.ANALYSIS_TYPE type,String envName, Map<String,Integer> result){
        if(result.isEmpty()){
            return false;
        }
        EnvironmentExample example = new EnvironmentExample();
        EnvironmentExample.Criteria criteria = example.createCriteria();
        criteria.andEnvironmentNameEqualTo(envName);
        Environment environment = environmentMapper.selectByExample(example).get(0);
        if(type == Global.ANALYSIS_TYPE.TEMPERATURE){
            return environment.gettDatasize() <= result.get("size");
        }
        if(type == Global.ANALYSIS_TYPE.HUMIDITY){
            return environment.gethDatasize() <= result.get("size");
        }
        else{
            return false;
        }
    }

    public boolean checkNullByName(String envName){
        EnvironmentExample environmentExample = new EnvironmentExample();
        EnvironmentExample.Criteria criteria = environmentExample.createCriteria();
        criteria.andEnvironmentNameEqualTo(envName);
        return environmentMapper.countByExample(environmentExample) == 0;
    }

    public void analysisEnv(){
        AnalysisFunction function = new AnalysisFunction();
        Map<String, Map<String, Integer>> map = function.analysisRun(keyword);
        if(map.containsKey("temperature") && map.get("temperature") != null &&!map.get("temperature").isEmpty()){
            if(checkNullByName(keyword)){
                Environment environment = new Environment();
                environment.setEnvironmentName(keyword);
                environment.setTemperature(Double.valueOf(map.get("temperature").get("result")));
                environment.settDatetime(new Date());
                environment.settDatasize(map.get("temperature").get("size"));
                environmentMapper.insertSelective(environment);
            }
            else if(checkResult(Global.ANALYSIS_TYPE.TEMPERATURE,keyword,map.get("temperature"))){
                Environment environment = new Environment();
                environment.setTemperature(Double.valueOf(map.get("temperature").get("result")));
                environment.settDatetime(new Date());
                environment.settDatasize(map.get("temperature").get("size"));

                EnvironmentExample example = new EnvironmentExample();
                EnvironmentExample.Criteria criteria = example.createCriteria();
                criteria.andEnvironmentNameEqualTo(keyword);
                environmentMapper.updateByExampleSelective(environment,example);

            }
        }
        if(map.containsKey("humidity") && map.get("humidity") != null && !map.get("humidity").isEmpty()){
            if(checkNullByName(keyword)){
                Environment environment = new Environment();
                environment.setEnvironmentName(keyword);
                environment.setHumidity(Double.valueOf(map.get("humidity").get("result")));
                environment.sethDatetime(new Date());
                environment.sethDatasize(map.get("humidity").get("size"));
                environmentMapper.insertSelective(environment);
            }
            else if(checkResult(Global.ANALYSIS_TYPE.TEMPERATURE,keyword,map.get("temperature"))){
                Environment environment = new Environment();
                environment.setHumidity(Double.valueOf(map.get("humidity").get("result")));
                environment.sethDatetime(new Date());
                environment.sethDatasize(map.get("humidity").get("size"));

                EnvironmentExample example = new EnvironmentExample();
                EnvironmentExample.Criteria criteria = example.createCriteria();
                criteria.andEnvironmentNameEqualTo(keyword);
                environmentMapper.updateByExampleSelective(environment,example);

            }
        }
    }

    @Override
    public void run() {
        analysisEnv();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
