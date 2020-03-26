package com.woniuxy.service.impl;

import com.woniuxy.dao.UserMapper;
import com.woniuxy.pojo.User;
import com.woniuxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
