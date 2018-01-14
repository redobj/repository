package com.redobj.control.analysis.core.service;

import com.redobj.control.analysis.core.bean.Environment;
import com.redobj.repository.coreroot.bean.Msg;
import com.redobj.control.analysis.core.dao.EnvironmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Environment Service 层
 */
@Component
public class EnvironmentService {
    @Autowired
    private EnvironmentMapper mapper;

    /**
     * 根据 Environment 数据设定环境
     * 如果数据量大于原Environment 则更新对应的 Temperature Humidity Sun 列
     * @param environment 如果 environment 中包含 id 且对应数据不为空 则执行更新操作，否则执行插入操作
     * @return 插入新环境 返回 主键ID ，更新返回0
     */
    public int environmentSetting(Environment environment){
        if(environment.getEnvironmentId()!=null){
            Msg msg = environmentData(environment.getEnvironmentId());
            if (msg.getCode()==100){
                Environment oldEnvironment = (Environment) msg.getExtend().get("environment");
                mapper.updateByPrimaryKeySelective(environmentCheck(oldEnvironment,environment));
                return 0;
            }
        }
            mapper.insertSelective(environment);
            return environment.getEnvironmentId();
    }

    /**
     * 根据 ID 获取对应的 Environment 数据
     * @param environmentId
     * @return
     */
    public Msg environmentData(int environmentId){
        Environment environment = mapper.selectByPrimaryKey(environmentId);
        if(environment!=null){
            return Msg.success().add("environment",environment);
        }else{
            return Msg.fail().add("msg","没有对应的环境数据");
        }
    }

    /**
     * 检查 原environment 与 新environment 中的数据量并作出 替换 操作
     * @param oldEnvironment
     * @param newEnvironment
     * @return
     */
    private Environment environmentCheck(Environment oldEnvironment,Environment newEnvironment){
        if(newEnvironment.getTemperature()==null || oldEnvironment.gettDatasize()>newEnvironment.gettDatasize()){
            newEnvironment.setTemperature(oldEnvironment.getTemperature());
            newEnvironment.settDatasize(oldEnvironment.gettDatasize());
        }
        if(newEnvironment.getHumidity()==null || oldEnvironment.gethDatasize()>newEnvironment.gethDatasize()){
            newEnvironment.setHumidity(oldEnvironment.getHumidity());
            newEnvironment.sethDatasize(oldEnvironment.gethDatasize());
        }
        if(newEnvironment.getSun()==null || oldEnvironment.getsDatasize()>newEnvironment.getsDatasize()){
            newEnvironment.setSun(oldEnvironment.getSun());
            newEnvironment.setsDatasize(oldEnvironment.getsDatasize());
        }
        return newEnvironment;
    }


}
