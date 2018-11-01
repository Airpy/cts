package com.amio.cts.controller;

import com.amio.cts.common.Response;
import com.amio.cts.domain.SysUser;
import com.amio.cts.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);
    private final SysUserService sysUserService;

    @Autowired
    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @PostMapping(path = "")
    public Response createUser(SysUser sysUser) {
        logger.info("Creating Sys User: {}", sysUser);
        if (!sysUserService.isUserExist(sysUser)) {
            return this.sysUserService.createUser(sysUser);
        }
        return null;
    }

    @DeleteMapping(path = "/{id}")
    public Response deleteUser(@PathVariable int id) {
        logger.info("Deleting Sys User, id is {}", id);
        return this.sysUserService.deleteUser(id);
    }

    @PutMapping(path = "/{userId}",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void updateUser(SysUser sysUser, @PathVariable int userId) {
        SysUser user = this.sysUserService.findUserById(userId);
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
