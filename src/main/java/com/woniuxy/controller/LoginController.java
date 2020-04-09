package com.woniuxy.controller;

import com.woniuxy.pojo.Message;
import com.woniuxy.pojo.Permission;
import com.woniuxy.pojo.User;
import com.woniuxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("login")
    public String login() {
        return "login";
    }
    @ResponseBody
    @RequestMapping("loginAjax")
    public Object loginAjax(User user, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        Message message = new Message();
        // 调用Service中的登录方法，返回登录用户的对象
        User loginUser = userService.login(user);
        if (loginUser != null) {
            session.setAttribute("loginUser", loginUser);
        // 获得该用户的的许可
            List<Permission> permissionList = userService.selectPermissionByUser(loginUser);
            Permission root = null;
            Map<Integer, Permission> map = new HashMap<Integer, Permission>();
            for (Permission permission : permissionList) {
                permission.setOpen(true);
                map.put(permission.getPermissionId(), permission);
            }
            for (Permission permission : permissionList) {
                if (permission.getParentId() == null) {
                    root = permission;
                } else {
                    Permission parent = map.get(permission.getParentId());
                    parent.getChildren().add(permission);
                }
            }
            // 将登录用户的菜单存入session
            session.setAttribute("root", root);
            // cookie
            String uname = request.getParameter("uname");

            Cookie cookie = new Cookie("uname", uname);
            // 设置cookie过期时间
            cookie.setMaxAge(3600);
            response.addCookie(cookie);

            message.setFlag(true);
        } else {
            message.setFlag(false);
        }
            return message;
        }

    @RequestMapping("main")
    public String main() {
        return "main";
    }

    @RequestMapping("logout")
    public String loginout(HttpSession session) {
//		//移除登陆用户
//		session.removeAttribute("loginUser");
        //移除session中所有信息
        session.invalidate();
        return "redirect:login";
    }
    //跳转到帮助页面
    @RequestMapping("help")
    public String help() {
        return "help";
    }

}

