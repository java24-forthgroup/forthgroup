package com.woniuxy.service.impl;

import com.woniuxy.dao.UserMapper;
import com.woniuxy.pojo.Permission;
import com.woniuxy.pojo.User;
import com.woniuxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired(required = false)
	UserMapper mapper;

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		mapper.save(user);
	}

	@Override
	public void delete(Integer uid) {
		// TODO Auto-generated method stub
		mapper.delete(uid);
	}

	@Override
	public List<Permission> selectPermissionByUser(User loginUser) {
		return mapper.selectPermissionByUser(loginUser);
	}

	@Override
	public User login(User user) {
		return mapper.login(user);
	}

	@Override
	public void assignRoles(Map<String, Object> map) {
		mapper.assignRoles(map);
	}

	@Override
	public void removeRoles(Map<String, Object> map) {
		mapper.removeRoles(map);
	}

}
