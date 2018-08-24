package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wei.jiang
 * @since 2018/8/23
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User queryById(String id) {
        return userDao.queryById(id);
    }

    @Override
    public List<User> queryByRegionId(int regionId) {
        return userDao.queryByRegionId(regionId);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }
}
