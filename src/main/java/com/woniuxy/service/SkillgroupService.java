package com.woniuxy.service;

import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Skillgroup;

import java.util.List;

/**
 * @author zhao
 * @create 2020/03/2020/3/26 23:12:56
 */
//public interface SkillgroupService {


//    List<Skillgroup> findAll();
//
//    List<Skillgroup> selectByPage(PageBean<Skillgroup> pageBean);
//
//    int countAll(PageBean<Skillgroup> pageBean);
//
//    void save(Skillgroup Skillgroup);
//
//    Skillgroup findOne(Integer SkillgroupId);
//
//    void update(Skillgroup Skillgroup);
//
//    void delete(Integer SkillgroupId);
//
//
//    Integer queryDoctorBySkillgroup(Integer skillgroupId);


    /**
     * @auther: 鄢程宇
     *
     */
public interface SkillgroupService {
    void save(Skillgroup obj);
    void update(Skillgroup obj);
    void delete(Integer skillgroupId);
    Skillgroup findOne(Integer skillgroupId);
    List<Skillgroup> findAll();


    List<Skillgroup> selectByPage(PageBean<Skillgroup> pageBean);

    int countAll();

    void deletes(Integer[] skillgroupId);

        Integer queryDoctorBySkillgroup(Integer skillgroupId);
    }
