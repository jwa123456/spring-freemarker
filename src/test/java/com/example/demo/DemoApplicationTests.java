package com.example.demo;

import com.example.demo.dao.RegionDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Region;
import com.example.demo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RegionDao regionDao;

    @Test
    public void testUserInsert() {
        User user = new User();
        user.setAge(11);
        user.setUserName("aaaa");
        user.setEmail("eefffff");
        user.setComment("asdfasdfsad");
        user.setRegionId(110000);
        user = userDao.save(user);
        user.setUserName("bbbbbb");
        user = userDao.save(user);
        System.out.println(user.getId());
        User user1 = userDao.queryById(user.getId());
        Assert.assertEquals("bbbbbb", user1.getUserName());
    }

    @Test
    public void testRegion() {
        List<Region> regions = regionDao.queryParentId();
        System.out.println(regions.get(0).getId());
        Region region = regionDao.queryById(310000);
        System.out.println(region.getRegionName());
    }


//    @Test
//    public void testInsertRegionUser() {
//        List<Region> list = regionDao.findAll();
//        List<Integer> collect = list.stream().filter(e -> e.getParentRegionId() != 0).map(Region::getId).sorted(Integer::compareTo).collect(Collectors.toList());
//        Random random = new Random();
//        int size = collect.size();
//        int first = collect.get(size - 1) - size;
//        System.out.println(first + "------>" + size);
//        int randomInt = random.nextInt(size) + first;
//
//    }

}
