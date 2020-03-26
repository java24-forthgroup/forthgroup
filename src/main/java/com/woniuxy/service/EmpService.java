package com.woniuxy.service;

import com.woniuxy.pojo.Emp;
import com.woniuxy.pojo.PageBean;

import java.util.List;

public interface EmpService {
    List<Emp> findAll();

    List<Emp> selectByPage(PageBean<Emp> pageBean);

    int countAll(PageBean<Emp> pageBean);

    void save(Emp emp);

    Emp findOne(Integer eid);

    void update(Emp emp);

    void delete(Integer eid);

}
