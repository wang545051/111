package com.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Users
 * @Description mybatis持久层数据操作用户表搜索条件及排序封装扩展类
 */
public class UsersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsersExample() {
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

        public Criteria andLoginnameIsNull() {
            addCriterion("loginname is null");
            return (Criteria) this;
        }

        public Criteria andLoginnameIsNotNull() {
            addCriterion("loginname is not null");
            return (Criteria) this;
        }

        public Criteria andLoginnameEqualTo(String value) {
            addCriterion("loginname =", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotEqualTo(String value) {
            addCriterion("loginname <>", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameGreaterThan(String value) {
            addCriterion("loginname >", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameGreaterThanOrEqualTo(String value) {
            addCriterion("loginname >=", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLessThan(String value) {
            addCriterion("loginname <", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLessThanOrEqualTo(String value) {
            addCriterion("loginname <=", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLike(String value) {
            addCriterion("loginname like", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotLike(String value) {
            addCriterion("loginname not like", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameIn(List<String> values) {
            addCriterion("loginname in", values, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotIn(List<String> values) {
            addCriterion("loginname not in", values, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameBetween(String value1, String value2) {
            addCriterion("loginname between", value1, value2, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotBetween(String value1, String value2) {
            addCriterion("loginname not between", value1, value2, "loginname");
            return (Criteria) this;
        }
        public Criteria andLoginpwIsNull() {
            addCriterion("loginpw is null");
            return (Criteria) this;
        }

        public Criteria andLoginpwIsNotNull() {
            addCriterion("loginpw is not null");
            return (Criteria) this;
        }

        public Criteria andLoginpwEqualTo(String value) {
            addCriterion("loginpw =", value, "loginpw");
            return (Criteria) this;
        }

        public Criteria andLoginpwNotEqualTo(String value) {
            addCriterion("loginpw <>", value, "loginpw");
            return (Criteria) this;
        }

        public Criteria andLoginpwGreaterThan(String value) {
            addCriterion("loginpw >", value, "loginpw");
            return (Criteria) this;
        }

        public Criteria andLoginpwGreaterThanOrEqualTo(String value) {
            addCriterion("loginpw >=", value, "loginpw");
            return (Criteria) this;
        }

        public Criteria andLoginpwLessThan(String value) {
            addCriterion("loginpw <", value, "loginpw");
            return (Criteria) this;
        }

        public Criteria andLoginpwLessThanOrEqualTo(String value) {
            addCriterion("loginpw <=", value, "loginpw");
            return (Criteria) this;
        }

        public Criteria andLoginpwLike(String value) {
            addCriterion("loginpw like", value, "loginpw");
            return (Criteria) this;
        }

        public Criteria andLoginpwNotLike(String value) {
            addCriterion("loginpw not like", value, "loginpw");
            return (Criteria) this;
        }

        public Criteria andLoginpwIn(List<String> values) {
            addCriterion("loginpw in", values, "loginpw");
            return (Criteria) this;
        }

        public Criteria andLoginpwNotIn(List<String> values) {
            addCriterion("loginpw not in", values, "loginpw");
            return (Criteria) this;
        }

        public Criteria andLoginpwBetween(String value1, String value2) {
            addCriterion("loginpw between", value1, value2, "loginpw");
            return (Criteria) this;
        }

        public Criteria andLoginpwNotBetween(String value1, String value2) {
            addCriterion("loginpw not between", value1, value2, "loginpw");
            return (Criteria) this;
        }
        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }
        public Criteria andTypenameIsNull() {
            addCriterion("typename is null");
            return (Criteria) this;
        }

        public Criteria andTypenameIsNotNull() {
            addCriterion("typename is not null");
            return (Criteria) this;
        }

        public Criteria andTypenameEqualTo(String value) {
            addCriterion("typename =", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameNotEqualTo(String value) {
            addCriterion("typename <>", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameGreaterThan(String value) {
            addCriterion("typename >", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameGreaterThanOrEqualTo(String value) {
            addCriterion("typename >=", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameLessThan(String value) {
            addCriterion("typename <", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameLessThanOrEqualTo(String value) {
            addCriterion("typename <=", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameLike(String value) {
            addCriterion("typename like", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameNotLike(String value) {
            addCriterion("typename not like", value, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameIn(List<String> values) {
            addCriterion("typename in", values, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameNotIn(List<String> values) {
            addCriterion("typename not in", values, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameBetween(String value1, String value2) {
            addCriterion("typename between", value1, value2, "typename");
            return (Criteria) this;
        }

        public Criteria andTypenameNotBetween(String value1, String value2) {
            addCriterion("typename not between", value1, value2, "typename");
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
        public Criteria andXingbieIsNull() {
            addCriterion("xingbie is null");
            return (Criteria) this;
        }

        public Criteria andXingbieIsNotNull() {
            addCriterion("xingbie is not null");
            return (Criteria) this;
        }

        public Criteria andXingbieEqualTo(String value) {
            addCriterion("xingbie =", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieNotEqualTo(String value) {
            addCriterion("xingbie <>", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieGreaterThan(String value) {
            addCriterion("xingbie >", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieGreaterThanOrEqualTo(String value) {
            addCriterion("xingbie >=", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieLessThan(String value) {
            addCriterion("xingbie <", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieLessThanOrEqualTo(String value) {
            addCriterion("xingbie <=", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieLike(String value) {
            addCriterion("xingbie like", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieNotLike(String value) {
            addCriterion("xingbie not like", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieIn(List<String> values) {
            addCriterion("xingbie in", values, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieNotIn(List<String> values) {
            addCriterion("xingbie not in", values, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieBetween(String value1, String value2) {
            addCriterion("xingbie between", value1, value2, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieNotBetween(String value1, String value2) {
            addCriterion("xingbie not between", value1, value2, "xingbie");
            return (Criteria) this;
        }
        public Criteria andNianlingIsNull() {
            addCriterion("nianling is null");
            return (Criteria) this;
        }

        public Criteria andNianlingIsNotNull() {
            addCriterion("nianling is not null");
            return (Criteria) this;
        }

        public Criteria andNianlingEqualTo(String value) {
            addCriterion("nianling =", value, "nianling");
            return (Criteria) this;
        }

        public Criteria andNianlingNotEqualTo(String value) {
            addCriterion("nianling <>", value, "nianling");
            return (Criteria) this;
        }

        public Criteria andNianlingGreaterThan(String value) {
            addCriterion("nianling >", value, "nianling");
            return (Criteria) this;
        }

        public Criteria andNianlingGreaterThanOrEqualTo(String value) {
            addCriterion("nianling >=", value, "nianling");
            return (Criteria) this;
        }

        public Criteria andNianlingLessThan(String value) {
            addCriterion("nianling <", value, "nianling");
            return (Criteria) this;
        }

        public Criteria andNianlingLessThanOrEqualTo(String value) {
            addCriterion("nianling <=", value, "nianling");
            return (Criteria) this;
        }

        public Criteria andNianlingLike(String value) {
            addCriterion("nianling like", value, "nianling");
            return (Criteria) this;
        }

        public Criteria andNianlingNotLike(String value) {
            addCriterion("nianling not like", value, "nianling");
            return (Criteria) this;
        }

        public Criteria andNianlingIn(List<String> values) {
            addCriterion("nianling in", values, "nianling");
            return (Criteria) this;
        }

        public Criteria andNianlingNotIn(List<String> values) {
            addCriterion("nianling not in", values, "nianling");
            return (Criteria) this;
        }

        public Criteria andNianlingBetween(String value1, String value2) {
            addCriterion("nianling between", value1, value2, "nianling");
            return (Criteria) this;
        }

        public Criteria andNianlingNotBetween(String value1, String value2) {
            addCriterion("nianling not between", value1, value2, "nianling");
            return (Criteria) this;
        }
        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
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
