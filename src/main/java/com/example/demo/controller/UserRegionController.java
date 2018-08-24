package com.example.demo.controller;

import com.example.demo.entity.Region;
import com.example.demo.entity.User;
import com.example.demo.service.RegionService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
