package team.antelope.fg.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NeedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NeedExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Long value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Long value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Long value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Long value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Long value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Long value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Long> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Long> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Long value1, Long value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Long value1, Long value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andNeedtypeIsNull() {
            addCriterion("needtype is null");
            return (Criteria) this;
        }

        public Criteria andNeedtypeIsNotNull() {
            addCriterion("needtype is not null");
            return (Criteria) this;
        }

        public Criteria andNeedtypeEqualTo(String value) {
            addCriterion("needtype =", value, "needtype");
            return (Criteria) this;
        }

        public Criteria andNeedtypeNotEqualTo(String value) {
            addCriterion("needtype <>", value, "needtype");
            return (Criteria) this;
        }

        public Criteria andNeedtypeGreaterThan(String value) {
            addCriterion("needtype >", value, "needtype");
            return (Criteria) this;
        }

        public Criteria andNeedtypeGreaterThanOrEqualTo(String value) {
            addCriterion("needtype >=", value, "needtype");
            return (Criteria) this;
        }

        public Criteria andNeedtypeLessThan(String value) {
            addCriterion("needtype <", value, "needtype");
            return (Criteria) this;
        }

        public Criteria andNeedtypeLessThanOrEqualTo(String value) {
            addCriterion("needtype <=", value, "needtype");
            return (Criteria) this;
        }

        public Criteria andNeedtypeLike(String value) {
            addCriterion("needtype like", value, "needtype");
            return (Criteria) this;
        }

        public Criteria andNeedtypeNotLike(String value) {
            addCriterion("needtype not like", value, "needtype");
            return (Criteria) this;
        }

        public Criteria andNeedtypeIn(List<String> values) {
            addCriterion("needtype in", values, "needtype");
            return (Criteria) this;
        }

        public Criteria andNeedtypeNotIn(List<String> values) {
            addCriterion("needtype not in", values, "needtype");
            return (Criteria) this;
        }

        public Criteria andNeedtypeBetween(String value1, String value2) {
            addCriterion("needtype between", value1, value2, "needtype");
            return (Criteria) this;
        }

        public Criteria andNeedtypeNotBetween(String value1, String value2) {
            addCriterion("needtype not between", value1, value2, "needtype");
            return (Criteria) this;
        }

        public Criteria andCustomdateIsNull() {
            addCriterion("customdate is null");
            return (Criteria) this;
        }

        public Criteria andCustomdateIsNotNull() {
            addCriterion("customdate is not null");
            return (Criteria) this;
        }

        public Criteria andCustomdateEqualTo(Date value) {
            addCriterion("customdate =", value, "customdate");
            return (Criteria) this;
        }

        public Criteria andCustomdateNotEqualTo(Date value) {
            addCriterion("customdate <>", value, "customdate");
            return (Criteria) this;
        }

        public Criteria andCustomdateGreaterThan(Date value) {
            addCriterion("customdate >", value, "customdate");
            return (Criteria) this;
        }

        public Criteria andCustomdateGreaterThanOrEqualTo(Date value) {
            addCriterion("customdate >=", value, "customdate");
            return (Criteria) this;
        }

        public Criteria andCustomdateLessThan(Date value) {
            addCriterion("customdate <", value, "customdate");
            return (Criteria) this;
        }

        public Criteria andCustomdateLessThanOrEqualTo(Date value) {
            addCriterion("customdate <=", value, "customdate");
            return (Criteria) this;
        }

        public Criteria andCustomdateIn(List<Date> values) {
            addCriterion("customdate in", values, "customdate");
            return (Criteria) this;
        }

        public Criteria andCustomdateNotIn(List<Date> values) {
            addCriterion("customdate not in", values, "customdate");
            return (Criteria) this;
        }

        public Criteria andCustomdateBetween(Date value1, Date value2) {
            addCriterion("customdate between", value1, value2, "customdate");
            return (Criteria) this;
        }

        public Criteria andCustomdateNotBetween(Date value1, Date value2) {
            addCriterion("customdate not between", value1, value2, "customdate");
            return (Criteria) this;
        }

        public Criteria andRequestdateIsNull() {
            addCriterion("requestdate is null");
            return (Criteria) this;
        }

        public Criteria andRequestdateIsNotNull() {
            addCriterion("requestdate is not null");
            return (Criteria) this;
        }

        public Criteria andRequestdateEqualTo(Date value) {
            addCriterion("requestdate =", value, "requestdate");
            return (Criteria) this;
        }

        public Criteria andRequestdateNotEqualTo(Date value) {
            addCriterion("requestdate <>", value, "requestdate");
            return (Criteria) this;
        }

        public Criteria andRequestdateGreaterThan(Date value) {
            addCriterion("requestdate >", value, "requestdate");
            return (Criteria) this;
        }

        public Criteria andRequestdateGreaterThanOrEqualTo(Date value) {
            addCriterion("requestdate >=", value, "requestdate");
            return (Criteria) this;
        }

        public Criteria andRequestdateLessThan(Date value) {
            addCriterion("requestdate <", value, "requestdate");
            return (Criteria) this;
        }

        public Criteria andRequestdateLessThanOrEqualTo(Date value) {
            addCriterion("requestdate <=", value, "requestdate");
            return (Criteria) this;
        }

        public Criteria andRequestdateIn(List<Date> values) {
            addCriterion("requestdate in", values, "requestdate");
            return (Criteria) this;
        }

        public Criteria andRequestdateNotIn(List<Date> values) {
            addCriterion("requestdate not in", values, "requestdate");
            return (Criteria) this;
        }

        public Criteria andRequestdateBetween(Date value1, Date value2) {
            addCriterion("requestdate between", value1, value2, "requestdate");
            return (Criteria) this;
        }

        public Criteria andRequestdateNotBetween(Date value1, Date value2) {
            addCriterion("requestdate not between", value1, value2, "requestdate");
            return (Criteria) this;
        }

        public Criteria andIscompleteIsNull() {
            addCriterion("iscomplete is null");
            return (Criteria) this;
        }

        public Criteria andIscompleteIsNotNull() {
            addCriterion("iscomplete is not null");
            return (Criteria) this;
        }

        public Criteria andIscompleteEqualTo(Boolean value) {
            addCriterion("iscomplete =", value, "iscomplete");
            return (Criteria) this;
        }

        public Criteria andIscompleteNotEqualTo(Boolean value) {
            addCriterion("iscomplete <>", value, "iscomplete");
            return (Criteria) this;
        }

        public Criteria andIscompleteGreaterThan(Boolean value) {
            addCriterion("iscomplete >", value, "iscomplete");
            return (Criteria) this;
        }

        public Criteria andIscompleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("iscomplete >=", value, "iscomplete");
            return (Criteria) this;
        }

        public Criteria andIscompleteLessThan(Boolean value) {
            addCriterion("iscomplete <", value, "iscomplete");
            return (Criteria) this;
        }

        public Criteria andIscompleteLessThanOrEqualTo(Boolean value) {
            addCriterion("iscomplete <=", value, "iscomplete");
            return (Criteria) this;
        }

        public Criteria andIscompleteIn(List<Boolean> values) {
            addCriterion("iscomplete in", values, "iscomplete");
            return (Criteria) this;
        }

        public Criteria andIscompleteNotIn(List<Boolean> values) {
            addCriterion("iscomplete not in", values, "iscomplete");
            return (Criteria) this;
        }

        public Criteria andIscompleteBetween(Boolean value1, Boolean value2) {
            addCriterion("iscomplete between", value1, value2, "iscomplete");
            return (Criteria) this;
        }

        public Criteria andIscompleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("iscomplete not between", value1, value2, "iscomplete");
            return (Criteria) this;
        }

        public Criteria andIsonlineIsNull() {
            addCriterion("isonline is null");
            return (Criteria) this;
        }

        public Criteria andIsonlineIsNotNull() {
            addCriterion("isonline is not null");
            return (Criteria) this;
        }

        public Criteria andIsonlineEqualTo(Boolean value) {
            addCriterion("isonline =", value, "isonline");
            return (Criteria) this;
        }

        public Criteria andIsonlineNotEqualTo(Boolean value) {
            addCriterion("isonline <>", value, "isonline");
            return (Criteria) this;
        }

        public Criteria andIsonlineGreaterThan(Boolean value) {
            addCriterion("isonline >", value, "isonline");
            return (Criteria) this;
        }

        public Criteria andIsonlineGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isonline >=", value, "isonline");
            return (Criteria) this;
        }

        public Criteria andIsonlineLessThan(Boolean value) {
            addCriterion("isonline <", value, "isonline");
            return (Criteria) this;
        }

        public Criteria andIsonlineLessThanOrEqualTo(Boolean value) {
            addCriterion("isonline <=", value, "isonline");
            return (Criteria) this;
        }

        public Criteria andIsonlineIn(List<Boolean> values) {
            addCriterion("isonline in", values, "isonline");
            return (Criteria) this;
        }

        public Criteria andIsonlineNotIn(List<Boolean> values) {
            addCriterion("isonline not in", values, "isonline");
            return (Criteria) this;
        }

        public Criteria andIsonlineBetween(Boolean value1, Boolean value2) {
            addCriterion("isonline between", value1, value2, "isonline");
            return (Criteria) this;
        }

        public Criteria andIsonlineNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isonline not between", value1, value2, "isonline");
            return (Criteria) this;
        }

        public Criteria andAddressdescIsNull() {
            addCriterion("addressdesc is null");
            return (Criteria) this;
        }

        public Criteria andAddressdescIsNotNull() {
            addCriterion("addressdesc is not null");
            return (Criteria) this;
        }

        public Criteria andAddressdescEqualTo(String value) {
            addCriterion("addressdesc =", value, "addressdesc");
            return (Criteria) this;
        }

        public Criteria andAddressdescNotEqualTo(String value) {
            addCriterion("addressdesc <>", value, "addressdesc");
            return (Criteria) this;
        }

        public Criteria andAddressdescGreaterThan(String value) {
            addCriterion("addressdesc >", value, "addressdesc");
            return (Criteria) this;
        }

        public Criteria andAddressdescGreaterThanOrEqualTo(String value) {
            addCriterion("addressdesc >=", value, "addressdesc");
            return (Criteria) this;
        }

        public Criteria andAddressdescLessThan(String value) {
            addCriterion("addressdesc <", value, "addressdesc");
            return (Criteria) this;
        }

        public Criteria andAddressdescLessThanOrEqualTo(String value) {
            addCriterion("addressdesc <=", value, "addressdesc");
            return (Criteria) this;
        }

        public Criteria andAddressdescLike(String value) {
            addCriterion("addressdesc like", value, "addressdesc");
            return (Criteria) this;
        }

        public Criteria andAddressdescNotLike(String value) {
            addCriterion("addressdesc not like", value, "addressdesc");
            return (Criteria) this;
        }

        public Criteria andAddressdescIn(List<String> values) {
            addCriterion("addressdesc in", values, "addressdesc");
            return (Criteria) this;
        }

        public Criteria andAddressdescNotIn(List<String> values) {
            addCriterion("addressdesc not in", values, "addressdesc");
            return (Criteria) this;
        }

        public Criteria andAddressdescBetween(String value1, String value2) {
            addCriterion("addressdesc between", value1, value2, "addressdesc");
            return (Criteria) this;
        }

        public Criteria andAddressdescNotBetween(String value1, String value2) {
            addCriterion("addressdesc not between", value1, value2, "addressdesc");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(Double value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(Double value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(Double value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(Double value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(Double value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<Double> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<Double> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(Double value1, Double value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(Double value1, Double value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Double value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Double value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Double value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Double value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Double> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Double> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Double value1, Double value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
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