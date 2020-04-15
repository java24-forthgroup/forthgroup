package com.woniuxy.dao;

import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Permission;
import com.woniuxy.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> selectByPage(PageBean<User> pageBean);

    int countAll(PageBean<User> pageBean);

    void save(User User);

    User findOne(Integer UserId);

    List<Permission> selectPermissionByUser(User loginUser);

    User login(User user);

    void removeRoles(Map<String, Object> map);

    void update(User User);

    void delete(Integer User);

    User findOneByUname(String uname);

    void assignRoles(Map<String, Object> map);

	User findUserById(Integer userId);
}
