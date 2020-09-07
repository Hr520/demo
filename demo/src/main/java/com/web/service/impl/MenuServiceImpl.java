package com.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.web.entity.Menu;
import com.web.mapper.MenuMapper;
import com.web.service.MenuService;
import org.springframework.stereotype.Service;
import vo.MenuVo;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;
    @Override
    public List<Menu> getAllMenuList() {
       return   menuMapper.selectList(null);
    }

    @Override
    public List<MenuVo> cacheAllMenuList() {
        List<Menu> menuList=getAllMenuList();
        List<Menu> fList=menuList.stream().filter(e -> e.getPid()==0).collect(Collectors.toList());
        List<MenuVo> f_json_list= JSON.parseArray(JSON.toJSONString(fList),MenuVo.class);
        Map<Integer,List<Menu>> map = menuList.stream().collect(Collectors.groupingBy(Menu::getPid));
        for (Map.Entry<Integer, List<Menu>> entry : map.entrySet()) {
            for (int i = 0; i <f_json_list.size() ; i++) {
                if (entry.getKey().equals(fList.get(i).getId())){
                    f_json_list.get(i).setSubMenu(entry.getValue());
                }
            }
        }
        return f_json_list;
    }


}
