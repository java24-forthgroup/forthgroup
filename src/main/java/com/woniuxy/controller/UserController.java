package com.woniuxy.controller;

import com.woniuxy.pojo.Message;
import com.woniuxy.pojo.User;
import com.woniuxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther: 秦浦华
 * @DATE: 2020/3/28   10:03
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("findOneByUname")
    @ResponseBody
    public Message findOneByUname(String uname){
       Message message = new Message();
        try {
            User user = userService.findOneByUname(uname);
            if (user==null){
                message.setFlag(false);
            }else {
                message.setFlag(true);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
        return message;
    }
}
