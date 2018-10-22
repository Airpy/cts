package com.amio.cts.sysuser.service;

import com.amio.cts.sysuser.entity.SysUser;

/**
 * 用户接口
 *
 * @author : zhenfeng.liu
 * @date : 2018/9/4 17:24
 */
public interface SysUserService {
    /**
     * 新增系统用户
     *
     * @param sysUser 系统用户对象
     */
    void createUser(SysUser sysUser);

    /**
     * 通过用户id删除用户信息
     *
     * @param id 用户id
     */
    void deleteUser(int id);

    /**
     * 通过用户id查找用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    SysUser findUserById(int id);
}
