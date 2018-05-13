package team.antelope.fg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import team.antelope.fg.pojo.Nearbymodular;
import team.antelope.fg.pojo.NearbymodularExample;

public interface NearbymodularMapper {
    long countByExample(NearbymodularExample example);

    int deleteByExample(NearbymodularExample example);

    int deleteByPrimaryKey(String type);

    int insert(Nearbymodular record);

    int insertSelective(Nearbymodular record);

    List<Nearbymodular> selectByExample(NearbymodularExample example);

    Nearbymodular selectByPrimaryKey(String type);

    int updateByExampleSelective(@Param("record") Nearbymodular record, @Param("example") NearbymodularExample example);

    int updateByExample(@Param("record") Nearbymodular record, @Param("example") NearbymodularExample example);

    int updateByPrimaryKeySelective(Nearbymodular record);

    int updateByPrimaryKey(Nearbymodular record);
}