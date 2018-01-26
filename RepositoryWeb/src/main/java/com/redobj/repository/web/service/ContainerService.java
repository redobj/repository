package com.redobj.repository.web.service;

import com.alibaba.fastjson.JSON;
import com.redobj.repository.web.bean.Container;
import com.redobj.repository.web.bean.Msg;
import com.redobj.repository.web.bean.Td;
import com.redobj.repository.web.dao.ContainerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContainerService {
    @Autowired
    ContainerMapper containerMapper;
    @Autowired
    EnvironmentService environmentService;

    /**
     * 取得所有货柜信息
     * @return
     */
    public Msg allContainer(){
        List<Container> containers = containerMapper.selectByExampleWithEnv(null);
        if(containers != null){
            return Msg.success().add("containers",containers);
        }else{
            return Msg.fail();
        }
    }

    /**
     * 增加货柜信息
     * @param container
     * @return
     */
    public Msg addContainer(Container container){
        if(null == container.getContainerCapacity() && 0 >= container.getContainerCapacity()){
            return Msg.fail();
        }

        ArrayList<Td> tds = new ArrayList<>();
        Td td ;
        for(int i = 0;i<container.getContainerCapacity();i++){
            td = new Td();
            td.setId(i+1);
            td.setStatus(false);
            tds.add(td);
        }
        container.setTds(JSON.toJSONString(tds));

        if(!environmentService.checkEnv(container.getContainerEnvironment())){
            container.setContainerEnvironment(1);
        }

        if(containerMapper.insertSelective(container) > 0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    /**
     * 删除货柜信息
     * @param id
     * @return
     */
    public Msg deleteContainer(int id){
        if(containerMapper.deleteByPrimaryKey(id)>0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    /**
     * 修改货柜信息
     * @param container
     * @return
     */
    public Msg updateContainer(Container container){
        if(containerMapper.updateByPrimaryKeySelective(container)>0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    /**
     * 从ID中查找一个货柜信息
     * @param id
     * @return
     */
    public Msg containerById(int id){
        Container container = containerMapper.selectByPrimaryKeyWithEnv(id);
        if(container != null){
            return Msg.success().add("container",container);
        }else {
            return Msg.fail();
        }
    }

}
