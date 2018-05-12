package team.antelope.fg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import team.antelope.fg.pojo.Need;
import team.antelope.fg.pojo.NeedExample;

public interface NeedMapper {
    long countByExample(NeedExample example);

    int deleteByExample(NeedExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Need record);

    int insertSelective(Need record);

    List<Need> selectByExample(NeedExample example);

    Need selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Need record, @Param("example") NeedExample example);

    int updateByExample(@Param("record") Need record, @Param("example") NeedExample example);

    int updateByPrimaryKeySelective(Need record);

    int updateByPrimaryKey(Need record);
}