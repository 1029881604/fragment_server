package team.antelope.fg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import team.antelope.fg.pojo.CollectionSkill;
import team.antelope.fg.pojo.CollectionSkillExample;

public interface CollectionSkillMapper {
    long countByExample(CollectionSkillExample example);

    int deleteByExample(CollectionSkillExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CollectionSkill record);

    int insertSelective(CollectionSkill record);

    List<CollectionSkill> selectByExample(CollectionSkillExample example);

    CollectionSkill selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CollectionSkill record, @Param("example") CollectionSkillExample example);

    int updateByExample(@Param("record") CollectionSkill record, @Param("example") CollectionSkillExample example);

    int updateByPrimaryKeySelective(CollectionSkill record);

    int updateByPrimaryKey(CollectionSkill record);
}