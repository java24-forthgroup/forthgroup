package com.woniuxy.service.impl;

import com.woniuxy.dao.EmpDao;
import com.woniuxy.pojo.Emp;
import com.woniuxy.service.EmpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    @Autowired(required = false)
    EmpDao empDao;

    @Override
    public List<Emp> findAll() {
        return empDao.findAll();
    }
}
