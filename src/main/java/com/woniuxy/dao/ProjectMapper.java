package com.woniuxy.dao;


//import com.woniuxy.pojo.Project;
//
//import java.util.List;
//
///**
// * @auther: 秦浦华
// * @DATE: 2020/3/29   18:52
// */
//public interface ProjectMapper {
//    List<Project> findAll();
//    List<Project> queryBySkillgroup(Integer skillgroupId);


/**
 * @auther: 鄢程宇
 *
 */
import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMapper {
    void save(Project obj);
    void update(Project obj);
    void delete(Integer projectId);
    Project findOne(Integer projectId);
    List<Project> findAll();


    List<Project> selectByPage(PageBean<Project> pageBean);

    int countAll();

    void deletes(Integer[] projectId);

    List<Project> queryBySkillgroup(Integer skillgroupId);
}
