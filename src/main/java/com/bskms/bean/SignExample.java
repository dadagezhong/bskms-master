package com.bskms.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SignExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SignExample() {
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

        public Criteria andKqrIdIsNull() {
            addCriterion("kqr_id is null");
            return (Criteria) this;
        }

        public Criteria andKqrIdIsNotNull() {
            addCriterion("kqr_id is not null");
            return (Criteria) this;
        }

        public Criteria andKqrIdEqualTo(String value) {
            addCriterion("kqr_id =", value, "kqrId");
            return (Criteria) this;
        }

        public Criteria andKqrIdNotEqualTo(String value) {
            addCriterion("kqr_id <>", value, "kqrId");
            return (Criteria) this;
        }

        public Criteria andKqrIdGreaterThan(String value) {
            addCriterion("kqr_id >", value, "kqrId");
            return (Criteria) this;
        }

        public Criteria andKqrIdGreaterThanOrEqualTo(String value) {
            addCriterion("kqr_id >=", value, "kqrId");
            return (Criteria) this;
        }

        public Criteria andKqrIdLessThan(String value) {
            addCriterion("kqr_id <", value, "kqrId");
            return (Criteria) this;
        }

        public Criteria andKqrIdLessThanOrEqualTo(String value) {
            addCriterion("kqr_id <=", value, "kqrId");
            return (Criteria) this;
        }

        public Criteria andKqrIdLike(String value) {
            addCriterion("kqr_id like", value, "kqrId");
            return (Criteria) this;
        }

        public Criteria andKqrIdNotLike(String value) {
            addCriterion("kqr_id not like", value, "kqrId");
            return (Criteria) this;
        }

        public Criteria andKqrIdIn(List<String> values) {
            addCriterion("kqr_id in", values, "kqrId");
            return (Criteria) this;
        }

        public Criteria andKqrIdNotIn(List<String> values) {
            addCriterion("kqr_id not in", values, "kqrId");
            return (Criteria) this;
        }

        public Criteria andKqrIdBetween(String value1, String value2) {
            addCriterion("kqr_id between", value1, value2, "kqrId");
            return (Criteria) this;
        }

        public Criteria andKqrIdNotBetween(String value1, String value2) {
            addCriterion("kqr_id not between", value1, value2, "kqrId");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andDescribeIsNull() {
            addCriterion("describe is null");
            return (Criteria) this;
        }

        public Criteria andDescribeIsNotNull() {
            addCriterion("describe is not null");
            return (Criteria) this;
        }

        public Criteria andDescribeEqualTo(String value) {
            addCriterion("describe =", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotEqualTo(String value) {
            addCriterion("describe <>", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeGreaterThan(String value) {
            addCriterion("describe >", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("describe >=", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLessThan(String value) {
            addCriterion("describe <", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLessThanOrEqualTo(String value) {
            addCriterion("describe <=", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLike(String value) {
            addCriterion("describe like", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotLike(String value) {
            addCriterion("describe not like", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeIn(List<String> values) {
            addCriterion("describe in", values, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotIn(List<String> values) {
            addCriterion("describe not in", values, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeBetween(String value1, String value2) {
            addCriterion("describe between", value1, value2, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotBetween(String value1, String value2) {
            addCriterion("describe not between", value1, value2, "describe");
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

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andKqrTypeIsNull() {
            addCriterion("kqr_type is null");
            return (Criteria) this;
        }

        public Criteria andKqrTypeIsNotNull() {
            addCriterion("kqr_type is not null");
            return (Criteria) this;
        }

        public Criteria andKqrTypeEqualTo(Integer value) {
            addCriterion("kqr_type =", value, "kqrType");
            return (Criteria) this;
        }

        public Criteria andKqrTypeNotEqualTo(Integer value) {
            addCriterion("kqr_type <>", value, "kqrType");
            return (Criteria) this;
        }

        public Criteria andKqrTypeGreaterThan(Integer value) {
            addCriterion("kqr_type >", value, "kqrType");
            return (Criteria) this;
        }

        public Criteria andKqrTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("kqr_type >=", value, "kqrType");
            return (Criteria) this;
        }

        public Criteria andKqrTypeLessThan(Integer value) {
            addCriterion("kqr_type <", value, "kqrType");
            return (Criteria) this;
        }

        public Criteria andKqrTypeLessThanOrEqualTo(Integer value) {
            addCriterion("kqr_type <=", value, "kqrType");
            return (Criteria) this;
        }

        public Criteria andKqrTypeIn(List<Integer> values) {
            addCriterion("kqr_type in", values, "kqrType");
            return (Criteria) this;
        }

        public Criteria andKqrTypeNotIn(List<Integer> values) {
            addCriterion("kqr_type not in", values, "kqrType");
            return (Criteria) this;
        }

        public Criteria andKqrTypeBetween(Integer value1, Integer value2) {
            addCriterion("kqr_type between", value1, value2, "kqrType");
            return (Criteria) this;
        }

        public Criteria andKqrTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("kqr_type not between", value1, value2, "kqrType");
            return (Criteria) this;
        }

        public Criteria andSignInIsNull() {
            addCriterion("sign_in is null");
            return (Criteria) this;
        }

        public Criteria andSignInIsNotNull() {
            addCriterion("sign_in is not null");
            return (Criteria) this;
        }

        public Criteria andSignInEqualTo(Date value) {
            addCriterion("sign_in =", value, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInNotEqualTo(Date value) {
            addCriterion("sign_in <>", value, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInGreaterThan(Date value) {
            addCriterion("sign_in >", value, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInGreaterThanOrEqualTo(Date value) {
            addCriterion("sign_in >=", value, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInLessThan(Date value) {
            addCriterion("sign_in <", value, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInLessThanOrEqualTo(Date value) {
            addCriterion("sign_in <=", value, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInIn(List<Date> values) {
            addCriterion("sign_in in", values, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInNotIn(List<Date> values) {
            addCriterion("sign_in not in", values, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInBetween(Date value1, Date value2) {
            addCriterion("sign_in between", value1, value2, "signIn");
            return (Criteria) this;
        }

        public Criteria andSignInNotBetween(Date value1, Date value2) {
            addCriterion("sign_in not between", value1, value2, "signIn");
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