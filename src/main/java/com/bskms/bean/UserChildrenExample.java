package com.bskms.bean;

import java.util.ArrayList;
import java.util.List;

public class UserChildrenExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserChildrenExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andChildrenIdIsNull() {
            addCriterion("children_id is null");
            return (Criteria) this;
        }

        public Criteria andChildrenIdIsNotNull() {
            addCriterion("children_id is not null");
            return (Criteria) this;
        }

        public Criteria andChildrenIdEqualTo(Integer value) {
            addCriterion("children_id =", value, "childrenId");
            return (Criteria) this;
        }

        public Criteria andChildrenIdNotEqualTo(Integer value) {
            addCriterion("children_id <>", value, "childrenId");
            return (Criteria) this;
        }

        public Criteria andChildrenIdGreaterThan(Integer value) {
            addCriterion("children_id >", value, "childrenId");
            return (Criteria) this;
        }

        public Criteria andChildrenIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("children_id >=", value, "childrenId");
            return (Criteria) this;
        }

        public Criteria andChildrenIdLessThan(Integer value) {
            addCriterion("children_id <", value, "childrenId");
            return (Criteria) this;
        }

        public Criteria andChildrenIdLessThanOrEqualTo(Integer value) {
            addCriterion("children_id <=", value, "childrenId");
            return (Criteria) this;
        }

        public Criteria andChildrenIdIn(List<Integer> values) {
            addCriterion("children_id in", values, "childrenId");
            return (Criteria) this;
        }

        public Criteria andChildrenIdNotIn(List<Integer> values) {
            addCriterion("children_id not in", values, "childrenId");
            return (Criteria) this;
        }

        public Criteria andChildrenIdBetween(Integer value1, Integer value2) {
            addCriterion("children_id between", value1, value2, "childrenId");
            return (Criteria) this;
        }

        public Criteria andChildrenIdNotBetween(Integer value1, Integer value2) {
            addCriterion("children_id not between", value1, value2, "childrenId");
            return (Criteria) this;
        }

        public Criteria andIsFaMaIsNull() {
            addCriterion("is_fa_ma is null");
            return (Criteria) this;
        }

        public Criteria andIsFaMaIsNotNull() {
            addCriterion("is_fa_ma is not null");
            return (Criteria) this;
        }

        public Criteria andIsFaMaEqualTo(Integer value) {
            addCriterion("is_fa_ma =", value, "isFaMa");
            return (Criteria) this;
        }

        public Criteria andIsFaMaNotEqualTo(Integer value) {
            addCriterion("is_fa_ma <>", value, "isFaMa");
            return (Criteria) this;
        }

        public Criteria andIsFaMaGreaterThan(Integer value) {
            addCriterion("is_fa_ma >", value, "isFaMa");
            return (Criteria) this;
        }

        public Criteria andIsFaMaGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_fa_ma >=", value, "isFaMa");
            return (Criteria) this;
        }

        public Criteria andIsFaMaLessThan(Integer value) {
            addCriterion("is_fa_ma <", value, "isFaMa");
            return (Criteria) this;
        }

        public Criteria andIsFaMaLessThanOrEqualTo(Integer value) {
            addCriterion("is_fa_ma <=", value, "isFaMa");
            return (Criteria) this;
        }

        public Criteria andIsFaMaIn(List<Integer> values) {
            addCriterion("is_fa_ma in", values, "isFaMa");
            return (Criteria) this;
        }

        public Criteria andIsFaMaNotIn(List<Integer> values) {
            addCriterion("is_fa_ma not in", values, "isFaMa");
            return (Criteria) this;
        }

        public Criteria andIsFaMaBetween(Integer value1, Integer value2) {
            addCriterion("is_fa_ma between", value1, value2, "isFaMa");
            return (Criteria) this;
        }

        public Criteria andIsFaMaNotBetween(Integer value1, Integer value2) {
            addCriterion("is_fa_ma not between", value1, value2, "isFaMa");
            return (Criteria) this;
        }

        public Criteria andIsJinjiIsNull() {
            addCriterion("is_jinji is null");
            return (Criteria) this;
        }

        public Criteria andIsJinjiIsNotNull() {
            addCriterion("is_jinji is not null");
            return (Criteria) this;
        }

        public Criteria andIsJinjiEqualTo(Integer value) {
            addCriterion("is_jinji =", value, "isJinji");
            return (Criteria) this;
        }

        public Criteria andIsJinjiNotEqualTo(Integer value) {
            addCriterion("is_jinji <>", value, "isJinji");
            return (Criteria) this;
        }

        public Criteria andIsJinjiGreaterThan(Integer value) {
            addCriterion("is_jinji >", value, "isJinji");
            return (Criteria) this;
        }

        public Criteria andIsJinjiGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_jinji >=", value, "isJinji");
            return (Criteria) this;
        }

        public Criteria andIsJinjiLessThan(Integer value) {
            addCriterion("is_jinji <", value, "isJinji");
            return (Criteria) this;
        }

        public Criteria andIsJinjiLessThanOrEqualTo(Integer value) {
            addCriterion("is_jinji <=", value, "isJinji");
            return (Criteria) this;
        }

        public Criteria andIsJinjiIn(List<Integer> values) {
            addCriterion("is_jinji in", values, "isJinji");
            return (Criteria) this;
        }

        public Criteria andIsJinjiNotIn(List<Integer> values) {
            addCriterion("is_jinji not in", values, "isJinji");
            return (Criteria) this;
        }

        public Criteria andIsJinjiBetween(Integer value1, Integer value2) {
            addCriterion("is_jinji between", value1, value2, "isJinji");
            return (Criteria) this;
        }

        public Criteria andIsJinjiNotBetween(Integer value1, Integer value2) {
            addCriterion("is_jinji not between", value1, value2, "isJinji");
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