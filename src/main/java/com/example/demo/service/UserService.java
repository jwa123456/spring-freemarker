package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wei.jiang
 * @since 2018/8/23
 */
@Service
public interface UserService {

    User queryById(String id);

    List<User> queryByRegionId(int regionId);

    User save(User user);

}
