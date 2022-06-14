package com.example.idiom_backend.controller;

import com.example.idiom_backend.bean.IdiomBean;
import com.example.idiom_backend.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@ResponseBody
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/signUp/{username}/{password}/{sex}")
    public boolean signUp(@PathVariable("username") String username,@PathVariable("password") String password, @PathVariable("sex") Integer sex) {
        return userService.signUp(username, password, sex);
    }

    @RequestMapping("/signIn/{username}/{password}")
    public boolean signIn(@PathVariable("username") String username,@PathVariable("password") String password) {
        return userService.signIn(username, password);
    }
}
