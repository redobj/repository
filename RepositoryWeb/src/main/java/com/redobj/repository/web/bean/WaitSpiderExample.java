package com.redobj.repository.web.bean;

import java.util.ArrayList;
import java.util.List;

public class WaitSpiderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WaitSpiderExample() {
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

        public Criteria andWaitIdIsNull() {
            addCriterion("wait_id is null");
            return (Criteria) this;
        }

        public Criteria andWaitIdIsNotNull() {
            addCriterion("wait_id is not null");
            return (Criteria) this;
        }

        public Criteria andWaitIdEqualTo(Integer value) {
            addCriterion("wait_id =", value, "waitId");
            return (Criteria) this;
        }

        public Criteria andWaitIdNotEqualTo(Integer value) {
            addCriterion("wait_id <>", value, "waitId");
            return (Criteria) this;
        }

        public Criteria andWaitIdGreaterThan(Integer value) {
            addCriterion("wait_id >", value, "waitId");
            return (Criteria) this;
        }

        public Criteria andWaitIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("wait_id >=", value, "waitId");
            return (Criteria) this;
        }

        public Criteria andWaitIdLessThan(Integer value) {
            addCriterion("wait_id <", value, "waitId");
            return (Criteria) this;
        }

        public Criteria andWaitIdLessThanOrEqualTo(Integer value) {
            addCriterion("wait_id <=", value, "waitId");
            return (Criteria) this;
        }

        public Criteria andWaitIdIn(List<Integer> values) {
            addCriterion("wait_id in", values, "waitId");
            return (Criteria) this;
        }

        public Criteria andWaitIdNotIn(List<Integer> values) {
            addCriterion("wait_id not in", values, "waitId");
            return (Criteria) this;
        }

        public Criteria andWaitIdBetween(Integer value1, Integer value2) {
            addCriterion("wait_id between", value1, value2, "waitId");
            return (Criteria) this;
        }

        public Criteria andWaitIdNotBetween(Integer value1, Integer value2) {
            addCriterion("wait_id not between", value1, value2, "waitId");
            return (Criteria) this;
        }

        public Criteria andWaitGoodsIsNull() {
            addCriterion("wait_goods is null");
            return (Criteria) this;
        }

        public Criteria andWaitGoodsIsNotNull() {
            addCriterion("wait_goods is not null");
            return (Criteria) this;
        }

        public Criteria andWaitGoodsEqualTo(String value) {
            addCriterion("wait_goods =", value, "waitGoods");
            return (Criteria) this;
        }

        public Criteria andWaitGoodsNotEqualTo(String value) {
            addCriterion("wait_goods <>", value, "waitGoods");
            return (Criteria) this;
        }

        public Criteria andWaitGoodsGreaterThan(String value) {
            addCriterion("wait_goods >", value, "waitGoods");
            return (Criteria) this;
        }

        public Criteria andWaitGoodsGreaterThanOrEqualTo(String value) {
            addCriterion("wait_goods >=", value, "waitGoods");
            return (Criteria) this;
        }

        public Criteria andWaitGoodsLessThan(String value) {
            addCriterion("wait_goods <", value, "waitGoods");
            return (Criteria) this;
        }

        public Criteria andWaitGoodsLessThanOrEqualTo(String value) {
            addCriterion("wait_goods <=", value, "waitGoods");
            return (Criteria) this;
        }

        public Criteria andWaitGoodsLike(String value) {
            addCriterion("wait_goods like", value, "waitGoods");
            return (Criteria) this;
        }

        public Criteria andWaitGoodsNotLike(String value) {
            addCriterion("wait_goods not like", value, "waitGoods");
            return (Criteria) this;
        }

        public Criteria andWaitGoodsIn(List<String> values) {
            addCriterion("wait_goods in", values, "waitGoods");
            return (Criteria) this;
        }

        public Criteria andWaitGoodsNotIn(List<String> values) {
            addCriterion("wait_goods not in", values, "waitGoods");
            return (Criteria) this;
        }

        public Criteria andWaitGoodsBetween(String value1, String value2) {
            addCriterion("wait_goods between", value1, value2, "waitGoods");
            return (Criteria) this;
        }

        public Criteria andWaitGoodsNotBetween(String value1, String value2) {
            addCriterion("wait_goods not between", value1, value2, "waitGoods");
            return (Criteria) this;
        }

        public Criteria andWaitStatusIsNull() {
            addCriterion("wait_status is null");
            return (Criteria) this;
        }

        public Criteria andWaitStatusIsNotNull() {
            addCriterion("wait_status is not null");
            return (Criteria) this;
        }

        public Criteria andWaitStatusEqualTo(Boolean value) {
            addCriterion("wait_status =", value, "waitStatus");
            return (Criteria) this;
        }

        public Criteria andWaitStatusNotEqualTo(Boolean value) {
            addCriterion("wait_status <>", value, "waitStatus");
            return (Criteria) this;
        }

        public Criteria andWaitStatusGreaterThan(Boolean value) {
            addCriterion("wait_status >", value, "waitStatus");
            return (Criteria) this;
        }

        public Criteria andWaitStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("wait_status >=", value, "waitStatus");
            return (Criteria) this;
        }

        public Criteria andWaitStatusLessThan(Boolean value) {
            addCriterion("wait_status <", value, "waitStatus");
            return (Criteria) this;
        }

        public Criteria andWaitStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("wait_status <=", value, "waitStatus");
            return (Criteria) this;
        }

        public Criteria andWaitStatusIn(List<Boolean> values) {
            addCriterion("wait_status in", values, "waitStatus");
            return (Criteria) this;
        }

        public Criteria andWaitStatusNotIn(List<Boolean> values) {
            addCriterion("wait_status not in", values, "waitStatus");
            return (Criteria) this;
        }

        public Criteria andWaitStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("wait_status between", value1, value2, "waitStatus");
            return (Criteria) this;
        }

        public Criteria andWaitStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("wait_status not between", value1, value2, "waitStatus");
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