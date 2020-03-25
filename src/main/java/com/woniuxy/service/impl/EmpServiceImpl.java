package com.woniuxy.service.impl;

import com.woniuxy.dao.EmpMapper;
import com.woniuxy.pojo.Emp;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.service.EmpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    @Autowired(required = false)
    EmpMapper mapper;

    @Override
    public List<Emp> findAll() {
        return mapper.findAll();
    }

    @Override
    public List<Emp> selectByPage(PageBean<Emp> pageBean) {
        return mapper.selectByPage(pageBean);
    }

    @Override
    public int countAll(PageBean<Emp> pageBean) {
        return mapper.countAll(pageBean);
    }

    @Override
    public void save(Emp emp) {
        mapper.save(emp);
    }

    @Override
    public Emp findOne(Integer empId) {
        return mapper.findOne(empId);
    }

    @Override
    public void update(Emp emp) {
        mapper.update(emp);
    }

    @Override
    public void delete(Integer empId) {
        mapper.delete(empId);
    }

    @Override
    public void updateOne(Emp emp) {

    }

    @Override
    public void usernamepasswordUpdate(Emp emp) {

    }
}
