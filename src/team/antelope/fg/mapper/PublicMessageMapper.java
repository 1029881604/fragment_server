package team.antelope.fg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import team.antelope.fg.pojo.PublicMessage;
import team.antelope.fg.pojo.PublicMessageExample;

public interface PublicMessageMapper {
    long countByExample(PublicMessageExample example);

    int deleteByExample(PublicMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PublicMessage record);

    int insertSelective(PublicMessage record);

    List<PublicMessage> selectByExample(PublicMessageExample example);

    PublicMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PublicMessage record, @Param("example") PublicMessageExample example);

    int updateByExample(@Param("record") PublicMessage record, @Param("example") PublicMessageExample example);

    int updateByPrimaryKeySelective(PublicMessage record);

    int updateByPrimaryKey(PublicMessage record);
}