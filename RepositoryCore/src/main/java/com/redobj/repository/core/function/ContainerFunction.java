package com.redobj.repository.core.function;

import com.redobj.repository.core.bean.Container;
import com.redobj.repository.core.bean.Environment;
import com.redobj.repository.core.bean.Msg;
import com.redobj.repository.core.service.ContainerService;
import com.redobj.repository.core.service.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContainerFunction {
    @Autowired
    ContainerService containerService;
    @Autowired
    EnvironmentService environmentService;

    public Msg getEnvironments(){
        List<Environment> environments = environmentService.getAllEnvironment();
        if(environments != null){
            return Msg.success().add("environments",environments);
        }else{
            return Msg.fail(Msg.MSG_NOTFOUND);
        }
    }

    public Msg getContainers(){
        List<Container> containers = containerService.getAllContainer();
        if(containers != null){
            return Msg.success().add("containers",containers);
        }else{
            return Msg.fail(Msg.MSG_NOTFOUND);
        }
    }

    public Msg containerById(int id){
        Container container = containerService.getContainerById(id);
        if(container == null){
            return Msg.fail(Msg.MSG_NOTFOUND);
        }else{
            return Msg.success().add("container",container);
        }
    }

    public Msg addContainer(Container container){
        if(containerService.addContainer(container)){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    public Msg deleteContainer(int id){
        if(containerService.deleteContainer(id)){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    public Msg updateContainer(Container container){
        if(containerService.updateContainer(container)){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }


}
