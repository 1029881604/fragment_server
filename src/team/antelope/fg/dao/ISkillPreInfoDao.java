package team.antelope.fg.dao;

import java.util.List;

import team.antelope.fg.entity.NeedPreInfo;
import team.antelope.fg.entity.SkillPreInfo;

public interface ISkillPreInfoDao extends IInfoBaseDao<SkillPreInfo> {
    List<SkillPreInfo> queryAllSkillInfo();    
    int queryTotalRecords();    
    List <SkillPreInfo> queryAllSkillInfo(int from, int to);
    List <SkillPreInfo> queryNearbyInfos(String type, double latitude, double longitude);
}
