package com.amio.cts.repository;

import com.amio.cts.domain.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户Dao
 */
@Service
public interface SysUserDao {
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入sys_user表数据
     *
     * @param record user对象
     * @return 成功返回1
     */
    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return 对应用户对象
     */
    SysUser selectByUsername(String username);

    List<SysUser> selectAll();

    /**
     * 查询sys_user表总行数
     *
     * @return 总行数
     */
    int selectCount();

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}