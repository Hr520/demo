package com.web.controller.system;


import com.web.base.BaseController;
import com.web.entity.SystemUser;
import com.web.service.SystemUserService;
import com.web.util.Aes;
import com.web.util.Const;
import com.web.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.annotation.Resource;


/*
 * 总入口
 */
@Controller
public class LoginController extends BaseController {

	@Resource
	private SystemUserService userService;


	/**
	 * 访问登录页
	 * 
	 * @return
	 */
	@GetMapping(value = "/login")
	public String toLogin(){
		//判断当前用户是否已经登录 获取sessionID
		// 获取当前的session id 是否与系统中登录的用户sessionid一样
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		String session_id = session.getId().toString();
		if (Login_user.values().contains(session_id)){
			return "/index";
		}else {
			return "/view/login";
		}

	}

	@GetMapping(value = "/index")
	public  String index(){
		return "/home";
	}

	@GetMapping(value = "/erro")
	public String erro(){
		return "/view/erro";
	}

}
