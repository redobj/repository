package com.redobj.repository.core.service;

import com.redobj.repository.core.bean.Container;
import com.redobj.repository.core.dao.ContainerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContainerService {
    @Autowired
    ContainerMapper containerMapper;
    @Autowired
    EnvironmentService environmentService;

    public boolean addContainer(Container container){
        if(environmentService.checkEnv(container.getContainerEnvironment())){
            return containerMapper.insertSelective(container)>0;
        }else{
            container.setContainerEnvironment(1);
            return containerMapper.insertSelective(container)>0;
        }
    }

    public boolean deleteContainer(int containerId){
        return containerMapper.deleteByPrimaryKey(containerId)>0;
    }

    public boolean updateContainer(Container container){
        return containerMapper.updateByPrimaryKeySelective(container)>0;
    }

    public List<Container> getAllContainer(){
        return containerMapper.selectByExampleWithEnv(null);
    }

    public Container getContainerById(int id){
        return containerMapper.selectByPrimaryKeyWithEnv(id);
    }



}
