package com.woniuxy.dao;

import java.util.List;
import java.util.Map;

import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Role;

public interface RoleMapper {
	void save(Role role);
	List<Role> selectByPage(PageBean<Role> pageBean);
	int countByPage(PageBean<Role> pageBean);
	List<Role> findAll();
	List<Role> selectRolesByUid(Integer uid);
	void assignPermission(Map<String, Object> map);
	List<Integer> findByRid(Integer rid);
	void deleteAssignPermissionByRid(Object object);
    Role findOne(Integer rid);
	void update(Role role);
	void delete(Integer rid);

	List<Role> findAssignRolesByUserId(Integer userId);
	List<Role> findUnAssignRolesByUserId(Integer[] rids);
}
