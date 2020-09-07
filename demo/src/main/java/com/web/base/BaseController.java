package com.web.base;

import com.web.util.IdWorker;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class BaseController {
    public   static final   IdWorker idWorker=new IdWorker(1,1);
    public static final Map<String, String> Login_user = new HashMap<>();
    public static final Map<String, String> Login_Out_user = new HashMap<>();

    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }
    /**
     * 获取session
     *
     * @return
     */
    public HttpSession getSession() {
        return getRequest().getSession();
    }






}
