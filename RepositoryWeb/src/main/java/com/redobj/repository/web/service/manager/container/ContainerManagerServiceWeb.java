package com.redobj.repository.web.service.manager.container;

import com.redobj.repository.core.bean.Container;
import com.redobj.repository.core.bean.Environment;
import com.redobj.repository.core.bean.Msg;
import com.redobj.repository.core.function.ContainerFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContainerManagerServiceWeb {
    @Autowired
    ContainerFunction containerFunction;

    public Msg allContainer(){
        return containerFunction.getContainers();
    }

    public Msg allEnvironment(){
        return containerFunction.getEnvironments();
    }

    public Msg addContainer(Container container){
        return containerFunction.addContainer(container);
    }

    public Msg deleteContainer(int id){
        return containerFunction.deleteContainer(id);
    }

    public Msg updateContainer(Container container){
        return containerFunction.updateContainer(container);
    }

    public Msg containerById(int id){
        return containerFunction.containerById(id);
    }

}
