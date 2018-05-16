package team.antelope.fg.pojo.vo;

import team.antelope.fg.pojo.Comment;
import team.antelope.fg.pojo.expand.CommentExpand;

/**
 * commentDTO
 * @author 华文财
 * @time:2018年5月16日 上午9:46:57
 * @Description:TODO
 */
public class CommentVo {
	
	private Comment comment;
	private CommentExpand commentExpand;
	
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public CommentExpand getCommentExpand() {
		return commentExpand;
	}
	public void setCommentExpand(CommentExpand commentExpand) {
		this.commentExpand = commentExpand;
	}
	
}
