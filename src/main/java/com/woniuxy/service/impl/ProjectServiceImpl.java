package com.woniuxy.service.impl;

import com.woniuxy.dao.ProjectMapper;
import com.woniuxy.pojo.Project;
import com.woniuxy.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @auther: 秦浦华
 * @DATE: 2020/4/6   21:22
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Autowired(required = false)
    ProjectMapper projectMapper;
    @Override
    public List<Project> queryBySkillgroup(Integer skillgroupId) {
        return projectMapper.queryBySkillgroup(skillgroupId);
    }
}
