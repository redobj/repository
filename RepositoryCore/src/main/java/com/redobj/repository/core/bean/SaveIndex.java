package com.redobj.repository.core.bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
