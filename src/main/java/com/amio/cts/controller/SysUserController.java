package com.amio.cts.controller;

import com.amio.cts.common.Response;
import com.amio.cts.domain.SysUser;
import com.amio.cts.enums.SysUserErrorCode;
import com.amio.cts.exceptions.SysUserException;
import com.amio.cts.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);
    private final SysUserService sysUserService;

    @Autowired
    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @PostMapping(path = "")
    public Response createUser(SysUser sysUser) {
        logger.info("Creating Sys User: {}", sysUser);
        if (!this.sysUserService.isUserExist(sysUser)) {
            return this.sysUserService.createUser(sysUser);
        }
        return null;
    }

    @DeleteMapping(path = "/{id}")
    public Response deleteUser(@PathVariable int id) {
        logger.info("Fetching & Deleting Sys User with id {}", id);
        Response response = this.sysUserService.findUserById(id);
        if (null == response) {
            throw new SysUserException(SysUserErrorCode.USER_NOT_FOUND);
        }
        return this.sysUserService.deleteUser(id);
    }

    @PutMapping(path = "/{userId}",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void updateUser(SysUser sysUser, @PathVariable int userId) {
        logger.info("Fetching & Updating Sys User with id {}", userId);
        Response response = this.sysUserService.findUserById(userId);
        if (null == response) {
            throw new SysUserException(SysUserErrorCode.USER_NOT_FOUND);
        }
        this.sysUserService.updateUser(sysUser);
    }

    @GetMapping(path = "/{id}")
    public Response findUserById(@PathVariable("id") int id) {
        logger.info("Fetching Sys User with id {}", id);
        Response response = this.sysUserService.findUserById(id);
        if (response == null) {
            return new Response<>(null);
        }
        return response;
    }

    @GetMapping(path = "")
    public Response findAllUsers() {
        logger.info("Fetching All Sys User.");
        Response response = this.sysUserService.findAllUsers();
        if (response == null) {
            return new Response<>(null);
        }
        return response;
    }
}
