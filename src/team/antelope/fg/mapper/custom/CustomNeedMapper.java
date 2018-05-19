package team.antelope.fg.mapper.custom;

import java.util.List;

import team.antelope.fg.pojo.expand.NeedExpand;
import team.antelope.fg.pojo.vo.NeedVo;
/**
 * ����ģ���������ݷ��ʲ�
 * @author ���Ĳ�
 * @time:2018��5��14�� ����10:49:52
 * @Description:TODO
 */
public interface CustomNeedMapper {
	/**
	 * ��ȡ����������Ԥ����Ϣ�б�
	 * @param type
	 * @param latitude
	 * @param longitude
	 * @return 
	 * List<NeedVo>
	 */
	List<NeedExpand> queryNearbyInfos(NeedVo needVo);
	
	/**
	 * ���������id���ϲ�ѯneed��person�����Ϣ
	 * @param id
	 * @return 
	 * NeedExpand
	 */
	NeedExpand queryNeedInfoById(Long id);
	/**
	 * �����û���id�����ѯneed
	 * ���ܻ���ҵ�������� ����ʱ��֮��ģ��Ƿ����
	 * @param id
	 * @return 
	 * NeedExpand
	 */
	List<NeedExpand> queryNeedInfosByPerson(NeedVo needVo);
}
