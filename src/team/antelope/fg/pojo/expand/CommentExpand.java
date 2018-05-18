package team.antelope.fg.pojo.expand;

import team.antelope.fg.pojo.Comment;

/**
 * 评论拓展类， 现在暂时没有这么多需求， comment表冗余字段已经够用了
 * @author 华文财
 * @time:2018年5月16日 上午9:43:15
 * @Description:TODO
 */
public class CommentExpand extends Comment {
	//biz  业务拓展
	private String createTimeStr;

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	
}
