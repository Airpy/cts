package com.amio.cts.repository;

import com.amio.cts.domain.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户Dao
 *
 * @author zhenfeng.liu
 */
@Service
public interface SysUserDao {
    /**
     * 插入sys_user表数据
     *
     * @param record user对象
     * @return 成功返回1
     */
    int insert(SysUser record);

    int insertSelective(SysUser record);

    /**
     * 根据id删除sys_user表数据
     *
     * @param id 表id
     * @return 删除的行数
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 通过主键查找用户
     *
     * @param id 主键id
     * @return 用户
     */
    SysUser selectByPrimaryKey(Integer id);

    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return 对应用户对象
     */
    SysUser selectByUsername(String username);

    /**
     * 查找所有用户
     *
     * @return 所有用户
     */
    List<SysUser> selectAll();

    /**
     * 获取用户表最大id
     *
     * @return 最大id
     */
    int getMaxId();

    /**
     * 查询sys_user表总行数
     *
     * @return 总行数
     */
    int selectCount();

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}