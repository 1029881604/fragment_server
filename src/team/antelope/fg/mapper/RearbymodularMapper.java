package team.antelope.fg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import team.antelope.fg.pojo.Rearbymodular;
import team.antelope.fg.pojo.RearbymodularExample;

public interface RearbymodularMapper {
    long countByExample(RearbymodularExample example);

    int deleteByExample(RearbymodularExample example);

    int deleteByPrimaryKey(String type);

    int insert(Rearbymodular record);

    int insertSelective(Rearbymodular record);

    List<Rearbymodular> selectByExample(RearbymodularExample example);

    Rearbymodular selectByPrimaryKey(String type);

    int updateByExampleSelective(@Param("record") Rearbymodular record, @Param("example") RearbymodularExample example);

    int updateByExample(@Param("record") Rearbymodular record, @Param("example") RearbymodularExample example);

    int updateByPrimaryKeySelective(Rearbymodular record);

    int updateByPrimaryKey(Rearbymodular record);
}