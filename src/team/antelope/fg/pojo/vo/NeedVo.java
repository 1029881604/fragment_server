package team.antelope.fg.pojo.vo;

import team.antelope.fg.pojo.Need;
import team.antelope.fg.pojo.expand.NeedExpand;

/**
 * 
 * @author 华文财
 * @time:2018年5月13日 下午3:07:33
 * @Description:TODO  需求视图对象
 */
public class NeedVo {
	/**
	 * 需求实体类
	 */
	private Need need;
	/**
	 * 需求拓展pojo类
	 */
	private NeedExpand needExpand;
	
	public Need getNeed() {
		return need;
	}
	public void setNeed(Need need) {
		this.need = need;
	}
	public NeedExpand getNeedExpand() {
		return needExpand;
	}
	public void setNeedExpand(NeedExpand needExpand) {
		this.needExpand = needExpand;
	}
	
}
