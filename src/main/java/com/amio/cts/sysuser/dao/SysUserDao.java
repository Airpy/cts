package com.amio.cts.sysuser.dao;

import com.amio.cts.sysuser.entity.SysUser;
import org.springframework.stereotype.Service;

/**
 * 用户Dao
 */
@Service
public interface SysUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser sysUser);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}