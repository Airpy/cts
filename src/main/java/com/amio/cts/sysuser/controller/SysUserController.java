package com.amio.cts.sysuser.controller;

import com.amio.cts.sysuser.entity.SysUser;
import com.amio.cts.sysuser.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping(path = "")
    public void createUser(SysUser sysUser) {
        this.sysUserService.createUser(sysUser);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable int id) {
        this.sysUserService.deleteUser(id);
    }

    @PutMapping(path = "/{id}",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void updateUser(SysUser sysUser, @PathVariable int id) {
        SysUser user = this.sysUserService.findUserById(id);
        if (null != user) {
            this.sysUserService.updateUser(sysUser);
        }
    }

    @GetMapping(path = "/{id}")
    public SysUser findUserById(@PathVariable("id") int id) {
        return this.sysUserService.findUserById(id);
    }

    @GetMapping(path = "")
    public List<SysUser> findAllUsers() {
        return this.sysUserService.findAllUsers();
    }
}
