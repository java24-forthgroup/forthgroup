package com.woniuxy.controller;

import com.woniuxy.dao.EmpMapper;
import com.woniuxy.dao.ProjectMapper;
import com.woniuxy.pojo.*;
import com.woniuxy.service.ApprecordService;
import com.woniuxy.service.PatientService;
import com.woniuxy.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther: 秦浦华
 * @DATE: 2020/3/28   16:25
 */
@Controller
@RequestMapping("apprecord")
public class ApprecordController {
    @Autowired
    ApprecordService apprecordService;
    @Autowired
    PatientService patientService;
    @Autowired(required = false)
    EmpMapper empMapper;
    @Autowired(required = false)
    ProjectMapper projectMapper;
    @Autowired
    SourceService sourceService;
    //查询全部
    @RequestMapping("index")
    public String index(){
        return "apprecord/index";
    }
    //去预约//
    @RequestMapping("goBook")
    public String goBook(Model model,Integer userId){
        Patient patient = patientService.findPatientByUserId(userId);

        System.out.println(patient);
        model.addAttribute("patient",patient);
        return "apprecord/book";
    }
    //去我的预约
    @RequestMapping("goMyBook")
    public String goMyBook(Model model,Integer userId){
        model.addAttribute("userId",userId);
        return "apprecord/myBook";
    }
    //我的预约//
    @RequestMapping("myBook")
    @ResponseBody
    public Message myBook(HttpSession session , PageBean pageBean){
        Message message = new Message();
        try {
            if(pageBean.getNowPage()==null) {
                pageBean.setNowPage(1);
            }
            pageBean.setPageRow(5);
            User loginUser = (User)session.getAttribute("loginUser");
            Patient patient = patientService.findPatientByUserId(loginUser.getUserId());
            System.out.println(patient);
            pageBean.setQueryVal(patient.getPatientName());
            int CountRow = apprecordService.countAll(pageBean);
            System.out.println(CountRow);
            pageBean.setCountRow(CountRow);

            int countPage = pageBean.getCountRow()%pageBean.getPageRow()==0?pageBean.getCountRow()/pageBean.getPageRow():pageBean.getCountRow()/pageBean.getPageRow()+1;
            pageBean.setCountPage(countPage);

            List<Apprecord> list= apprecordService.myBook(pageBean);
            System.out.println(list);
            System.out.println(list.size());
            pageBean.setList(list);
            message.setObj(pageBean);
            message.setFlag(true);
        } catch (Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }
    @RequestMapping("queryBySkillgroupId")
    @ResponseBody
    public Message queryBySkillgroupId(Integer skillgroupId){
        System.out.println(skillgroupId+"+++++++++++++++++++++++");
        Message message = new Message();
        try {
            int sourceCount = sourceService.queryBySkillgroupId(skillgroupId);
            message.setObj(sourceCount);
            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
       
    }
    @RequestMapping("findAllByPage")
    @ResponseBody
    public Message findAllByPage(PageBean pageBean){
        Message message = new Message();
        try {
            if(pageBean.getNowPage()==null) {
                pageBean.setNowPage(1);
            }
            pageBean.setPageRow(5);
            int CountRow = apprecordService.countAll(pageBean);
            System.out.println(CountRow);
            pageBean.setCountRow(CountRow);

            int countPage = pageBean.getCountRow()%pageBean.getPageRow()==0?pageBean.getCountRow()/pageBean.getPageRow():pageBean.getCountRow()/pageBean.getPageRow()+1;
            pageBean.setCountPage(countPage);
            List<Apprecord> list= apprecordService.findAllByPage(pageBean);
            System.out.println(list);
            pageBean.setList(list);
            message.setObj(pageBean);
            message.setFlag(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
    @RequestMapping("findOne")
    public String findOne(Model mode , Integer apprecordId){
        Message message = new Message();
        Map<String,Object> map = new HashMap<>();
        try {

            Apprecord apprecord = apprecordService.findOne(apprecordId);
            System.out.println(apprecord);
//            List<Emp> empList = empMapper.findAllDoctor();
            List<Emp> empList = empMapper.findAll();
            List<Project> projectList = projectMapper.findAll();
//            map.put("empList",empList);
//            map.put("projectList",projectList);
//            map.put("apprecord",apprecord);
            mode.addAttribute("projectList",projectList);
            mode.addAttribute("empList",empList);
            mode.addAttribute("apprecord",apprecord);
            return "apprecord/update";
        }catch(Exception e) {
            e.printStackTrace();
        }
        return "apprecord/update";
    }

    @ResponseBody
    @RequestMapping("delApprecords")
    public Message delApprecord(Integer [] typeId){

        Message message = new Message();
        try {
            apprecordService.delApprecords(typeId);

            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }
    @ResponseBody
    @RequestMapping("delete")
    public Message delete(Integer apprecordId){

        Message message = new Message();
        try {
            apprecordService.delete(apprecordId);

            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }
    //预约
    @ResponseBody
    @RequestMapping("book")
    public Message book(Apprecord apprecord,Skillgroup skillgroup,HttpSession session){
        Message message = new Message();
        try {
            Patient loginUser = (Patient)session.getAttribute("loginUser");
            apprecord.setEmpId(loginUser.getPatientId());
            Integer result = apprecordService.book(apprecord, skillgroup);
            if(result==0){
                message.setFlag(false);
            }
            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }
    @ResponseBody
    @RequestMapping("update")
    public Message update(Apprecord apprecord){
        Message message = new Message();

        try {
            apprecordService.update(apprecord);

            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }

}
