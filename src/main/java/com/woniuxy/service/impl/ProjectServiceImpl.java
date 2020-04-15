package com.woniuxy.service.impl;

import com.woniuxy.dao.ProjectMapper;

//import com.woniuxy.pojo.Project;
//import com.woniuxy.service.ProjectService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
// * @auther: 秦浦华
// * @DATE: 2020/4/6   21:22
// */
//@Service
//@Transactional
//public class ProjectServiceImpl implements ProjectService {
//    @Autowired(required = false)
//    ProjectMapper projectMapper;
//    @Override
//    public List<Project> queryBySkillgroup(Integer skillgroupId) {
//        return projectMapper.queryBySkillgroup(skillgroupId);

/**
 * @auther: 鄢程宇
 *
 */
import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Project;
import com.woniuxy.service.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectMapper projectMapper;
    @Override
    public void save(Project obj) {
        projectMapper.save(obj);
    }

    @Override
    public void update(Project obj) {
        projectMapper.update(obj);
    }

    @Override
    public void delete(Integer projectId) {
        projectMapper.delete(projectId);
    }

    @Override
    public Project findOne(Integer projectId) {
        return projectMapper.findOne(projectId);
    }

    @Override
    public List<Project> findAll() {
        return projectMapper.findAll();
    }

    @Override
    public List<Project> selectByPage(PageBean<Project> pageBean) {
        return projectMapper.selectByPage(pageBean);
    }

    @Override
    public int countAll() {
        return projectMapper.countAll();
    }

    @Override
    public void deletes(Integer[] projectId) {
        projectMapper.deletes(projectId);

    }
}
