package com.redobj.repository.web.service;

import com.redobj.repository.web.bean.Environment;
import com.redobj.repository.web.bean.EnvironmentExample;
import com.redobj.repository.web.bean.Msg;
import com.redobj.repository.web.dao.EnvironmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnvironmentService {
    @Autowired
    EnvironmentMapper environmentMapper;

    /**
     * 通过ID检查 环境是否已存在
     * @param envId
     * @return true 表示 已存在
     */
    public boolean checkEnv(int envId){
        return environmentMapper.selectByPrimaryKey(envId) != null;
    }

    /**
     * 通过名字检查环境是否存在
     * @param envName
     * @return true 表示 已存在
     */
    public boolean checkEnvByName(String envName){
        EnvironmentExample environmentExample = new EnvironmentExample();
        EnvironmentExample.Criteria criteria = environmentExample.createCriteria();
        criteria.andEnvironmentNameEqualTo(envName);
        return environmentMapper.countByExample(environmentExample) != 0;
    }

    /**
     * 取得所有环境
     * @return
     */
    public Msg getAllEnvironment(){
        List<Environment> environments = environmentMapper.selectByExample(null);
        return environments == null?Msg.fail():Msg.success().add("environments",environments);
    }
}
