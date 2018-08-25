package com.example.demo.controller;

import com.example.demo.entity.Region;
import com.example.demo.entity.User;
import com.example.demo.service.RegionService;
import com.example.demo.service.UserService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wei.jiang
 * @since 2018/8/24
 */
@Controller
@RequestMapping(value = "/user_region/")
public class UserRegionController {

    @Autowired
    private RegionService regionService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "list_page", method = RequestMethod.GET)
    public String listPage(Model model, Integer province, Integer city, Integer region) {
        List<Region> regions = regionService.queryParentId();
        model.addAttribute("parent_region", regions);
        List<User> userList = new ArrayList<>();
        if (region != null) {
            userList = userService.queryByRegionId(region);
            model.addAttribute("user_list", userList);
            return "listPage";
        }
        if (city != null) {
            userList = userService.queryByRegionId(city);
        }
        model.addAttribute("user_list", userList);
        model.addAttribute("province_id", province);
        return "listPage";
    }

    @RequestMapping(value = "city_list", method = RequestMethod.GET)
    @ResponseBody
    public List<Region> cityList(Integer provinceId) {
        return regionService.queryByParentId(provinceId);
    }


    @RequestMapping(value = "user_info", method = RequestMethod.GET)
    public String userInfo(String id, Model model) {
        User user = userService.queryById(id);
        if (user == null) {
            user = new User();
        }
        model.addAttribute("user", user);
        if (user.getRegionId() != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            Region region = regionService.queryById(user.getRegionId());
            if (region != null) {
                Region parentRegion;
                if (region.getParentRegionId() != 0) {
                    parentRegion = regionService.queryById(region.getParentRegionId());
                    stringBuilder.append(parentRegion.getRegionName()).append(" ");
                }
                stringBuilder.append(region.getRegionName());
            }
            model.addAttribute("region", stringBuilder.toString());
        }
        return "userInfo";
    }


    @RequestMapping(value = "save_user", method = RequestMethod.POST)
    @ResponseBody
    public User saveUser(String id, int age, String userName, String email, String comment, int regionId,String createTime) throws ParseException {
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setAge(age);
        user.setRegionId(regionId);
        user.setEmail(email);
        user.setComment(comment);
        user.setCreateTime(DateUtils.parseDate(createTime,"yyyy-MM-dd HH:mm:ss"));
        return userService.save(user);
    }

}
