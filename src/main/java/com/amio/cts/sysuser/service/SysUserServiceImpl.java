package com.amio.cts.sysuser.service;

import com.amio.cts.sysuser.dao.SysUserDao;
import com.amio.cts.sysuser.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 用户接口实现
 *
 * @author : zhenfeng.liu
 * @date : 2018/9/4 17:24
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    private final SysUserDao sysUserDao;

    @Autowired
    public SysUserServiceImpl(SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }

    @Override
    public void createUser(SysUser sysUser) {
        sysUser.setCreateTime(LocalDateTime.now());
        sysUser.setLastUpdateTime(LocalDateTime.now());
        this.sysUserDao.insert(sysUser);
    }

    @Override
    public void deleteUser(int id) {
        this.sysUserDao.deleteByPrimaryKey(id);
    }

    @Override
    public SysUser findUserById(int id) {
        return this.sysUserDao.selectByPrimaryKey(id);
    }
}
