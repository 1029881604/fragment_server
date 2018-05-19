package team.antelope.fg.biz;

import java.util.List;

import team.antelope.fg.pojo.expand.NeedExpand;
import team.antelope.fg.pojo.vo.NeedVo;
/**
 * Nearbyģ������ҵ����
 * @author ���Ĳ�
 * @time:2018��5��14�� ����10:49:06
 * @Description:TODO
 */
public interface INeedService {
	/**
	 * ��ȡ����������Ԥ����Ϣ�б�
	 * @param type
	 * @param latitude
	 * @param longitude
	 * @return 
	 * List<NeedPreInfo>
	 */
	List<NeedExpand> getNearbyNeedPreInfos(String type, Double latitude,
			Double longitude, NeedVo needVo);
	/**
	 * ��ȡ������Ϣ֮ǰҪ��������󷢲�ʱ�ľ���
	 * ��ҵ���߼�
	 * @param id
	 * @return 
	 * NeedExpand
	 */
	NeedExpand getNeedInfoById(Long id, Double latitude, Double longitude);
	/**
	 * �����û�id��ȡ��������
	 * ���ﲻ���þ���֮��ģ� ֻ��ʾrequestdate��addressdesc/iscomplete/title
	 * ��ҵ���߼�
	 * @param id
	 * @return 
	 * NeedExpand
	 */
	List<NeedExpand> getNeedInfosByPerson(Long uid, NeedVo needVo) throws Exception;
}
