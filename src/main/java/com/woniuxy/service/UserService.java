package com.woniuxy.service;

import com.woniuxy.pojo.Permission;
import com.woniuxy.pojo.User;
import com.woniuxy.pojo.PageBean;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> selectByPage(PageBean<User> pageBean);

    int countAll(PageBean<User> pageBean);

    List<Permission> selectPermissionByUser(User loginUser);

	User login(User user);

    void assignRoles(Map<String, Object> map);

    void removeRoles(Map<String, Object> map);

    void save(User User);

    User findOne(Integer eid);

    void update(User User);

    void delete(Integer eid);

    User findOneByUname(String uname);

    User findUserById(Integer userId);
}
