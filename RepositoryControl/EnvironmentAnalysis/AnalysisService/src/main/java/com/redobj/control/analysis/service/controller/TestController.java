package com.redobj.control.analysis.service.controller;

import com.redobj.control.analysis.core.bean.Goods;
import com.redobj.control.analysis.core.call.EnvironmentCall;
import com.redobj.repository.coreroot.bean.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    EnvironmentCall environmentCall;

    @ResponseBody
    @RequestMapping("/test")
    public Msg hello(@RequestParam String goodsname){
        Goods goods = new Goods();
        goods.setGoodsName("普洱茶");

        return environmentCall.goodsOpera(goods);
//        return Msg.success();
//        return "hello";
    }
}
