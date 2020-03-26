package com.woniuxy.dao;

import com.woniuxy.pojo.Permission;
import com.woniuxy.pojo.User;

import java.util.List;
import java.util.Map;


public interface UserMapper {

    void save(User User);

    void delete(Integer uid);

    void deleteUsers(Integer[] uids);

    void assignRoles(Map<String, Object> map);

    void unAssignRoles(Map<String, Object> map);

    List<Permission> selectPermissionByUser(User loginUser);

}
