package com.web.service;

import com.web.entity.Menu;
import vo.MenuVo;

import java.util.List;

public interface MenuService {
    List<Menu> getAllMenuList();
    List<MenuVo> cacheAllMenuList();
}
