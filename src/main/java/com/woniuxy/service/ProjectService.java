package com.woniuxy.service;

//import com.woniuxy.pojo.Project;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
// * @auther: 秦浦华
// * @DATE: 2020/4/6   21:21
// */
//
//public interface ProjectService {
//
//    List<Project> queryBySkillgroup(Integer skillgroupId);


/**
 * @auther: 鄢程宇
 *
 */
import com.woniuxy.dao.ProjectMapper;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Project;

import java.util.List;

public interface ProjectService {
    void save(Project obj);
    void update(Project obj);
    void delete(Integer projectId);
    Project findOne(Integer projectId);
    List<Project> findAll();


    List<Project> selectByPage(PageBean<Project> pageBean);

    int countAll();

    void deletes(Integer[] projectId);

}
