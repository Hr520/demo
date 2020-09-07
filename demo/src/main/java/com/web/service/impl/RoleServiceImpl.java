package com.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.web.entity.Role;
import com.web.mapper.RoleMapper;
import com.web.service.RoleService;
import com.web.util.rBool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Override
    public boolean insertRole(Role role) {
        return rBool.ChangeIntToBoolean(roleMapper.insert(role));
    }

    @Override
    public List<Role> selectRoleList(Integer id) {
        QueryWrapper<Role> roleQueryWrapper=new QueryWrapper<>();
        roleQueryWrapper.eq("userId",id);
        return roleMapper.selectList(roleQueryWrapper);
    }
}
