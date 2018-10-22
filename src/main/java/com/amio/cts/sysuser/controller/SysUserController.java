package com.amio.cts.sysuser.controller;

import com.amio.cts.sysuser.entity.SysUser;
import com.amio.cts.sysuser.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户Controller
 *
 * @author : zhenfeng.liu
 * @date : 2018/9/4 17:24
 */
@RestController
@RequestMapping(path = "/user")
public class SysUserController {
    private final SysUserService sysUserService;

    @Autowired
    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public void createUser(SysUser sysUser) {
        this.sysUserService.createUser(sysUser);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        this.sysUserService.deleteUser(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public SysUser findUserById(@PathVariable("id") int id) {
        return this.sysUserService.findUserById(id);
    }
}
