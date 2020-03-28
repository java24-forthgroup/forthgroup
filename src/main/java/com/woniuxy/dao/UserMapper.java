package com.woniuxy.dao;

import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> selectByPage(PageBean<User> pageBean);

    int countAll(PageBean<User> pageBean);

    void save(User User);

    User findOne(Integer UserId);

    void update(User User);

    void delete(Integer User);

    User findOneByUname(String uname);
}
