package cn.liziy.service.impl;

import cn.liziy.dao.RoleDao;
import cn.liziy.entity.Role;
import cn.liziy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * role业务实现类
 * @author Liziy
 * @date 2020/10/29 1:10
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired(required = false)
    private RoleDao roleDao;

    @Override
    public int insertRole(Role role) {
        return roleDao.insertRole(role);
    }

    @Override
    public int deleteRoleById(Integer id) {
        return roleDao.deleteRoleById(id);
    }

    @Override
    public List<Role> queryRoleSelective(Role role) {
        return roleDao.queryRoleSelective(role);
    }

    @Override
    public int updateRoleById(Role role) {
        return roleDao.updateRoleById(role);
    }
}
