package com.amio.cts.controller;

import com.amio.cts.domain.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户控制器
 *
 * @author : zhenfeng.liu
 * @date : 2018/9/4 17:24
 */
@Controller
@RequestMapping(path = "account")
public class UserController {
    @GetMapping(path = "/login")
    public String loginForm() {
        return "account/login";
    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute SysUser sysUser) {
        System.out.println(sysUser.getUsername());
        System.out.println(sysUser.getPassword());
        return "index";
    }

    @GetMapping(path = "/register")
    public String registerForm(ModelMap map) {
        map.addAttribute("sysUser", new SysUser());
        map.addAttribute("action", "login");
        return "account/register";
    }
}
