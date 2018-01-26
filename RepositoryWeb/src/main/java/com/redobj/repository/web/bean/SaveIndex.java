package com.redobj.repository.web.bean;

import java.util.HashMap;

public class SaveIndex extends HashMap<Integer,Integer> {

    public SaveIndex() {
        super();
    }

    @Override
    public Integer put(Integer key, Integer value) {
        if(this.containsKey(key)){
            return this.replace(key,this.get(key)+value);
        }else{
            return super.put(key, value);
        }
    }


}
