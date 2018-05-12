package team.antelope.fg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import team.antelope.fg.pojo.Skill;
import team.antelope.fg.pojo.SkillExample;

public interface SkillMapper {
    long countByExample(SkillExample example);

    int deleteByExample(SkillExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Skill record);

    int insertSelective(Skill record);

    List<Skill> selectByExampleWithBLOBs(SkillExample example);

    List<Skill> selectByExample(SkillExample example);

    Skill selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Skill record, @Param("example") SkillExample example);

    int updateByExampleWithBLOBs(@Param("record") Skill record, @Param("example") SkillExample example);

    int updateByExample(@Param("record") Skill record, @Param("example") SkillExample example);

    int updateByPrimaryKeySelective(Skill record);

    int updateByPrimaryKeyWithBLOBs(Skill record);

    int updateByPrimaryKey(Skill record);
}