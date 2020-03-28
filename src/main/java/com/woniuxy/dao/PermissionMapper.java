package com.woniuxy.dao;

import java.util.List;

import com.woniuxy.pojo.Permission;

public interface PermissionMapper {

	List<Permission> findAll();

	Permission findRoot();

	List<Permission> selectByParentid(Integer pid);

	void save(Permission permission);

	Permission findOne(Integer pid);

	void update(Permission permission);

	void delete(Integer pid);

}
