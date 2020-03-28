package com.woniuxy.service;

import com.woniuxy.pojo.Permission;
import com.woniuxy.pojo.User;

import java.util.List;
import java.util.Map;


public interface UserService {

	void save(User user);

	void delete(Integer uid);

    List<Permission> selectPermissionByUser(User loginUser);

	User login(User user);

    void assignRoles(Map<String, Object> map);

    void removeRoles(Map<String, Object> map);
}
