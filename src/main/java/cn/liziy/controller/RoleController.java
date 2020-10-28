package cn.liziy.controller;

import cn.liziy.entity.Role;
import cn.liziy.service.impl.RoleServiceImpl;
import cn.liziy.utils.R;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * role URL 接口
 * @author liziyang
 * @date 1:17 2020/10/29
 **/
@RestController
@RequestMapping("/admin")
public class RoleController {

    private final static Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleServiceImpl roleService;

    @PostMapping("/role")
    public R getRole(Integer id,
                     String text,
                     String identName,
                     int pageNum,
                     int pageSize){
        Role role = new Role();
        role.setId(id);
        role.setText(text);
        role.setIdentName(identName);
        //分页插件
        PageHelper.startPage(pageNum,pageSize);
        List<Role> roleList = roleService.queryRoleSelective(role);
        if (roleList.size() == 0){
            return R.ofMessgae(R.Status.INSERT_NULL);
        }
        return R.ofSuccess(roleList,roleList.size());
    }

}
