package com.redobj.repository.web.service;

import com.redobj.repository.web.bean.Environment;
import com.redobj.repository.web.bean.EnvironmentExample;
import com.redobj.repository.web.bean.Msg;
import com.redobj.repository.web.dao.EnvironmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
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
        if(environments != null && environments.size() > 0){
            return Msg.success().add("environments",environments);
        }else{
            return Msg.fail().add("error","环境信息为空");
        }
    }

    /**
     * 手动增加一个环境信息
     * @param environment
     * @return
     */
    public Msg addEnvironment(Environment environment){
        if(!checkEnvByName(environment.getEnvironmentName())){
            environment.settDatetime(new Date());
            environment.settDatasize(Integer.MAX_VALUE);
            environment.setsDatetime(new Date());
            environment.setsDatasize(Integer.MAX_VALUE);
            environment.sethDatetime(new Date());
            environment.sethDatasize(Integer.MAX_VALUE);
            environmentMapper.insertSelective(environment);
            return Msg.success();
        }else{
            return Msg.fail().add("error","环境已存在。");
        }
    }

    /**
     * 手动删除一个环境信息
     * @param id
     * @return
     */
    public Msg delEnvironment(int id){
        environmentMapper.deleteByPrimaryKey(id);
        return Msg.success();
    }

    /**
     * 手动修改一个环境信息
     * @param environment
     * @return
     */
    public Msg updateEnvironment(Environment environment){
        if(checkEnv(environment.getEnvironmentId())){
            String oldName = environmentMapper.selectByPrimaryKey(environment.getEnvironmentId()).getEnvironmentName();
            if(!oldName.equals(environment.getEnvironmentName())){
                if(checkEnvByName(environment.getEnvironmentName())){
                    return Msg.fail().add("error","环境名不能重复");
                }
            }
            environment.settDatetime(new Date());
            environment.settDatasize(Integer.MAX_VALUE);
            environment.setsDatetime(new Date());
            environment.setsDatasize(Integer.MAX_VALUE);
            environment.sethDatetime(new Date());
            environment.sethDatasize(Integer.MAX_VALUE);
            environmentMapper.updateByPrimaryKeySelective(environment);
            return Msg.success();
        }else{
            return Msg.fail().add("error","环境不存在。");
        }
    }

    /**
     * 按Id查询一个环境
     * @param id
     * @return
     */
    public Msg getEnvironment(int id){
        Environment environment = environmentMapper.selectByPrimaryKey(id);
        if(environment != null){
            return Msg.success().add("environment",environment);
        }else{
            return Msg.fail();
        }
    }


}
