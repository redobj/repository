package com.redobj.repository.coreroot.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回信息类
 */
public class Msg {
    /**
     * 状态码信息
     * 成功 100
     * 失败 200
     * 部分成功 300
     */
    private int code;
    private String msg;
    private Map<String,Object> extend;

    public static Msg success(){
        return new Msg(100,"success");
    }

    public static Msg fail(){
        return new Msg(200,"fail");
    }

    public static Msg notAll(){
        return new Msg(300,"have some error");
    }

    public Msg(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.extend = new HashMap<String, Object>();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

    public  Msg add(String key, Object value){
        extend.put(key,value);
        return this;

    }
}
