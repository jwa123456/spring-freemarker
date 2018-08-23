package com.example.demo.dao;

import com.example.demo.entity.Region;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author wei.jiang
 * @since 2018/8/23
 */
@Mapper
public interface RegionDao {


    @Select("select id,region_parent_id,region_name from region where id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "parentRegionId", column = "region_parent_id"),
            @Result(property = "regionName", column = "region_name")
    })
    public Region queryById(@Param("id") int id);


    @Select("select id,region_parent_id,region_name from region where region_parent_id=#{region_parent_id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "parentRegionId", column = "region_parent_id"),
            @Result(property = "regionName", column = "region_name")
    })
    public List<Region> queryByParentId(@Param("region_parent_id") int parentId);

    @Select("select id,region_name from region where region_parent_id=NULL")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "regionName", column = "region_name")
    })
    public List<Region> queryParentId();
}
