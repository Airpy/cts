package com.amio.cts.sysuser.dao;

import com.amio.cts.sysuser.entity.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户Dao
 */
@Service
public interface SysUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    List<SysUser> selectAll();

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}