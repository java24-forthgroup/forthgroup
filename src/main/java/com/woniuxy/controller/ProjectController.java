package com.woniuxy.controller;

//import com.woniuxy.pojo.Project;
//import com.woniuxy.service.ProjectService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
///**
// * @auther: 秦浦华
// * @DATE: 2020/4/6   21:09
// */
//@Controller
//@RequestMapping("project")
//public class ProjectController {
//    @Autowired
//    ProjectService projectService;
//    @RequestMapping("queryBySkillgroup")
//    @ResponseBody
//    public List queryBySkillgroup(Integer skillgroupId){
//
//        List<Project> projectList = null;
//
//        try {
//            projectList = projectService.queryBySkillgroup(skillgroupId);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return projectList;
//    }

/**
 * @auther: 鄢程宇
 *
 */
import com.woniuxy.pojo.*;
import com.woniuxy.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("Project")
public class ProjectController {
    @Resource
    private ProjectService projectService;

    @RequestMapping("index")
    public String index(){
        return "project/project";
    }

    @RequestMapping("gosave")
    public String gosave(){
        return "project/save";
    }

    @RequestMapping("goupdate")
    public String goupdate(Integer projectId , Model model){
        Project project = projectService.findOne(projectId);
        System.out.println(project);
        model.addAttribute("project",project);
        return  "project/update";
    }


    //展示所有医技项目信息
    @ResponseBody
    @RequestMapping("allProject")
    public Object allEquipment(PageBean<Project> pageBean){
        Message message = new Message();

        try{
            List<Project> list=projectService.selectByPage(pageBean);
            pageBean.setList(list);
            //总行数
            int countRow=projectService.countAll();
            pageBean.setCountRow(countRow);
            //总页数
            int countpage=pageBean.getCountRow()%pageBean.getPageRow()==0?pageBean.getCountRow()/pageBean.getPageRow():pageBean.getCountRow()/pageBean.getPageRow()+1;
            pageBean.setCountPage(countpage);

            message.setFlag(true);
        }catch (Exception e){
            message.setFlag(false);
        }
        message.setObj(pageBean);


        return message;
    }

    @RequestMapping("delete")
    @ResponseBody
    public Object delete(Integer projectId) {
        Message message = new Message();
        try{
            projectService.delete(projectId);
            message.setFlag(true);
        }catch (Exception e){
            e.printStackTrace();
            message.setFlag(false);
        }

        return message;

    }

    @RequestMapping("deletes")
    @ResponseBody
    public Object deletes(Integer[] projectId) {


        Message message = new Message();
        try{
            projectService.deletes(projectId);
            message.setFlag(true);
        }catch (Exception e){
            e.printStackTrace();
            message.setFlag(false);
        }

        return message;

    }

    @ResponseBody
    @RequestMapping("save")
    public Object save(Project project) {
        Message message = new Message();
        try{
            projectService.save(project);
            message.setFlag(true);
        }catch (Exception e){
            e.printStackTrace();
            message.setFlag(false);
        }

        return message;

    }

    @RequestMapping("update")
    @ResponseBody
    public Object update(Project project) {
        Message message = new Message();
        try{
            projectService.update(project);
            message.setFlag(true);
        }catch (Exception e){
            e.printStackTrace();
            message.setFlag(false);
        }

        return message;

    }

    @RequestMapping("findone")
    @ResponseBody
    public Project findOne(Integer projectId) {
        Project s = projectService.findOne(projectId);
        System.out.println(s);
        return s;
    }

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
