package team.antelope.fg.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.antelope.fg.biz.IAttentionService;
import team.antelope.fg.mapper.AttentionMapper;
import team.antelope.fg.pojo.AttentionExample;
import team.antelope.fg.pojo.AttentionKey;

/**
 * ��ע������
 * @author ���Ĳ�
 * @time:2018��5��18�� ����4:27:06
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
