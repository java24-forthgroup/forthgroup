package com.woniuxy.service;

import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Skillgroup;

import java.util.List;

/**
 * @author zhao
 * @create 2020/03/2020/3/26 23:12:56
 */
public interface SkillgroupService {


    List<Skillgroup> findAll();

    List<Skillgroup> selectByPage(PageBean<Skillgroup> pageBean);

    int countAll(PageBean<Skillgroup> pageBean);

    void save(Skillgroup Skillgroup);

    Skillgroup findOne(Integer SkillgroupId);

    void update(Skillgroup Skillgroup);

    void delete(Integer SkillgroupId);


    Integer queryDoctorBySkillgroup(Integer skillgroupId);
}
