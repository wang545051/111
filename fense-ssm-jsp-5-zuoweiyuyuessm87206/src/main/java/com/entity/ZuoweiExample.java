package com.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Zuowei
 * @Description mybatis持久层数据操作座位表搜索条件及排序封装扩展类
 */
public class ZuoweiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZuoweiExample() {
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

        public Criteria andBianhaoIsNull() {
            addCriterion("bianhao is null");
            return (Criteria) this;
        }

        public Criteria andBianhaoIsNotNull() {
            addCriterion("bianhao is not null");
            return (Criteria) this;
        }

        public Criteria andBianhaoEqualTo(String value) {
            addCriterion("bianhao =", value, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoNotEqualTo(String value) {
            addCriterion("bianhao <>", value, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoGreaterThan(String value) {
            addCriterion("bianhao >", value, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoGreaterThanOrEqualTo(String value) {
            addCriterion("bianhao >=", value, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoLessThan(String value) {
            addCriterion("bianhao <", value, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoLessThanOrEqualTo(String value) {
            addCriterion("bianhao <=", value, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoLike(String value) {
            addCriterion("bianhao like", value, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoNotLike(String value) {
            addCriterion("bianhao not like", value, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoIn(List<String> values) {
            addCriterion("bianhao in", values, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoNotIn(List<String> values) {
            addCriterion("bianhao not in", values, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoBetween(String value1, String value2) {
            addCriterion("bianhao between", value1, value2, "bianhao");
            return (Criteria) this;
        }

        public Criteria andBianhaoNotBetween(String value1, String value2) {
            addCriterion("bianhao not between", value1, value2, "bianhao");
            return (Criteria) this;
        }
        public Criteria andLeibieidIsNull() {
            addCriterion("leibieid is null");
            return (Criteria) this;
        }

        public Criteria andLeibieidIsNotNull() {
            addCriterion("leibieid is not null");
            return (Criteria) this;
        }

        public Criteria andLeibieidEqualTo(Integer value) {
            addCriterion("leibieid =", value, "leibieid");
            return (Criteria) this;
        }

        public Criteria andLeibieidNotEqualTo(Integer value) {
            addCriterion("leibieid <>", value, "leibieid");
            return (Criteria) this;
        }

        public Criteria andLeibieidGreaterThan(Integer value) {
            addCriterion("leibieid >", value, "leibieid");
            return (Criteria) this;
        }

        public Criteria andLeibieidGreaterThanOrEqualTo(Integer value) {
            addCriterion("leibieid >=", value, "leibieid");
            return (Criteria) this;
        }

        public Criteria andLeibieidLessThan(Integer value) {
            addCriterion("leibieid <", value, "leibieid");
            return (Criteria) this;
        }

        public Criteria andLeibieidLessThanOrEqualTo(Integer value) {
            addCriterion("leibieid <=", value, "leibieid");
            return (Criteria) this;
        }

        public Criteria andLeibieidLike(Integer value) {
            addCriterion("leibieid like", value, "leibieid");
            return (Criteria) this;
        }

        public Criteria andLeibieidNotLike(Integer value) {
            addCriterion("leibieid not like", value, "leibieid");
            return (Criteria) this;
        }

        public Criteria andLeibieidIn(List<Integer> values) {
            addCriterion("leibieid in", values, "leibieid");
            return (Criteria) this;
        }

        public Criteria andLeibieidNotIn(List<Integer> values) {
            addCriterion("leibieid not in", values, "leibieid");
            return (Criteria) this;
        }

        public Criteria andLeibieidBetween(Integer value1, Integer value2) {
            addCriterion("leibieid between", value1, value2, "leibieid");
            return (Criteria) this;
        }

        public Criteria andLeibieidNotBetween(Integer value1, Integer value2) {
            addCriterion("leibieid not between", value1, value2, "leibieid");
            return (Criteria) this;
        }
        public Criteria andLoucengidIsNull() {
            addCriterion("loucengid is null");
            return (Criteria) this;
        }

        public Criteria andLoucengidIsNotNull() {
            addCriterion("loucengid is not null");
            return (Criteria) this;
        }

        public Criteria andLoucengidEqualTo(Integer value) {
            addCriterion("loucengid =", value, "loucengid");
            return (Criteria) this;
        }

        public Criteria andLoucengidNotEqualTo(Integer value) {
            addCriterion("loucengid <>", value, "loucengid");
            return (Criteria) this;
        }

        public Criteria andLoucengidGreaterThan(Integer value) {
            addCriterion("loucengid >", value, "loucengid");
            return (Criteria) this;
        }

        public Criteria andLoucengidGreaterThanOrEqualTo(Integer value) {
            addCriterion("loucengid >=", value, "loucengid");
            return (Criteria) this;
        }

        public Criteria andLoucengidLessThan(Integer value) {
            addCriterion("loucengid <", value, "loucengid");
            return (Criteria) this;
        }

        public Criteria andLoucengidLessThanOrEqualTo(Integer value) {
            addCriterion("loucengid <=", value, "loucengid");
            return (Criteria) this;
        }

        public Criteria andLoucengidLike(Integer value) {
            addCriterion("loucengid like", value, "loucengid");
            return (Criteria) this;
        }

        public Criteria andLoucengidNotLike(Integer value) {
            addCriterion("loucengid not like", value, "loucengid");
            return (Criteria) this;
        }

        public Criteria andLoucengidIn(List<Integer> values) {
            addCriterion("loucengid in", values, "loucengid");
            return (Criteria) this;
        }

        public Criteria andLoucengidNotIn(List<Integer> values) {
            addCriterion("loucengid not in", values, "loucengid");
            return (Criteria) this;
        }

        public Criteria andLoucengidBetween(Integer value1, Integer value2) {
            addCriterion("loucengid between", value1, value2, "loucengid");
            return (Criteria) this;
        }

        public Criteria andLoucengidNotBetween(Integer value1, Integer value2) {
            addCriterion("loucengid not between", value1, value2, "loucengid");
            return (Criteria) this;
        }
        public Criteria andFangjianidIsNull() {
            addCriterion("fangjianid is null");
            return (Criteria) this;
        }

        public Criteria andFangjianidIsNotNull() {
            addCriterion("fangjianid is not null");
            return (Criteria) this;
        }

        public Criteria andFangjianidEqualTo(Integer value) {
            addCriterion("fangjianid =", value, "fangjianid");
            return (Criteria) this;
        }

        public Criteria andFangjianidNotEqualTo(Integer value) {
            addCriterion("fangjianid <>", value, "fangjianid");
            return (Criteria) this;
        }

        public Criteria andFangjianidGreaterThan(Integer value) {
            addCriterion("fangjianid >", value, "fangjianid");
            return (Criteria) this;
        }

        public Criteria andFangjianidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fangjianid >=", value, "fangjianid");
            return (Criteria) this;
        }

        public Criteria andFangjianidLessThan(Integer value) {
            addCriterion("fangjianid <", value, "fangjianid");
            return (Criteria) this;
        }

        public Criteria andFangjianidLessThanOrEqualTo(Integer value) {
            addCriterion("fangjianid <=", value, "fangjianid");
            return (Criteria) this;
        }

        public Criteria andFangjianidLike(Integer value) {
            addCriterion("fangjianid like", value, "fangjianid");
            return (Criteria) this;
        }

        public Criteria andFangjianidNotLike(Integer value) {
            addCriterion("fangjianid not like", value, "fangjianid");
            return (Criteria) this;
        }

        public Criteria andFangjianidIn(List<Integer> values) {
            addCriterion("fangjianid in", values, "fangjianid");
            return (Criteria) this;
        }

        public Criteria andFangjianidNotIn(List<Integer> values) {
            addCriterion("fangjianid not in", values, "fangjianid");
            return (Criteria) this;
        }

        public Criteria andFangjianidBetween(Integer value1, Integer value2) {
            addCriterion("fangjianid between", value1, value2, "fangjianid");
            return (Criteria) this;
        }

        public Criteria andFangjianidNotBetween(Integer value1, Integer value2) {
            addCriterion("fangjianid not between", value1, value2, "fangjianid");
            return (Criteria) this;
        }
        public Criteria andNeirongIsNull() {
            addCriterion("neirong is null");
            return (Criteria) this;
        }

        public Criteria andNeirongIsNotNull() {
            addCriterion("neirong is not null");
            return (Criteria) this;
        }

        public Criteria andNeirongEqualTo(String value) {
            addCriterion("neirong =", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongNotEqualTo(String value) {
            addCriterion("neirong <>", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongGreaterThan(String value) {
            addCriterion("neirong >", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongGreaterThanOrEqualTo(String value) {
            addCriterion("neirong >=", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongLessThan(String value) {
            addCriterion("neirong <", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongLessThanOrEqualTo(String value) {
            addCriterion("neirong <=", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongLike(String value) {
            addCriterion("neirong like", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongNotLike(String value) {
            addCriterion("neirong not like", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongIn(List<String> values) {
            addCriterion("neirong in", values, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongNotIn(List<String> values) {
            addCriterion("neirong not in", values, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongBetween(String value1, String value2) {
            addCriterion("neirong between", value1, value2, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongNotBetween(String value1, String value2) {
            addCriterion("neirong not between", value1, value2, "neirong");
            return (Criteria) this;
        }
        public Criteria andShenheIsNull() {
            addCriterion("shenhe is null");
            return (Criteria) this;
        }

        public Criteria andShenheIsNotNull() {
            addCriterion("shenhe is not null");
            return (Criteria) this;
        }

        public Criteria andShenheEqualTo(String value) {
            addCriterion("shenhe =", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheNotEqualTo(String value) {
            addCriterion("shenhe <>", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheGreaterThan(String value) {
            addCriterion("shenhe >", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheGreaterThanOrEqualTo(String value) {
            addCriterion("shenhe >=", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheLessThan(String value) {
            addCriterion("shenhe <", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheLessThanOrEqualTo(String value) {
            addCriterion("shenhe <=", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheLike(String value) {
            addCriterion("shenhe like", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheNotLike(String value) {
            addCriterion("shenhe not like", value, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheIn(List<String> values) {
            addCriterion("shenhe in", values, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheNotIn(List<String> values) {
            addCriterion("shenhe not in", values, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheBetween(String value1, String value2) {
            addCriterion("shenhe between", value1, value2, "shenhe");
            return (Criteria) this;
        }

        public Criteria andShenheNotBetween(String value1, String value2) {
            addCriterion("shenhe not between", value1, value2, "shenhe");
            return (Criteria) this;
        }
        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
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
