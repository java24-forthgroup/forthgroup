package com.woniuxy.dao;

import com.woniuxy.pojo.Emp;
import com.woniuxy.pojo.PageBean;

import java.util.List;

public interface EmpMapper {
    List<Emp> findAll();
    List<Emp> findAllDoctor();
    List<Emp> selectByPage(PageBean<Emp> pageBean);

    int countAll(PageBean<Emp> pageBean);

    void save(Emp emp);

    Emp findOne(Integer empId);

    void update(Emp emp);

    void delete(Integer empId);

    int findUserIdByempId(Integer empId);

    List<Emp> queryDoctorByAroomId(Integer aroomId);
}
