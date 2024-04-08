package com.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Yuyue
 * @Description mybatis持久层数据操作预约表搜索条件及排序封装扩展类
 */
public class YuyueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YuyueExample() {
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
        public Criteria andShiduanidIsNull() {
            addCriterion("shiduanid is null");
            return (Criteria) this;
        }

        public Criteria andShiduanidIsNotNull() {
            addCriterion("shiduanid is not null");
            return (Criteria) this;
        }

        public Criteria andShiduanidEqualTo(Integer value) {
            addCriterion("shiduanid =", value, "shiduanid");
            return (Criteria) this;
        }

        public Criteria andShiduanidNotEqualTo(Integer value) {
            addCriterion("shiduanid <>", value, "shiduanid");
            return (Criteria) this;
        }

        public Criteria andShiduanidGreaterThan(Integer value) {
            addCriterion("shiduanid >", value, "shiduanid");
            return (Criteria) this;
        }

        public Criteria andShiduanidGreaterThanOrEqualTo(Integer value) {
            addCriterion("shiduanid >=", value, "shiduanid");
            return (Criteria) this;
        }

        public Criteria andShiduanidLessThan(Integer value) {
            addCriterion("shiduanid <", value, "shiduanid");
            return (Criteria) this;
        }

        public Criteria andShiduanidLessThanOrEqualTo(Integer value) {
            addCriterion("shiduanid <=", value, "shiduanid");
            return (Criteria) this;
        }

        public Criteria andShiduanidLike(Integer value) {
            addCriterion("shiduanid like", value, "shiduanid");
            return (Criteria) this;
        }

        public Criteria andShiduanidNotLike(Integer value) {
            addCriterion("shiduanid not like", value, "shiduanid");
            return (Criteria) this;
        }

        public Criteria andShiduanidIn(List<Integer> values) {
            addCriterion("shiduanid in", values, "shiduanid");
            return (Criteria) this;
        }

        public Criteria andShiduanidNotIn(List<Integer> values) {
            addCriterion("shiduanid not in", values, "shiduanid");
            return (Criteria) this;
        }

        public Criteria andShiduanidBetween(Integer value1, Integer value2) {
            addCriterion("shiduanid between", value1, value2, "shiduanid");
            return (Criteria) this;
        }

        public Criteria andShiduanidNotBetween(Integer value1, Integer value2) {
            addCriterion("shiduanid not between", value1, value2, "shiduanid");
            return (Criteria) this;
        }
        public Criteria andRiqiIsNull() {
            addCriterion("riqi is null");
            return (Criteria) this;
        }

        public Criteria andRiqiIsNotNull() {
            addCriterion("riqi is not null");
            return (Criteria) this;
        }

        public Criteria andRiqiEqualTo(String value) {
            addCriterion("riqi =", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiNotEqualTo(String value) {
            addCriterion("riqi <>", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiGreaterThan(String value) {
            addCriterion("riqi >", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiGreaterThanOrEqualTo(String value) {
            addCriterion("riqi >=", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiLessThan(String value) {
            addCriterion("riqi <", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiLessThanOrEqualTo(String value) {
            addCriterion("riqi <=", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiLike(String value) {
            addCriterion("riqi like", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiNotLike(String value) {
            addCriterion("riqi not like", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiIn(List<String> values) {
            addCriterion("riqi in", values, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiNotIn(List<String> values) {
            addCriterion("riqi not in", values, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiBetween(String value1, String value2) {
            addCriterion("riqi between", value1, value2, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiNotBetween(String value1, String value2) {
            addCriterion("riqi not between", value1, value2, "riqi");
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
        public Criteria andUsersidIsNull() {
            addCriterion("usersid is null");
            return (Criteria) this;
        }

        public Criteria andUsersidIsNotNull() {
            addCriterion("usersid is not null");
            return (Criteria) this;
        }

        public Criteria andUsersidEqualTo(Integer value) {
            addCriterion("usersid =", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidNotEqualTo(Integer value) {
            addCriterion("usersid <>", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidGreaterThan(Integer value) {
            addCriterion("usersid >", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidGreaterThanOrEqualTo(Integer value) {
            addCriterion("usersid >=", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidLessThan(Integer value) {
            addCriterion("usersid <", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidLessThanOrEqualTo(Integer value) {
            addCriterion("usersid <=", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidLike(Integer value) {
            addCriterion("usersid like", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidNotLike(Integer value) {
            addCriterion("usersid not like", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidIn(List<Integer> values) {
            addCriterion("usersid in", values, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidNotIn(List<Integer> values) {
            addCriterion("usersid not in", values, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidBetween(Integer value1, Integer value2) {
            addCriterion("usersid between", value1, value2, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidNotBetween(Integer value1, Integer value2) {
            addCriterion("usersid not between", value1, value2, "usersid");
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
