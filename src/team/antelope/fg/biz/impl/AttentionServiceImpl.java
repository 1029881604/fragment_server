package team.antelope.fg.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.antelope.fg.biz.IAttentionService;
import team.antelope.fg.mapper.AttentionMapper;
import team.antelope.fg.pojo.AttentionExample;
import team.antelope.fg.pojo.AttentionExample.Criteria;
import team.antelope.fg.pojo.AttentionKey;

/**
 * 关注服务类
 * @author 华文财
 * @time:2018年5月18日 下午4:27:06
 * @Description:TODO
 */
@Service("attentionService")
public class AttentionServiceImpl implements IAttentionService {
	
	@Autowired
	private AttentionMapper attentionMapper;
	
	
	@Override
	public void followPerson(AttentionKey attention) throws Exception {
		attentionMapper.insertSelective(attention);
	}


	@Override
	public AttentionKey checkFollowStatus(AttentionKey attention) throws Exception {
		AttentionExample attentionExample = new AttentionExample();
		attentionExample.createCriteria()
				.andAttentionuseridEqualTo(attention.getAttentionuserid())
				.andUidEqualTo(attention.getUid());
		List<AttentionKey> attentions = attentionMapper.selectByExample(attentionExample);
		System.out.println("attentio:" + attention + " attentions: "+attentions);
		return  attentions.isEmpty() ? null : attentions.get(0);
	}
	

}
