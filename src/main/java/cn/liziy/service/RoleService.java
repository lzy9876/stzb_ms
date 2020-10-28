package cn.liziy.service;

import cn.liziy.entity.Role;

import java.util.List;

/**
 * role业务接口
 * @author liziyang
 * @date 1:03 2020/10/29
 **/
public interface RoleService {
    /**
     * role 信息增加
     * @param role 实体类Role
     * @return 增加数据数量
     */
    int insertRole(Role role);

    /**
     * 根据id 删除role信息
     * @param id 主键id
     * @return 删除的数量
     */
    int deleteRoleById(Integer id);

    /**
     * 动态查询role信息
     * @param role 实体类Role
     * @return 查询到的role的数据列表
     */
    List<Role> queryRoleSelective(Role role);

    /**
     * 根据id 修改role 信息
     * @param role 实体类Role
     * @return 修改的数据数量
     */
    int updateRoleById(Role role);
}
