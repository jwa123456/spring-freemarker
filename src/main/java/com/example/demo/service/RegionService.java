package com.example.demo.service;

import com.example.demo.entity.Region;

import java.util.List;

/**
 * @author wei.jiang
 * @since 2018/8/23
 */
public interface RegionService {

    Region queryById(int id);

    List<Region> queryByParentId(int parentId);

    List<Region> queryParentId();
}
