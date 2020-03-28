package com.woniuxy.service.impl;

import com.woniuxy.dao.UserMapper;
import com.woniuxy.pojo.User;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

}
