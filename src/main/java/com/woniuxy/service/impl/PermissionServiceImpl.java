package com.woniuxy.service.impl;

import java.util.List;

import com.woniuxy.dao.PermissionMapper;
import com.woniuxy.pojo.Permission;
import com.woniuxy.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	PermissionMapper mapper;

	@Override
	public List<Permission> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

	@Override
	public Permission findRoot() {
		// TODO Auto-generated method stub
		return mapper.findRoot();
	}

	@Override
	public List<Permission> selectByParentid(Integer pid) {
		// TODO Auto-generated method stub
		return mapper.selectByParentid(pid);
	}

	@Override
	public void save(Permission permission) {
		// TODO Auto-generated method stub
		mapper.save(permission);
	}

	@Override
	public Permission findOne(Integer pid) {
		// TODO Auto-generated method stub
		return mapper.findOne(pid);
	}

	@Override
	public void update(Permission permission) {
		// TODO Auto-generated method stub
		mapper.update(permission);
	}

	@Override
	public void delete(Integer pid) {
		// TODO Auto-generated method stub
		mapper.delete(pid);
	}
}
