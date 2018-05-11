package team.antelope.fg.dao;


import java.util.List;

import team.antelope.fg.entity.PersonNeed;
import team.antelope.fg.entity.PublishNeed;

public interface IPublishNeedDao extends IBaseDao<PublishNeed> {
    List<PublishNeed> queryAllPublishNeed();  
    int queryTotalRecords();    
    List <PublishNeed> queryAllPublishNeed(int from, int to);
    
    /**
	 * lry��� ��ѯ���еĸ�����Ϣ������
	 * @return
	 */
	List<PersonNeed> queryAllPersonNeed();
}
