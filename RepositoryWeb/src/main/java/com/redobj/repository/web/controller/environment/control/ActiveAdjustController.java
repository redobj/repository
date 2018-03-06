package com.redobj.repository.web.controller.environment.control;

import com.redobj.repository.web.bean.Container;
import com.redobj.repository.web.bean.Environment;
import com.redobj.repository.web.bean.Msg;
import com.redobj.repository.web.service.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ActiveAdjustController {
    @Autowired
    private EnvironmentService service;



    /**
     * 访问所有 环境
     * 测试url示例 ： 39.108.109.226/repository-api/environment/control/all
     * @return
     */
    @ResponseBody
    @RequestMapping("/environment/control/all")
    public Msg allEnvironment(){
        return service.getAllEnvironment();
    }

    /**
     * 增加一个环境信息
     * 测试url示例 ： 39.108.109.226/repository-api/environment/control/add?
     *              environmentName=环境名称&temperature=10&humidity=80&sun=200
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/environment/control/add")
    public Msg addEnvironment(Environment environment){
        return service.addEnvironment(environment);
    }

    /**
     * 删除一个环境信息
     * 测试URL示例 ： 39.108.109.226/repository-api/environment/control/delete/1
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/environment/control/delete/{id}")
    public Msg deleteEnvironment(@PathVariable("id")int id){
        return service.delEnvironment(id);
    }

    /**
     * 修改一个环境信息
     * 测试URL示例： 39.108.109.226/repository-api/environment/control/update?environmentId=8&
     *              environmentName=环境名称&temperature=10&humidity=80&sun=200
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/environment/control/update")
    public Msg updateEnvironment(Environment environment){
        return service.updateEnvironment(environment);
    }

    /**
     * 根据ID获取一个环境信息
     * 测试URL示例 ：39.108.109.226/repository-api/environment/control/get/1
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/environment/control/get/{id}")
    public Msg containerById(@PathVariable("id") int id){
        return service.getEnvironment(id);
    }
}
