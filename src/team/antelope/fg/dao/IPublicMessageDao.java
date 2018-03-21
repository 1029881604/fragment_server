package team.antelope.fg.dao;


import java.util.List;

import team.antelope.fg.entity.PublicMessage;

public interface IPublicMessageDao extends IBaseDao<PublicMessage> {
    List<PublicMessage> queryAllPublicMessage();    
    int queryTotalRecords();    
    List <PublicMessage> queryAllPublicMessage(int from, int to);
}
