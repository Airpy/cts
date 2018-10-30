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
            sysUser.setId(sysUserDao.selectCount() + 1);
            sysUser.setCreateTime(response.getLocalDateTime());
            sysUser.setLastUpdateTime(response.getLocalDateTime());
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
    public void deleteUser(int id) {
        this.sysUserDao.deleteByPrimaryKey(id);
    }

    @Override
    public void updateUser(SysUser sysUser) {
        sysUser.setLastUpdateTime(LocalDateTime.now());
        this.sysUserDao.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public SysUser findUserById(int id) {
        return this.sysUserDao.selectByPrimaryKey(id);
    }

    @Override
    public List<SysUser> findAllUsers() {
        return this.sysUserDao.selectAll();
    }
}
