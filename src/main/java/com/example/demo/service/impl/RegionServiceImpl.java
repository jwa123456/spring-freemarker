package com.example.demo.service.impl;

import com.example.demo.dao.RegionDao;
import com.example.demo.entity.Region;
import com.example.demo.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wei.jiang
 * @since 2018/8/23
 */
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionDao regionDao;

    @Override
    public Region queryById(int id) {
        return regionDao.queryById(id);
    }

    @Override
    public List<Region> queryByParentId(int parentId) {
        return regionDao.queryByParentRegionId(parentId);
    }

    @Override
    public List<Region> queryParentId() {
        return regionDao.queryParentId();
    }
}
