package cn.jinronga.controller;

import cn.jinronga.entity.User;
import cn.jinronga.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserController
 * @Author guojinrong
 * @Date 2020/12/31 16:49
 * @Description UserController
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @GetMapping("{id}")
    @ResponseBody
    public User getUserInfo(@PathVariable int id) {
        return userService.getUserInfo(id);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<User> getUserInfo() {
        return userService.getAllUsers();
    }
}
