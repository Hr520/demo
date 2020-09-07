package com.web.controller.system;


import com.alibaba.fastjson.JSON;
import com.web.base.BaseController;
import com.web.entity.SystemUser;
import com.web.service.MenuService;
import com.web.service.SystemUserService;
import com.web.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import vo.MenuVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


/*
 * 总入口
 */
@Controller
public class LoginController extends BaseController {

	@Resource
	private SystemUserService userService;
	@Resource
	private MenuService menuService;


	/**
	 * 访问登录页
	 * 
	 * @return
	 */
	@GetMapping(value = "/login")
	public String toLogin(){
		//判断当前用户是否已经登录 获取sessionID
		// 获取当前的session id 是否与系统中登录的用户sessionid一样
		String session_id = getSession().getId().toString();
		if (Login_user.values().contains(session_id)){
			return "/index";
		}else {
			return "/view/login";
		}

	}

	@GetMapping(value = "/index")
	public  String index(){
		//根据sessionId 获取当前用户的ID;
		HttpSession session = getSession();
		SystemUser systemUser=(SystemUser) session.getAttribute(session.getId());
		//判断当前系统菜单是否已缓存
		List<MenuVo> list= JSON.parseArray(JSON.toJSONString(getRequest().getSession().getAttribute(Const.SESSION_ALLmenuList)),MenuVo.class);
		if (list==null || list.size()==0){
			list=menuService.cacheAllMenuList();
		}
		getSession().setAttribute(Const.SESSION_ALLmenuList,list);
		//获取当前用户菜单列表

		return "/index";
	}

	@GetMapping(value = "/erro")
	public String erro(){
		return "/view/erro";
	}

}
