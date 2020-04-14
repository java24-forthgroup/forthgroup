package com.woniuxy.controller;

import com.woniuxy.dao.EmpMapper;
import com.woniuxy.dao.ProjectMapper;
import com.woniuxy.pojo.*;
import com.woniuxy.service.ApprecordService;
import com.woniuxy.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Message book(Apprecord apprecord){
        Message message = new Message();
        try {

            apprecordService.book(apprecord);

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
