package com.amio.cts.service.impl;

import com.amio.cts.common.Response;
import com.amio.cts.enums.SysUserErrorCode;
import com.amio.cts.exceptions.SysUserException;
import com.amio.cts.repository.SysUserDao;
import com.amio.cts.domain.SysUser;
import com.amio.cts.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户接口实现
 *
 * @author : zhenfeng.liu
 * @date : 2018/9/4 17:24
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    private Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    private final SysUserDao sysUserDao;

    @Autowired
    public SysUserServiceImpl(SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }

    @Override
    public boolean isUserExist(SysUser sysUser) {
        String username = sysUser.getUsername();
        if (StringUtils.isNotBlank(username)) {
            SysUser user = sysUserDao.selectByUsername(username);
            if (null != user) {
                logger.error("Unable to create. A User with name {} already exist.", username);
                throw new SysUserException(SysUserErrorCode.USERNAME_EXISTS);
            }
        }
        return false;
    }

    @Override
    public Response createUser(SysUser sysUser) {
        String username = sysUser.getUsername();
        String password = sysUser.getPassword();
        Response<SysUser> response = new Response<>();
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            sysUser.setId(sysUserDao.getMaxId() + 1);
            sysUser.setCreateTime(response.getActionTime());
            sysUser.setLastUpdateTime(response.getActionTime());
            logger.info("create sys_user begin: " + sysUser.toString());
            this.sysUserDao.insert(sysUser);
            logger.info("create sys_user end.");
            response.setData(sysUser);
            return response;
        } else {
            response.setCode("00001");
            response.setMessage("username or password is null or whitespace.");
            logger.error("Create Sys User error: {}", response.toString());
            return response;
        }
    }

    @Override
    public Response deleteUser(int id) {
        logger.info("delete sys_user begin.");
        Response response = new Response();
        int i = this.sysUserDao.deleteByPrimaryKey(id);
        if (i == 1) {
            logger.info("delete sys_user end.");
            return response;
        } else {
            throw new RuntimeException("delete sys_user fail.");
        }
    }

    @Override
    public Response updateUser(SysUser sysUser) {
        logger.info("update sys_user begin.");
        Response response = new Response();
        sysUser.setLastUpdateTime(LocalDateTime.now());
        int i = this.sysUserDao.updateByPrimaryKeySelective(sysUser);
        if (i == 1) {
            logger.info("update sys_user end.");
            return response;
        } else {
            throw new RuntimeException("update sys_user fail.");
        }
    }

    @Override
    public Response findUserById(int id) {
        logger.info("fetch sys_user begin.");
        SysUser sysUser = this.sysUserDao.selectByPrimaryKey(id);
        if (null == sysUser) {
            logger.warn("Sys User with id {} not found.", id);
            return null;
        }
        logger.info("fetch sys_user end.");
        return new Response<>(sysUser);
    }

    @Override
    public Response findAllUsers() {
        logger.info("fetch sys_user begin.");
        List<SysUser> sysUsers = this.sysUserDao.selectAll();
        if (null == sysUsers) {
            logger.warn("Sys User is empty.");
            return null;
        }
        logger.info("fetch sys_user end.");
        return new Response<>(sysUsers);
    }
}
