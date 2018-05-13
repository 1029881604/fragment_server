package team.antelope.fg.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NearbymodularExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NearbymodularExample() {
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

        public Criteria andNeedtitleIsNull() {
            addCriterion("needtitle is null");
            return (Criteria) this;
        }

        public Criteria andNeedtitleIsNotNull() {
            addCriterion("needtitle is not null");
            return (Criteria) this;
        }

        public Criteria andNeedtitleEqualTo(String value) {
            addCriterion("needtitle =", value, "needtitle");
            return (Criteria) this;
        }

        public Criteria andNeedtitleNotEqualTo(String value) {
            addCriterion("needtitle <>", value, "needtitle");
            return (Criteria) this;
        }

        public Criteria andNeedtitleGreaterThan(String value) {
            addCriterion("needtitle >", value, "needtitle");
            return (Criteria) this;
        }

        public Criteria andNeedtitleGreaterThanOrEqualTo(String value) {
            addCriterion("needtitle >=", value, "needtitle");
            return (Criteria) this;
        }

        public Criteria andNeedtitleLessThan(String value) {
            addCriterion("needtitle <", value, "needtitle");
            return (Criteria) this;
        }

        public Criteria andNeedtitleLessThanOrEqualTo(String value) {
            addCriterion("needtitle <=", value, "needtitle");
            return (Criteria) this;
        }

        public Criteria andNeedtitleLike(String value) {
            addCriterion("needtitle like", value, "needtitle");
            return (Criteria) this;
        }

        public Criteria andNeedtitleNotLike(String value) {
            addCriterion("needtitle not like", value, "needtitle");
            return (Criteria) this;
        }

        public Criteria andNeedtitleIn(List<String> values) {
            addCriterion("needtitle in", values, "needtitle");
            return (Criteria) this;
        }

        public Criteria andNeedtitleNotIn(List<String> values) {
            addCriterion("needtitle not in", values, "needtitle");
            return (Criteria) this;
        }

        public Criteria andNeedtitleBetween(String value1, String value2) {
            addCriterion("needtitle between", value1, value2, "needtitle");
            return (Criteria) this;
        }

        public Criteria andNeedtitleNotBetween(String value1, String value2) {
            addCriterion("needtitle not between", value1, value2, "needtitle");
            return (Criteria) this;
        }

        public Criteria andNeedbodyIsNull() {
            addCriterion("needbody is null");
            return (Criteria) this;
        }

        public Criteria andNeedbodyIsNotNull() {
            addCriterion("needbody is not null");
            return (Criteria) this;
        }

        public Criteria andNeedbodyEqualTo(String value) {
            addCriterion("needbody =", value, "needbody");
            return (Criteria) this;
        }

        public Criteria andNeedbodyNotEqualTo(String value) {
            addCriterion("needbody <>", value, "needbody");
            return (Criteria) this;
        }

        public Criteria andNeedbodyGreaterThan(String value) {
            addCriterion("needbody >", value, "needbody");
            return (Criteria) this;
        }

        public Criteria andNeedbodyGreaterThanOrEqualTo(String value) {
            addCriterion("needbody >=", value, "needbody");
            return (Criteria) this;
        }

        public Criteria andNeedbodyLessThan(String value) {
            addCriterion("needbody <", value, "needbody");
            return (Criteria) this;
        }

        public Criteria andNeedbodyLessThanOrEqualTo(String value) {
            addCriterion("needbody <=", value, "needbody");
            return (Criteria) this;
        }

        public Criteria andNeedbodyLike(String value) {
            addCriterion("needbody like", value, "needbody");
            return (Criteria) this;
        }

        public Criteria andNeedbodyNotLike(String value) {
            addCriterion("needbody not like", value, "needbody");
            return (Criteria) this;
        }

        public Criteria andNeedbodyIn(List<String> values) {
            addCriterion("needbody in", values, "needbody");
            return (Criteria) this;
        }

        public Criteria andNeedbodyNotIn(List<String> values) {
            addCriterion("needbody not in", values, "needbody");
            return (Criteria) this;
        }

        public Criteria andNeedbodyBetween(String value1, String value2) {
            addCriterion("needbody between", value1, value2, "needbody");
            return (Criteria) this;
        }

        public Criteria andNeedbodyNotBetween(String value1, String value2) {
            addCriterion("needbody not between", value1, value2, "needbody");
            return (Criteria) this;
        }

        public Criteria andNeedimgIsNull() {
            addCriterion("needimg is null");
            return (Criteria) this;
        }

        public Criteria andNeedimgIsNotNull() {
            addCriterion("needimg is not null");
            return (Criteria) this;
        }

        public Criteria andNeedimgEqualTo(String value) {
            addCriterion("needimg =", value, "needimg");
            return (Criteria) this;
        }

        public Criteria andNeedimgNotEqualTo(String value) {
            addCriterion("needimg <>", value, "needimg");
            return (Criteria) this;
        }

        public Criteria andNeedimgGreaterThan(String value) {
            addCriterion("needimg >", value, "needimg");
            return (Criteria) this;
        }

        public Criteria andNeedimgGreaterThanOrEqualTo(String value) {
            addCriterion("needimg >=", value, "needimg");
            return (Criteria) this;
        }

        public Criteria andNeedimgLessThan(String value) {
            addCriterion("needimg <", value, "needimg");
            return (Criteria) this;
        }

        public Criteria andNeedimgLessThanOrEqualTo(String value) {
            addCriterion("needimg <=", value, "needimg");
            return (Criteria) this;
        }

        public Criteria andNeedimgLike(String value) {
            addCriterion("needimg like", value, "needimg");
            return (Criteria) this;
        }

        public Criteria andNeedimgNotLike(String value) {
            addCriterion("needimg not like", value, "needimg");
            return (Criteria) this;
        }

        public Criteria andNeedimgIn(List<String> values) {
            addCriterion("needimg in", values, "needimg");
            return (Criteria) this;
        }

        public Criteria andNeedimgNotIn(List<String> values) {
            addCriterion("needimg not in", values, "needimg");
            return (Criteria) this;
        }

        public Criteria andNeedimgBetween(String value1, String value2) {
            addCriterion("needimg between", value1, value2, "needimg");
            return (Criteria) this;
        }

        public Criteria andNeedimgNotBetween(String value1, String value2) {
            addCriterion("needimg not between", value1, value2, "needimg");
            return (Criteria) this;
        }

        public Criteria andSkilltitleIsNull() {
            addCriterion("skilltitle is null");
            return (Criteria) this;
        }

        public Criteria andSkilltitleIsNotNull() {
            addCriterion("skilltitle is not null");
            return (Criteria) this;
        }

        public Criteria andSkilltitleEqualTo(String value) {
            addCriterion("skilltitle =", value, "skilltitle");
            return (Criteria) this;
        }

        public Criteria andSkilltitleNotEqualTo(String value) {
            addCriterion("skilltitle <>", value, "skilltitle");
            return (Criteria) this;
        }

        public Criteria andSkilltitleGreaterThan(String value) {
            addCriterion("skilltitle >", value, "skilltitle");
            return (Criteria) this;
        }

        public Criteria andSkilltitleGreaterThanOrEqualTo(String value) {
            addCriterion("skilltitle >=", value, "skilltitle");
            return (Criteria) this;
        }

        public Criteria andSkilltitleLessThan(String value) {
            addCriterion("skilltitle <", value, "skilltitle");
            return (Criteria) this;
        }

        public Criteria andSkilltitleLessThanOrEqualTo(String value) {
            addCriterion("skilltitle <=", value, "skilltitle");
            return (Criteria) this;
        }

        public Criteria andSkilltitleLike(String value) {
            addCriterion("skilltitle like", value, "skilltitle");
            return (Criteria) this;
        }

        public Criteria andSkilltitleNotLike(String value) {
            addCriterion("skilltitle not like", value, "skilltitle");
            return (Criteria) this;
        }

        public Criteria andSkilltitleIn(List<String> values) {
            addCriterion("skilltitle in", values, "skilltitle");
            return (Criteria) this;
        }

        public Criteria andSkilltitleNotIn(List<String> values) {
            addCriterion("skilltitle not in", values, "skilltitle");
            return (Criteria) this;
        }

        public Criteria andSkilltitleBetween(String value1, String value2) {
            addCriterion("skilltitle between", value1, value2, "skilltitle");
            return (Criteria) this;
        }

        public Criteria andSkilltitleNotBetween(String value1, String value2) {
            addCriterion("skilltitle not between", value1, value2, "skilltitle");
            return (Criteria) this;
        }

        public Criteria andSkillbodyIsNull() {
            addCriterion("skillbody is null");
            return (Criteria) this;
        }

        public Criteria andSkillbodyIsNotNull() {
            addCriterion("skillbody is not null");
            return (Criteria) this;
        }

        public Criteria andSkillbodyEqualTo(String value) {
            addCriterion("skillbody =", value, "skillbody");
            return (Criteria) this;
        }

        public Criteria andSkillbodyNotEqualTo(String value) {
            addCriterion("skillbody <>", value, "skillbody");
            return (Criteria) this;
        }

        public Criteria andSkillbodyGreaterThan(String value) {
            addCriterion("skillbody >", value, "skillbody");
            return (Criteria) this;
        }

        public Criteria andSkillbodyGreaterThanOrEqualTo(String value) {
            addCriterion("skillbody >=", value, "skillbody");
            return (Criteria) this;
        }

        public Criteria andSkillbodyLessThan(String value) {
            addCriterion("skillbody <", value, "skillbody");
            return (Criteria) this;
        }

        public Criteria andSkillbodyLessThanOrEqualTo(String value) {
            addCriterion("skillbody <=", value, "skillbody");
            return (Criteria) this;
        }

        public Criteria andSkillbodyLike(String value) {
            addCriterion("skillbody like", value, "skillbody");
            return (Criteria) this;
        }

        public Criteria andSkillbodyNotLike(String value) {
            addCriterion("skillbody not like", value, "skillbody");
            return (Criteria) this;
        }

        public Criteria andSkillbodyIn(List<String> values) {
            addCriterion("skillbody in", values, "skillbody");
            return (Criteria) this;
        }

        public Criteria andSkillbodyNotIn(List<String> values) {
            addCriterion("skillbody not in", values, "skillbody");
            return (Criteria) this;
        }

        public Criteria andSkillbodyBetween(String value1, String value2) {
            addCriterion("skillbody between", value1, value2, "skillbody");
            return (Criteria) this;
        }

        public Criteria andSkillbodyNotBetween(String value1, String value2) {
            addCriterion("skillbody not between", value1, value2, "skillbody");
            return (Criteria) this;
        }

        public Criteria andSkillimgIsNull() {
            addCriterion("skillimg is null");
            return (Criteria) this;
        }

        public Criteria andSkillimgIsNotNull() {
            addCriterion("skillimg is not null");
            return (Criteria) this;
        }

        public Criteria andSkillimgEqualTo(String value) {
            addCriterion("skillimg =", value, "skillimg");
            return (Criteria) this;
        }

        public Criteria andSkillimgNotEqualTo(String value) {
            addCriterion("skillimg <>", value, "skillimg");
            return (Criteria) this;
        }

        public Criteria andSkillimgGreaterThan(String value) {
            addCriterion("skillimg >", value, "skillimg");
            return (Criteria) this;
        }

        public Criteria andSkillimgGreaterThanOrEqualTo(String value) {
            addCriterion("skillimg >=", value, "skillimg");
            return (Criteria) this;
        }

        public Criteria andSkillimgLessThan(String value) {
            addCriterion("skillimg <", value, "skillimg");
            return (Criteria) this;
        }

        public Criteria andSkillimgLessThanOrEqualTo(String value) {
            addCriterion("skillimg <=", value, "skillimg");
            return (Criteria) this;
        }

        public Criteria andSkillimgLike(String value) {
            addCriterion("skillimg like", value, "skillimg");
            return (Criteria) this;
        }

        public Criteria andSkillimgNotLike(String value) {
            addCriterion("skillimg not like", value, "skillimg");
            return (Criteria) this;
        }

        public Criteria andSkillimgIn(List<String> values) {
            addCriterion("skillimg in", values, "skillimg");
            return (Criteria) this;
        }

        public Criteria andSkillimgNotIn(List<String> values) {
            addCriterion("skillimg not in", values, "skillimg");
            return (Criteria) this;
        }

        public Criteria andSkillimgBetween(String value1, String value2) {
            addCriterion("skillimg between", value1, value2, "skillimg");
            return (Criteria) this;
        }

        public Criteria andSkillimgNotBetween(String value1, String value2) {
            addCriterion("skillimg not between", value1, value2, "skillimg");
            return (Criteria) this;
        }

        public Criteria andNeedupdatetimeIsNull() {
            addCriterion("needupdatetime is null");
            return (Criteria) this;
        }

        public Criteria andNeedupdatetimeIsNotNull() {
            addCriterion("needupdatetime is not null");
            return (Criteria) this;
        }

        public Criteria andNeedupdatetimeEqualTo(Date value) {
            addCriterion("needupdatetime =", value, "needupdatetime");
            return (Criteria) this;
        }

        public Criteria andNeedupdatetimeNotEqualTo(Date value) {
            addCriterion("needupdatetime <>", value, "needupdatetime");
            return (Criteria) this;
        }

        public Criteria andNeedupdatetimeGreaterThan(Date value) {
            addCriterion("needupdatetime >", value, "needupdatetime");
            return (Criteria) this;
        }

        public Criteria andNeedupdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("needupdatetime >=", value, "needupdatetime");
            return (Criteria) this;
        }

        public Criteria andNeedupdatetimeLessThan(Date value) {
            addCriterion("needupdatetime <", value, "needupdatetime");
            return (Criteria) this;
        }

        public Criteria andNeedupdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("needupdatetime <=", value, "needupdatetime");
            return (Criteria) this;
        }

        public Criteria andNeedupdatetimeIn(List<Date> values) {
            addCriterion("needupdatetime in", values, "needupdatetime");
            return (Criteria) this;
        }

        public Criteria andNeedupdatetimeNotIn(List<Date> values) {
            addCriterion("needupdatetime not in", values, "needupdatetime");
            return (Criteria) this;
        }

        public Criteria andNeedupdatetimeBetween(Date value1, Date value2) {
            addCriterion("needupdatetime between", value1, value2, "needupdatetime");
            return (Criteria) this;
        }

        public Criteria andNeedupdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("needupdatetime not between", value1, value2, "needupdatetime");
            return (Criteria) this;
        }

        public Criteria andSkillupdatetimeIsNull() {
            addCriterion("skillupdatetime is null");
            return (Criteria) this;
        }

        public Criteria andSkillupdatetimeIsNotNull() {
            addCriterion("skillupdatetime is not null");
            return (Criteria) this;
        }

        public Criteria andSkillupdatetimeEqualTo(Date value) {
            addCriterion("skillupdatetime =", value, "skillupdatetime");
            return (Criteria) this;
        }

        public Criteria andSkillupdatetimeNotEqualTo(Date value) {
            addCriterion("skillupdatetime <>", value, "skillupdatetime");
            return (Criteria) this;
        }

        public Criteria andSkillupdatetimeGreaterThan(Date value) {
            addCriterion("skillupdatetime >", value, "skillupdatetime");
            return (Criteria) this;
        }

        public Criteria andSkillupdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("skillupdatetime >=", value, "skillupdatetime");
            return (Criteria) this;
        }

        public Criteria andSkillupdatetimeLessThan(Date value) {
            addCriterion("skillupdatetime <", value, "skillupdatetime");
            return (Criteria) this;
        }

        public Criteria andSkillupdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("skillupdatetime <=", value, "skillupdatetime");
            return (Criteria) this;
        }

        public Criteria andSkillupdatetimeIn(List<Date> values) {
            addCriterion("skillupdatetime in", values, "skillupdatetime");
            return (Criteria) this;
        }

        public Criteria andSkillupdatetimeNotIn(List<Date> values) {
            addCriterion("skillupdatetime not in", values, "skillupdatetime");
            return (Criteria) this;
        }

        public Criteria andSkillupdatetimeBetween(Date value1, Date value2) {
            addCriterion("skillupdatetime between", value1, value2, "skillupdatetime");
            return (Criteria) this;
        }

        public Criteria andSkillupdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("skillupdatetime not between", value1, value2, "skillupdatetime");
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