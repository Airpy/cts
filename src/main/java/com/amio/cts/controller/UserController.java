package com.amio.cts.controller;

import com.amio.cts.domain.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String loginForm(ModelMap map) {
        map.addAttribute("user", new SysUser());
        map.addAttribute("action", "login");
        return "login";
    }
}
