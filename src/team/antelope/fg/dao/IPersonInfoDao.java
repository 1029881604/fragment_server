package team.antelope.fg.dao;

import java.util.List;

import team.antelope.fg.entity.PersonInfo;

public interface IPersonInfoDao extends IInfoBaseDao<PersonInfo> {
    List<PersonInfo> queryAllPersonInfo();    
    int queryTotalRecords();    
    List <PersonInfo> queryAllPersonInfo(int from, int to);
}
