package com.woniuxy.service;

import java.util.List;
import java.util.Map;

import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Role;

public interface RoleService {

	List<Role> selectByPage(PageBean<Role> pageBean);

	int countByPage(PageBean<Role> pageBean);

	void save(Role role);

	List<Role> findAll();

	List<Role> selectRolesByUid(Integer uid);

	void assignPermission(Map<String, Object> map);

	List<Integer> findByRid(Integer rid);

	Role findOne(Integer rid);

	void update(Role role);

	void delete(Integer rid);

}
