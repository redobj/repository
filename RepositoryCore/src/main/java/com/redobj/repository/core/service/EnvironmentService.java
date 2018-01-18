package com.redobj.repository.core.service;

import com.redobj.repository.core.bean.Environment;
import com.redobj.repository.core.dao.EnvironmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnvironmentService {
    @Autowired
    EnvironmentMapper environmentMapper;

    public boolean checkEnv(int envId){
        return environmentMapper.selectByPrimaryKey(envId) != null;
    }

    public List<Environment> getAllEnvironment(){
        return environmentMapper.selectByExample(null);
    }
}
