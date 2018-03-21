package team.antelope.fg.dao;

import java.util.List;

import team.antelope.fg.entity.NeedPreInfo;
import team.antelope.fg.entity.PersonInfo;

public interface INeedPreInfoDao extends IInfoBaseDao<NeedPreInfo> {
    List<NeedPreInfo> queryAllNeedInfo();    
    int queryTotalRecords();    
    List <NeedPreInfo> queryAllNeedInfo(int from, int to);
    //��ȡ��������Ϣ
    List <NeedPreInfo> queryNearbyInfos(String type, double latitude, double longitude);
}
