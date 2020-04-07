package com.woniuxy.controller;

import com.woniuxy.pojo.Project;
import com.woniuxy.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @auther: 秦浦华
 * @DATE: 2020/4/6   21:09
 */
@Controller
@RequestMapping("project")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @RequestMapping("queryBySkillgroup")
    @ResponseBody
    public List queryBySkillgroup(Integer skillgroupId){

        List<Project> projectList = null;

        try {
            projectList = projectService.queryBySkillgroup(skillgroupId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return projectList;
    }
}
