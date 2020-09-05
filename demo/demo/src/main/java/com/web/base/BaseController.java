package com.web.base;

import com.web.util.IdWorker;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public Session getSession() {
        Subject currentUser = SecurityUtils.getSubject();
        return currentUser.getSession();
    }


    // 获取请求地址 存入菜单Cookie中
    public void saveMenuUrl(String url, HttpServletRequest request) {
        HttpSession session = request.getSession();
        // 获得url
       /* PageData pd = new PageData();
        try {
            // 根据获取的URL 得到其父级id
            // 截取字符串前面一个单词
            *//*
             * String [] strs=url.split("/"); url=strs[0];
             *//*
            pd.put("url", url);
            List<PageData> menu = userRoleService.getMenuId(pd);
            String role_id = (String) session.getAttribute(Const.Role_id);
            if (role_id.equals("1") && menu.size() == 3) {
                pd = menu.get(0);
            } else if ((role_id.equals("2") && menu.size() == 3) || (role_id.equals("4") && menu.size() == 3)) {
                pd = menu.get(1);
            } else if (role_id.equals("3") && menu.size() == 3) {
                pd = menu.get(2);
            } else if (menu.size() == 1) {
                pd = menu.get(0);
            }
            if (pd.get("p_id") != null) {
                String fId = pd.get("p_id").toString();
                session.setAttribute("fid", fId);
            }
            String cid = pd.get("id").toString();
            session.setAttribute("cid", cid);
            *//**
             *
             * 获取当前学期 并计算出当前是第几周 1 判断当前属于哪一学期 2 查询学期名称 获得 该学期开始时间
             *//*
            List<PageData> list = new ArrayList<>();
            PageData Time_pd = new PageData();
            // 查询 当前学期
            list = userService.getTodayWhatSpringOrAutum(Time_pd);
            Time_pd = list.get(0);
            if (StringUtil.isNull(Time_pd)) {
            } else {
                String todey = DateUtil.getThisWeekMonday(Time_pd.get("begin_week_day").toString());
                String semester_name = Time_pd.get("semester_name").toString();
                String Nowday = DateUtil.getDay();
                double week = (DateUtil.getDaySub(todey, Nowday) / 7) + 1;
                Math.ceil(week);
                semester_name = semester_name + " 第 " + (int) week + " 周 ";
                session.setAttribute("week_num_sign", week);
                session.setAttribute("Today", semester_name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }




}
