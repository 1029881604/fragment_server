package team.antelope.fg.pojo;

import java.util.Date;

public class CommentReply {
    private Long id;

    private Long commentId;

    private Short replyType;

    private Long replyId;

    private String content;

    private Long toUid;

    private Long fromUid;

    private String fromUserHeadimg;

    private String fromNickname;

    private Date createTime;

    private String toNickname;

    private Boolean isAuthor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Short getReplyType() {
        return replyType;
    }

    public void setReplyType(Short replyType) {
        this.replyType = replyType;
    }

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getToUid() {
        return toUid;
    }

    public void setToUid(Long toUid) {
        this.toUid = toUid;
    }

    public Long getFromUid() {
        return fromUid;
    }

    public void setFromUid(Long fromUid) {
        this.fromUid = fromUid;
    }

    public String getFromUserHeadimg() {
        return fromUserHeadimg;
    }

    public void setFromUserHeadimg(String fromUserHeadimg) {
        this.fromUserHeadimg = fromUserHeadimg == null ? null : fromUserHeadimg.trim();
    }

    public String getFromNickname() {
        return fromNickname;
    }

    public void setFromNickname(String fromNickname) {
        this.fromNickname = fromNickname == null ? null : fromNickname.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getToNickname() {
        return toNickname;
    }

    public void setToNickname(String toNickname) {
        this.toNickname = toNickname == null ? null : toNickname.trim();
    }

    public Boolean getIsAuthor() {
        return isAuthor;
    }

    public void setIsAuthor(Boolean isAuthor) {
        this.isAuthor = isAuthor;
    }
}