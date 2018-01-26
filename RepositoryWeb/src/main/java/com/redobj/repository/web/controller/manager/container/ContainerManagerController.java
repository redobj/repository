package com.redobj.repository.web.controller.manager.container;

import com.redobj.repository.web.bean.Container;
import com.redobj.repository.web.bean.Msg;
import com.redobj.repository.web.service.ContainerService;
import com.redobj.repository.web.service.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContainerManagerController {
    @Autowired
    private ContainerService containerService;
    @Autowired
    private EnvironmentService environmentService;

    /**
     * 访问所有 存储区域
     * 测试url示例 ： 39.108.109.226/repository-api/manager/container/all
     * @return
     */
    @ResponseBody
    @RequestMapping("/manager/container/all")
    public Msg allContainer(){
        return containerService.allContainer();
    }

    /**
     * 访问所有 环境
     * 测试url示例 ： 39.108.109.226/repository-api/manager/container/environments
     * @return
     */
    @ResponseBody
    @RequestMapping("/manager/container/environments")
    public Msg allEnvironment(){
        return environmentService.getAllEnvironment();
    }

    /**
     * 增加一个存储区域
     * 测试url示例 ： 39.108.109.226/repository-api/manager/container/add?
     *              containerName=测试区域2&containerUsed=0&containerCapacity=100&containerEnvironment=1
     * @param container
     * @return
     */
    @ResponseBody
    @RequestMapping("/manager/container/add")
    public Msg addContainer(Container container){
        return containerService.addContainer(container);
    }

    /**
     * 删除一个 存储区域
     * 测试URL示例 ： 39.108.109.226/repository-api/manager/container/delete/1
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/manager/container/delete/{id}")
    public Msg deleteContainer(@PathVariable("id")int id){
        return containerService.deleteContainer(id);
    }

    /**
     * 修改一个 存储区域
     * 测试URL示例： 39.108.109.226/repository-api/manager/container/update?
     *             containerName=测试区域2&containerUsed=0&containerCapacity=100&containerEnvironment=1
     * @param container
     * @return
     */
    @ResponseBody
    @RequestMapping("/manager/container/update")
    public Msg updateContainer(Container container){
        return containerService.updateContainer(container);
    }

    /**
     * 根据ID获取一个 存储区域 信息
     * 测试URL示例 ：39.108.109.226/repository-api/manager/container/get/1
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/manager/container/get/{id}")
    public Msg containerById(@PathVariable("id") int id){
        return containerService.containerById(id);
    }
}
