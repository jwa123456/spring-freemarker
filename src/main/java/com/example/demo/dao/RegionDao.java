package com.example.demo.dao;

import com.example.demo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author wei.jiang
 * @since 2018/8/23
 */
public interface RegionDao extends JpaRepository<Region, String> {


    Region queryById(int id);


    List<Region> queryByParentRegionId(int parentId);

    @Query(value = "select id,region_name,parent_region_id,create_time,update_time from region where parent_region_id=0", nativeQuery = true)
    List<Region> queryParentId();
}
