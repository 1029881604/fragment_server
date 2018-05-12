package team.antelope.fg.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentReplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentReplyExample() {
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

        public Criteria andCommentIdIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Long value) {
            addCriterion("comment_id =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Long value) {
            addCriterion("comment_id <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Long value) {
            addCriterion("comment_id >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_id >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Long value) {
            addCriterion("comment_id <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Long value) {
            addCriterion("comment_id <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Long> values) {
            addCriterion("comment_id in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Long> values) {
            addCriterion("comment_id not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Long value1, Long value2) {
            addCriterion("comment_id between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Long value1, Long value2) {
            addCriterion("comment_id not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andReplyTypeIsNull() {
            addCriterion("reply_type is null");
            return (Criteria) this;
        }

        public Criteria andReplyTypeIsNotNull() {
            addCriterion("reply_type is not null");
            return (Criteria) this;
        }

        public Criteria andReplyTypeEqualTo(Short value) {
            addCriterion("reply_type =", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeNotEqualTo(Short value) {
            addCriterion("reply_type <>", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeGreaterThan(Short value) {
            addCriterion("reply_type >", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("reply_type >=", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeLessThan(Short value) {
            addCriterion("reply_type <", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeLessThanOrEqualTo(Short value) {
            addCriterion("reply_type <=", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeIn(List<Short> values) {
            addCriterion("reply_type in", values, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeNotIn(List<Short> values) {
            addCriterion("reply_type not in", values, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeBetween(Short value1, Short value2) {
            addCriterion("reply_type between", value1, value2, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeNotBetween(Short value1, Short value2) {
            addCriterion("reply_type not between", value1, value2, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyIdIsNull() {
            addCriterion("reply_id is null");
            return (Criteria) this;
        }

        public Criteria andReplyIdIsNotNull() {
            addCriterion("reply_id is not null");
            return (Criteria) this;
        }

        public Criteria andReplyIdEqualTo(Long value) {
            addCriterion("reply_id =", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotEqualTo(Long value) {
            addCriterion("reply_id <>", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdGreaterThan(Long value) {
            addCriterion("reply_id >", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("reply_id >=", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdLessThan(Long value) {
            addCriterion("reply_id <", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdLessThanOrEqualTo(Long value) {
            addCriterion("reply_id <=", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdIn(List<Long> values) {
            addCriterion("reply_id in", values, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotIn(List<Long> values) {
            addCriterion("reply_id not in", values, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdBetween(Long value1, Long value2) {
            addCriterion("reply_id between", value1, value2, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotBetween(Long value1, Long value2) {
            addCriterion("reply_id not between", value1, value2, "replyId");
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

        public Criteria andToUidIsNull() {
            addCriterion("to_uid is null");
            return (Criteria) this;
        }

        public Criteria andToUidIsNotNull() {
            addCriterion("to_uid is not null");
            return (Criteria) this;
        }

        public Criteria andToUidEqualTo(Long value) {
            addCriterion("to_uid =", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidNotEqualTo(Long value) {
            addCriterion("to_uid <>", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidGreaterThan(Long value) {
            addCriterion("to_uid >", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidGreaterThanOrEqualTo(Long value) {
            addCriterion("to_uid >=", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidLessThan(Long value) {
            addCriterion("to_uid <", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidLessThanOrEqualTo(Long value) {
            addCriterion("to_uid <=", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidIn(List<Long> values) {
            addCriterion("to_uid in", values, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidNotIn(List<Long> values) {
            addCriterion("to_uid not in", values, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidBetween(Long value1, Long value2) {
            addCriterion("to_uid between", value1, value2, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidNotBetween(Long value1, Long value2) {
            addCriterion("to_uid not between", value1, value2, "toUid");
            return (Criteria) this;
        }

        public Criteria andFromUidIsNull() {
            addCriterion("from_uid is null");
            return (Criteria) this;
        }

        public Criteria andFromUidIsNotNull() {
            addCriterion("from_uid is not null");
            return (Criteria) this;
        }

        public Criteria andFromUidEqualTo(Long value) {
            addCriterion("from_uid =", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidNotEqualTo(Long value) {
            addCriterion("from_uid <>", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidGreaterThan(Long value) {
            addCriterion("from_uid >", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidGreaterThanOrEqualTo(Long value) {
            addCriterion("from_uid >=", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidLessThan(Long value) {
            addCriterion("from_uid <", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidLessThanOrEqualTo(Long value) {
            addCriterion("from_uid <=", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidIn(List<Long> values) {
            addCriterion("from_uid in", values, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidNotIn(List<Long> values) {
            addCriterion("from_uid not in", values, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidBetween(Long value1, Long value2) {
            addCriterion("from_uid between", value1, value2, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidNotBetween(Long value1, Long value2) {
            addCriterion("from_uid not between", value1, value2, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUserHeadimgIsNull() {
            addCriterion("from_user_headimg is null");
            return (Criteria) this;
        }

        public Criteria andFromUserHeadimgIsNotNull() {
            addCriterion("from_user_headimg is not null");
            return (Criteria) this;
        }

        public Criteria andFromUserHeadimgEqualTo(String value) {
            addCriterion("from_user_headimg =", value, "fromUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andFromUserHeadimgNotEqualTo(String value) {
            addCriterion("from_user_headimg <>", value, "fromUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andFromUserHeadimgGreaterThan(String value) {
            addCriterion("from_user_headimg >", value, "fromUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andFromUserHeadimgGreaterThanOrEqualTo(String value) {
            addCriterion("from_user_headimg >=", value, "fromUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andFromUserHeadimgLessThan(String value) {
            addCriterion("from_user_headimg <", value, "fromUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andFromUserHeadimgLessThanOrEqualTo(String value) {
            addCriterion("from_user_headimg <=", value, "fromUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andFromUserHeadimgLike(String value) {
            addCriterion("from_user_headimg like", value, "fromUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andFromUserHeadimgNotLike(String value) {
            addCriterion("from_user_headimg not like", value, "fromUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andFromUserHeadimgIn(List<String> values) {
            addCriterion("from_user_headimg in", values, "fromUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andFromUserHeadimgNotIn(List<String> values) {
            addCriterion("from_user_headimg not in", values, "fromUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andFromUserHeadimgBetween(String value1, String value2) {
            addCriterion("from_user_headimg between", value1, value2, "fromUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andFromUserHeadimgNotBetween(String value1, String value2) {
            addCriterion("from_user_headimg not between", value1, value2, "fromUserHeadimg");
            return (Criteria) this;
        }

        public Criteria andFromNicknameIsNull() {
            addCriterion("from_nickname is null");
            return (Criteria) this;
        }

        public Criteria andFromNicknameIsNotNull() {
            addCriterion("from_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andFromNicknameEqualTo(String value) {
            addCriterion("from_nickname =", value, "fromNickname");
            return (Criteria) this;
        }

        public Criteria andFromNicknameNotEqualTo(String value) {
            addCriterion("from_nickname <>", value, "fromNickname");
            return (Criteria) this;
        }

        public Criteria andFromNicknameGreaterThan(String value) {
            addCriterion("from_nickname >", value, "fromNickname");
            return (Criteria) this;
        }

        public Criteria andFromNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("from_nickname >=", value, "fromNickname");
            return (Criteria) this;
        }

        public Criteria andFromNicknameLessThan(String value) {
            addCriterion("from_nickname <", value, "fromNickname");
            return (Criteria) this;
        }

        public Criteria andFromNicknameLessThanOrEqualTo(String value) {
            addCriterion("from_nickname <=", value, "fromNickname");
            return (Criteria) this;
        }

        public Criteria andFromNicknameLike(String value) {
            addCriterion("from_nickname like", value, "fromNickname");
            return (Criteria) this;
        }

        public Criteria andFromNicknameNotLike(String value) {
            addCriterion("from_nickname not like", value, "fromNickname");
            return (Criteria) this;
        }

        public Criteria andFromNicknameIn(List<String> values) {
            addCriterion("from_nickname in", values, "fromNickname");
            return (Criteria) this;
        }

        public Criteria andFromNicknameNotIn(List<String> values) {
            addCriterion("from_nickname not in", values, "fromNickname");
            return (Criteria) this;
        }

        public Criteria andFromNicknameBetween(String value1, String value2) {
            addCriterion("from_nickname between", value1, value2, "fromNickname");
            return (Criteria) this;
        }

        public Criteria andFromNicknameNotBetween(String value1, String value2) {
            addCriterion("from_nickname not between", value1, value2, "fromNickname");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andToNicknameIsNull() {
            addCriterion("to_nickname is null");
            return (Criteria) this;
        }

        public Criteria andToNicknameIsNotNull() {
            addCriterion("to_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andToNicknameEqualTo(String value) {
            addCriterion("to_nickname =", value, "toNickname");
            return (Criteria) this;
        }

        public Criteria andToNicknameNotEqualTo(String value) {
            addCriterion("to_nickname <>", value, "toNickname");
            return (Criteria) this;
        }

        public Criteria andToNicknameGreaterThan(String value) {
            addCriterion("to_nickname >", value, "toNickname");
            return (Criteria) this;
        }

        public Criteria andToNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("to_nickname >=", value, "toNickname");
            return (Criteria) this;
        }

        public Criteria andToNicknameLessThan(String value) {
            addCriterion("to_nickname <", value, "toNickname");
            return (Criteria) this;
        }

        public Criteria andToNicknameLessThanOrEqualTo(String value) {
            addCriterion("to_nickname <=", value, "toNickname");
            return (Criteria) this;
        }

        public Criteria andToNicknameLike(String value) {
            addCriterion("to_nickname like", value, "toNickname");
            return (Criteria) this;
        }

        public Criteria andToNicknameNotLike(String value) {
            addCriterion("to_nickname not like", value, "toNickname");
            return (Criteria) this;
        }

        public Criteria andToNicknameIn(List<String> values) {
            addCriterion("to_nickname in", values, "toNickname");
            return (Criteria) this;
        }

        public Criteria andToNicknameNotIn(List<String> values) {
            addCriterion("to_nickname not in", values, "toNickname");
            return (Criteria) this;
        }

        public Criteria andToNicknameBetween(String value1, String value2) {
            addCriterion("to_nickname between", value1, value2, "toNickname");
            return (Criteria) this;
        }

        public Criteria andToNicknameNotBetween(String value1, String value2) {
            addCriterion("to_nickname not between", value1, value2, "toNickname");
            return (Criteria) this;
        }

        public Criteria andIsAuthorIsNull() {
            addCriterion("is_author is null");
            return (Criteria) this;
        }

        public Criteria andIsAuthorIsNotNull() {
            addCriterion("is_author is not null");
            return (Criteria) this;
        }

        public Criteria andIsAuthorEqualTo(Boolean value) {
            addCriterion("is_author =", value, "isAuthor");
            return (Criteria) this;
        }

        public Criteria andIsAuthorNotEqualTo(Boolean value) {
            addCriterion("is_author <>", value, "isAuthor");
            return (Criteria) this;
        }

        public Criteria andIsAuthorGreaterThan(Boolean value) {
            addCriterion("is_author >", value, "isAuthor");
            return (Criteria) this;
        }

        public Criteria andIsAuthorGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_author >=", value, "isAuthor");
            return (Criteria) this;
        }

        public Criteria andIsAuthorLessThan(Boolean value) {
            addCriterion("is_author <", value, "isAuthor");
            return (Criteria) this;
        }

        public Criteria andIsAuthorLessThanOrEqualTo(Boolean value) {
            addCriterion("is_author <=", value, "isAuthor");
            return (Criteria) this;
        }

        public Criteria andIsAuthorIn(List<Boolean> values) {
            addCriterion("is_author in", values, "isAuthor");
            return (Criteria) this;
        }

        public Criteria andIsAuthorNotIn(List<Boolean> values) {
            addCriterion("is_author not in", values, "isAuthor");
            return (Criteria) this;
        }

        public Criteria andIsAuthorBetween(Boolean value1, Boolean value2) {
            addCriterion("is_author between", value1, value2, "isAuthor");
            return (Criteria) this;
        }

        public Criteria andIsAuthorNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_author not between", value1, value2, "isAuthor");
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