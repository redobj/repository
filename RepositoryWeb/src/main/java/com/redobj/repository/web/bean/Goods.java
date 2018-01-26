package com.redobj.repository.web.bean;

import java.util.Date;

public class Goods {
    private Integer goodsId;

    private String goodsName;

    private Integer goodsStock;

    private String goodsCon;

    private Integer goodsEnv;

    private Date goodsDate;

    private String goodsNote;

    private Environment environment;

    private SaveIndex saveIndex;

    public SaveIndex getSaveIndex() {
        return saveIndex;
    }

    public void setSaveIndex(SaveIndex saveIndex) {
        StringBuffer con = new StringBuffer();
        for(Integer key:saveIndex.keySet()){
            con.append(key+":"+saveIndex.get(key)+",");
        }
        this.goodsCon = con.toString();
        this.saveIndex = saveIndex;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Integer getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }

    public String getGoodsCon() {
        return this.goodsCon;
    }

    public void setGoodsCon(String goodsCon) {
        if(goodsCon == null){
            this.goodsCon = null;
        }else{
            this.goodsCon = goodsCon;
            this.saveIndex = new SaveIndex();
            String[] split = goodsCon.split(",");
            String[] temp;
            for(String s:split){
                temp =  s.split(":");
                if(temp[0].length()>0 && temp[1].length()>0){
                    saveIndex.put(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
                }
            }
        }
    }

    public Integer getGoodsEnv() {
        return goodsEnv;
    }

    public void setGoodsEnv(Integer goodsEnv) {
        this.goodsEnv = goodsEnv;
    }

    public Date getGoodsDate() {
        return goodsDate;
    }

    public void setGoodsDate(Date goodsDate) {
        this.goodsDate = goodsDate;
    }

    public String getGoodsNote() {
        return goodsNote;
    }

    public void setGoodsNote(String goodsNote) {
        this.goodsNote = goodsNote == null ? null : goodsNote.trim();
    }
}