package com.woniuxy.service.impl;

import com.woniuxy.dao.UserMapper;
import com.woniuxy.pojo.Permission;
import com.woniuxy.pojo.User;
import com.woniuxy.pojo.PageBean;
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
    public List<User> selectByPage(PageBean<User> pageBean) {
        return mapper.selectByPage(pageBean);
    }

    @Override
    public int countAll(PageBean<User> pageBean) {
        return mapper.countAll(pageBean);
    }

    @Override
    public void save(User User) {
        //MD5  将123转为加密数字   采用md5.js在前端实现
        User.setUpwd("202cb962ac59075b964b07152d234b70");
        mapper.save(User);
    }

    @Override
    public User findOne(Integer UserId) {
        return mapper.findOne(UserId);
    }

    @Override
    public void update(User User) {
        mapper.update(User);
    }

    @Override
    public void delete(Integer UserId) {
        mapper.delete(UserId);
    }

    @Override
    public User findOneByUname(String uname) {
       User user =  mapper.findOneByUname(uname);
        return user;
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

	@Override
	public User findUserById(Integer userId) {
		return mapper.findUserById(userId);
	}

}
