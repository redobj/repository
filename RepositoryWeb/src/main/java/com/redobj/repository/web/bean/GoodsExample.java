package com.redobj.repository.web.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsStockIsNull() {
            addCriterion("goods_stock is null");
            return (Criteria) this;
        }

        public Criteria andGoodsStockIsNotNull() {
            addCriterion("goods_stock is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsStockEqualTo(Integer value) {
            addCriterion("goods_stock =", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockNotEqualTo(Integer value) {
            addCriterion("goods_stock <>", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockGreaterThan(Integer value) {
            addCriterion("goods_stock >", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_stock >=", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockLessThan(Integer value) {
            addCriterion("goods_stock <", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockLessThanOrEqualTo(Integer value) {
            addCriterion("goods_stock <=", value, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockIn(List<Integer> values) {
            addCriterion("goods_stock in", values, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockNotIn(List<Integer> values) {
            addCriterion("goods_stock not in", values, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockBetween(Integer value1, Integer value2) {
            addCriterion("goods_stock between", value1, value2, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsStockNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_stock not between", value1, value2, "goodsStock");
            return (Criteria) this;
        }

        public Criteria andGoodsConIsNull() {
            addCriterion("goods_con is null");
            return (Criteria) this;
        }

        public Criteria andGoodsConIsNotNull() {
            addCriterion("goods_con is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsConEqualTo(String value) {
            addCriterion("goods_con =", value, "goodsCon");
            return (Criteria) this;
        }

        public Criteria andGoodsConNotEqualTo(String value) {
            addCriterion("goods_con <>", value, "goodsCon");
            return (Criteria) this;
        }

        public Criteria andGoodsConGreaterThan(String value) {
            addCriterion("goods_con >", value, "goodsCon");
            return (Criteria) this;
        }

        public Criteria andGoodsConGreaterThanOrEqualTo(String value) {
            addCriterion("goods_con >=", value, "goodsCon");
            return (Criteria) this;
        }

        public Criteria andGoodsConLessThan(String value) {
            addCriterion("goods_con <", value, "goodsCon");
            return (Criteria) this;
        }

        public Criteria andGoodsConLessThanOrEqualTo(String value) {
            addCriterion("goods_con <=", value, "goodsCon");
            return (Criteria) this;
        }

        public Criteria andGoodsConLike(String value) {
            addCriterion("goods_con like", value, "goodsCon");
            return (Criteria) this;
        }

        public Criteria andGoodsConNotLike(String value) {
            addCriterion("goods_con not like", value, "goodsCon");
            return (Criteria) this;
        }

        public Criteria andGoodsConIn(List<String> values) {
            addCriterion("goods_con in", values, "goodsCon");
            return (Criteria) this;
        }

        public Criteria andGoodsConNotIn(List<String> values) {
            addCriterion("goods_con not in", values, "goodsCon");
            return (Criteria) this;
        }

        public Criteria andGoodsConBetween(String value1, String value2) {
            addCriterion("goods_con between", value1, value2, "goodsCon");
            return (Criteria) this;
        }

        public Criteria andGoodsConNotBetween(String value1, String value2) {
            addCriterion("goods_con not between", value1, value2, "goodsCon");
            return (Criteria) this;
        }

        public Criteria andGoodsEnvIsNull() {
            addCriterion("goods_env is null");
            return (Criteria) this;
        }

        public Criteria andGoodsEnvIsNotNull() {
            addCriterion("goods_env is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsEnvEqualTo(Integer value) {
            addCriterion("goods_env =", value, "goodsEnv");
            return (Criteria) this;
        }

        public Criteria andGoodsEnvNotEqualTo(Integer value) {
            addCriterion("goods_env <>", value, "goodsEnv");
            return (Criteria) this;
        }

        public Criteria andGoodsEnvGreaterThan(Integer value) {
            addCriterion("goods_env >", value, "goodsEnv");
            return (Criteria) this;
        }

        public Criteria andGoodsEnvGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_env >=", value, "goodsEnv");
            return (Criteria) this;
        }

        public Criteria andGoodsEnvLessThan(Integer value) {
            addCriterion("goods_env <", value, "goodsEnv");
            return (Criteria) this;
        }

        public Criteria andGoodsEnvLessThanOrEqualTo(Integer value) {
            addCriterion("goods_env <=", value, "goodsEnv");
            return (Criteria) this;
        }

        public Criteria andGoodsEnvIn(List<Integer> values) {
            addCriterion("goods_env in", values, "goodsEnv");
            return (Criteria) this;
        }

        public Criteria andGoodsEnvNotIn(List<Integer> values) {
            addCriterion("goods_env not in", values, "goodsEnv");
            return (Criteria) this;
        }

        public Criteria andGoodsEnvBetween(Integer value1, Integer value2) {
            addCriterion("goods_env between", value1, value2, "goodsEnv");
            return (Criteria) this;
        }

        public Criteria andGoodsEnvNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_env not between", value1, value2, "goodsEnv");
            return (Criteria) this;
        }

        public Criteria andGoodsDateIsNull() {
            addCriterion("goods_date is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDateIsNotNull() {
            addCriterion("goods_date is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDateEqualTo(Date value) {
            addCriterion("goods_date =", value, "goodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsDateNotEqualTo(Date value) {
            addCriterion("goods_date <>", value, "goodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsDateGreaterThan(Date value) {
            addCriterion("goods_date >", value, "goodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsDateGreaterThanOrEqualTo(Date value) {
            addCriterion("goods_date >=", value, "goodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsDateLessThan(Date value) {
            addCriterion("goods_date <", value, "goodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsDateLessThanOrEqualTo(Date value) {
            addCriterion("goods_date <=", value, "goodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsDateIn(List<Date> values) {
            addCriterion("goods_date in", values, "goodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsDateNotIn(List<Date> values) {
            addCriterion("goods_date not in", values, "goodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsDateBetween(Date value1, Date value2) {
            addCriterion("goods_date between", value1, value2, "goodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsDateNotBetween(Date value1, Date value2) {
            addCriterion("goods_date not between", value1, value2, "goodsDate");
            return (Criteria) this;
        }

        public Criteria andGoodsNoteIsNull() {
            addCriterion("goods_note is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNoteIsNotNull() {
            addCriterion("goods_note is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNoteEqualTo(String value) {
            addCriterion("goods_note =", value, "goodsNote");
            return (Criteria) this;
        }

        public Criteria andGoodsNoteNotEqualTo(String value) {
            addCriterion("goods_note <>", value, "goodsNote");
            return (Criteria) this;
        }

        public Criteria andGoodsNoteGreaterThan(String value) {
            addCriterion("goods_note >", value, "goodsNote");
            return (Criteria) this;
        }

        public Criteria andGoodsNoteGreaterThanOrEqualTo(String value) {
            addCriterion("goods_note >=", value, "goodsNote");
            return (Criteria) this;
        }

        public Criteria andGoodsNoteLessThan(String value) {
            addCriterion("goods_note <", value, "goodsNote");
            return (Criteria) this;
        }

        public Criteria andGoodsNoteLessThanOrEqualTo(String value) {
            addCriterion("goods_note <=", value, "goodsNote");
            return (Criteria) this;
        }

        public Criteria andGoodsNoteLike(String value) {
            addCriterion("goods_note like", value, "goodsNote");
            return (Criteria) this;
        }

        public Criteria andGoodsNoteNotLike(String value) {
            addCriterion("goods_note not like", value, "goodsNote");
            return (Criteria) this;
        }

        public Criteria andGoodsNoteIn(List<String> values) {
            addCriterion("goods_note in", values, "goodsNote");
            return (Criteria) this;
        }

        public Criteria andGoodsNoteNotIn(List<String> values) {
            addCriterion("goods_note not in", values, "goodsNote");
            return (Criteria) this;
        }

        public Criteria andGoodsNoteBetween(String value1, String value2) {
            addCriterion("goods_note between", value1, value2, "goodsNote");
            return (Criteria) this;
        }

        public Criteria andGoodsNoteNotBetween(String value1, String value2) {
            addCriterion("goods_note not between", value1, value2, "goodsNote");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}