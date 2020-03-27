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
	@Autowired(required = false)
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
	public List<Permission> selectByParentid(Integer parentId) {
		// TODO Auto-generated method stub
		return mapper.selectByParentid(parentId);
	}

	@Override
	public void save(Permission permission) {
		// TODO Auto-generated method stub
		mapper.save(permission);
	}

	@Override
	public Permission findOne(Integer parentId) {
		// TODO Auto-generated method stub
		return mapper.findOne(parentId);
	}

	@Override
	public void update(Permission permission) {
		// TODO Auto-generated method stub
		mapper.update(permission);
	}

	@Override
	public void delete(Integer parentId) {
		// TODO Auto-generated method stub
		mapper.delete(parentId);
	}
}
