package team.antelope.fg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import team.antelope.fg.pojo.AttentionExample;
import team.antelope.fg.pojo.AttentionKey;

public interface AttentionMapper {
    long countByExample(AttentionExample example);

    int deleteByExample(AttentionExample example);

    int deleteByPrimaryKey(AttentionKey key);

    int insert(AttentionKey record);

    int insertSelective(AttentionKey record);

    List<AttentionKey> selectByExample(AttentionExample example);

    int updateByExampleSelective(@Param("record") AttentionKey record, @Param("example") AttentionExample example);

    int updateByExample(@Param("record") AttentionKey record, @Param("example") AttentionExample example);
}