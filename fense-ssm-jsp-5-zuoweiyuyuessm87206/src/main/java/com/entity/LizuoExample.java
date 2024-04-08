package com.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Lizuo
 * @Description mybatis持久层数据操作离座表搜索条件及排序封装扩展类
 */
public class LizuoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LizuoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andXingmingIsNull() {
            addCriterion("xingming is null");
            return (Criteria) this;
        }

        public Criteria andXingmingIsNotNull() {
            addCriterion("xingming is not null");
            return (Criteria) this;
        }

        public Criteria andXingmingEqualTo(String value) {
            addCriterion("xingming =", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingNotEqualTo(String value) {
            addCriterion("xingming <>", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingGreaterThan(String value) {
            addCriterion("xingming >", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingGreaterThanOrEqualTo(String value) {
            addCriterion("xingming >=", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingLessThan(String value) {
            addCriterion("xingming <", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingLessThanOrEqualTo(String value) {
            addCriterion("xingming <=", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingLike(String value) {
            addCriterion("xingming like", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingNotLike(String value) {
            addCriterion("xingming not like", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingIn(List<String> values) {
            addCriterion("xingming in", values, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingNotIn(List<String> values) {
            addCriterion("xingming not in", values, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingBetween(String value1, String value2) {
            addCriterion("xingming between", value1, value2, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingNotBetween(String value1, String value2) {
            addCriterion("xingming not between", value1, value2, "xingming");
            return (Criteria) this;
        }
        public Criteria andDianhuaIsNull() {
            addCriterion("dianhua is null");
            return (Criteria) this;
        }

        public Criteria andDianhuaIsNotNull() {
            addCriterion("dianhua is not null");
            return (Criteria) this;
        }

        public Criteria andDianhuaEqualTo(String value) {
            addCriterion("dianhua =", value, "dianhua");
            return (Criteria) this;
        }

        public Criteria andDianhuaNotEqualTo(String value) {
            addCriterion("dianhua <>", value, "dianhua");
            return (Criteria) this;
        }

        public Criteria andDianhuaGreaterThan(String value) {
            addCriterion("dianhua >", value, "dianhua");
            return (Criteria) this;
        }

        public Criteria andDianhuaGreaterThanOrEqualTo(String value) {
            addCriterion("dianhua >=", value, "dianhua");
            return (Criteria) this;
        }

        public Criteria andDianhuaLessThan(String value) {
            addCriterion("dianhua <", value, "dianhua");
            return (Criteria) this;
        }

        public Criteria andDianhuaLessThanOrEqualTo(String value) {
            addCriterion("dianhua <=", value, "dianhua");
            return (Criteria) this;
        }

        public Criteria andDianhuaLike(String value) {
            addCriterion("dianhua like", value, "dianhua");
            return (Criteria) this;
        }

        public Criteria andDianhuaNotLike(String value) {
            addCriterion("dianhua not like", value, "dianhua");
            return (Criteria) this;
        }

        public Criteria andDianhuaIn(List<String> values) {
            addCriterion("dianhua in", values, "dianhua");
            return (Criteria) this;
        }

        public Criteria andDianhuaNotIn(List<String> values) {
            addCriterion("dianhua not in", values, "dianhua");
            return (Criteria) this;
        }

        public Criteria andDianhuaBetween(String value1, String value2) {
            addCriterion("dianhua between", value1, value2, "dianhua");
            return (Criteria) this;
        }

        public Criteria andDianhuaNotBetween(String value1, String value2) {
            addCriterion("dianhua not between", value1, value2, "dianhua");
            return (Criteria) this;
        }
        public Criteria andZuoweiidIsNull() {
            addCriterion("zuoweiid is null");
            return (Criteria) this;
        }

        public Criteria andZuoweiidIsNotNull() {
            addCriterion("zuoweiid is not null");
            return (Criteria) this;
        }

        public Criteria andZuoweiidEqualTo(Integer value) {
            addCriterion("zuoweiid =", value, "zuoweiid");
            return (Criteria) this;
        }

        public Criteria andZuoweiidNotEqualTo(Integer value) {
            addCriterion("zuoweiid <>", value, "zuoweiid");
            return (Criteria) this;
        }

        public Criteria andZuoweiidGreaterThan(Integer value) {
            addCriterion("zuoweiid >", value, "zuoweiid");
            return (Criteria) this;
        }

        public Criteria andZuoweiidGreaterThanOrEqualTo(Integer value) {
            addCriterion("zuoweiid >=", value, "zuoweiid");
            return (Criteria) this;
        }

        public Criteria andZuoweiidLessThan(Integer value) {
            addCriterion("zuoweiid <", value, "zuoweiid");
            return (Criteria) this;
        }

        public Criteria andZuoweiidLessThanOrEqualTo(Integer value) {
            addCriterion("zuoweiid <=", value, "zuoweiid");
            return (Criteria) this;
        }

        public Criteria andZuoweiidLike(Integer value) {
            addCriterion("zuoweiid like", value, "zuoweiid");
            return (Criteria) this;
        }

        public Criteria andZuoweiidNotLike(Integer value) {
            addCriterion("zuoweiid not like", value, "zuoweiid");
            return (Criteria) this;
        }

        public Criteria andZuoweiidIn(List<Integer> values) {
            addCriterion("zuoweiid in", values, "zuoweiid");
            return (Criteria) this;
        }

        public Criteria andZuoweiidNotIn(List<Integer> values) {
            addCriterion("zuoweiid not in", values, "zuoweiid");
            return (Criteria) this;
        }

        public Criteria andZuoweiidBetween(Integer value1, Integer value2) {
            addCriterion("zuoweiid between", value1, value2, "zuoweiid");
            return (Criteria) this;
        }

        public Criteria andZuoweiidNotBetween(Integer value1, Integer value2) {
            addCriterion("zuoweiid not between", value1, value2, "zuoweiid");
            return (Criteria) this;
        }
        public Criteria andShijianIsNull() {
            addCriterion("shijian is null");
            return (Criteria) this;
        }

        public Criteria andShijianIsNotNull() {
            addCriterion("shijian is not null");
            return (Criteria) this;
        }

        public Criteria andShijianEqualTo(String value) {
            addCriterion("shijian =", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianNotEqualTo(String value) {
            addCriterion("shijian <>", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianGreaterThan(String value) {
            addCriterion("shijian >", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianGreaterThanOrEqualTo(String value) {
            addCriterion("shijian >=", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianLessThan(String value) {
            addCriterion("shijian <", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianLessThanOrEqualTo(String value) {
            addCriterion("shijian <=", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianLike(String value) {
            addCriterion("shijian like", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianNotLike(String value) {
            addCriterion("shijian not like", value, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianIn(List<String> values) {
            addCriterion("shijian in", values, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianNotIn(List<String> values) {
            addCriterion("shijian not in", values, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianBetween(String value1, String value2) {
            addCriterion("shijian between", value1, value2, "shijian");
            return (Criteria) this;
        }

        public Criteria andShijianNotBetween(String value1, String value2) {
            addCriterion("shijian not between", value1, value2, "shijian");
            return (Criteria) this;
        }
        public Criteria andBeizhuIsNull() {
            addCriterion("beizhu is null");
            return (Criteria) this;
        }

        public Criteria andBeizhuIsNotNull() {
            addCriterion("beizhu is not null");
            return (Criteria) this;
        }

        public Criteria andBeizhuEqualTo(String value) {
            addCriterion("beizhu =", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotEqualTo(String value) {
            addCriterion("beizhu <>", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuGreaterThan(String value) {
            addCriterion("beizhu >", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuGreaterThanOrEqualTo(String value) {
            addCriterion("beizhu >=", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuLessThan(String value) {
            addCriterion("beizhu <", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuLessThanOrEqualTo(String value) {
            addCriterion("beizhu <=", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuLike(String value) {
            addCriterion("beizhu like", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotLike(String value) {
            addCriterion("beizhu not like", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuIn(List<String> values) {
            addCriterion("beizhu in", values, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotIn(List<String> values) {
            addCriterion("beizhu not in", values, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuBetween(String value1, String value2) {
            addCriterion("beizhu between", value1, value2, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotBetween(String value1, String value2) {
            addCriterion("beizhu not between", value1, value2, "beizhu");
            return (Criteria) this;
        }
        public Criteria andUsersslidIsNull() {
            addCriterion("usersslid is null");
            return (Criteria) this;
        }

        public Criteria andUsersslidIsNotNull() {
            addCriterion("usersslid is not null");
            return (Criteria) this;
        }

        public Criteria andUsersslidEqualTo(Integer value) {
            addCriterion("usersslid =", value, "usersslid");
            return (Criteria) this;
        }

        public Criteria andUsersslidNotEqualTo(Integer value) {
            addCriterion("usersslid <>", value, "usersslid");
            return (Criteria) this;
        }

        public Criteria andUsersslidGreaterThan(Integer value) {
            addCriterion("usersslid >", value, "usersslid");
            return (Criteria) this;
        }

        public Criteria andUsersslidGreaterThanOrEqualTo(Integer value) {
            addCriterion("usersslid >=", value, "usersslid");
            return (Criteria) this;
        }

        public Criteria andUsersslidLessThan(Integer value) {
            addCriterion("usersslid <", value, "usersslid");
            return (Criteria) this;
        }

        public Criteria andUsersslidLessThanOrEqualTo(Integer value) {
            addCriterion("usersslid <=", value, "usersslid");
            return (Criteria) this;
        }

        public Criteria andUsersslidLike(Integer value) {
            addCriterion("usersslid like", value, "usersslid");
            return (Criteria) this;
        }

        public Criteria andUsersslidNotLike(Integer value) {
            addCriterion("usersslid not like", value, "usersslid");
            return (Criteria) this;
        }

        public Criteria andUsersslidIn(List<Integer> values) {
            addCriterion("usersslid in", values, "usersslid");
            return (Criteria) this;
        }

        public Criteria andUsersslidNotIn(List<Integer> values) {
            addCriterion("usersslid not in", values, "usersslid");
            return (Criteria) this;
        }

        public Criteria andUsersslidBetween(Integer value1, Integer value2) {
            addCriterion("usersslid between", value1, value2, "usersslid");
            return (Criteria) this;
        }

        public Criteria andUsersslidNotBetween(Integer value1, Integer value2) {
            addCriterion("usersslid not between", value1, value2, "usersslid");
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
