package com.woniuxy.service;

import com.woniuxy.pojo.User;
import com.woniuxy.pojo.PageBean;

import java.util.List;

public interface UserService {

    List<User> selectByPage(PageBean<User> pageBean);

    int countAll(PageBean<User> pageBean);

    void save(User User);

    User findOne(Integer eid);

    void update(User User);

    void delete(Integer eid);

    User findOneByUname(String uname);
}
