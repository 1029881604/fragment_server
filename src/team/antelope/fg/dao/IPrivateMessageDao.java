package team.antelope.fg.dao;


import java.util.List;

import team.antelope.fg.entity.PrivateMessage;
import team.antelope.fg.entity.PublicMessage;


public interface IPrivateMessageDao extends IBaseDao<PrivateMessage> {
    List<PrivateMessage> queryAllPrivateMessage();    
    int queryTotalRecords();    
    List <PrivateMessage> queryAllPrivateMessage(int from, int to);
    List<PrivateMessage> queryBySenderId(long senderId);
}
