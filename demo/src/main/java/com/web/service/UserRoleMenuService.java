package com.web.service;

import com.web.entity.RoleMenu;

import java.util.List;

public interface UserRoleMenuService {
    List<RoleMenu> getUserRoleMenuListInRoleId(List<Integer> roleIdList);
}
