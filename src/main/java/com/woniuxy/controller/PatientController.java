package com.woniuxy.controller;

import com.woniuxy.pojo.Message;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Patient;
import com.woniuxy.pojo.User;
import com.woniuxy.service.PatientService;
import com.woniuxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("patient")
public class PatientController {
    @Autowired
    PatientService patientService;
    @Autowired
    UserService userService;
    @RequestMapping("index")
    public String index(){
        return "patient/index";
    } @RequestMapping("goSave")
    public String goSave(){
        return "patient/save";
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
            int CountRow = patientService.countAll(pageBean);

            pageBean.setCountRow(CountRow);

            int countPage = pageBean.getCountRow()%pageBean.getPageRow()==0?pageBean.getCountRow()/pageBean.getPageRow():pageBean.getCountRow()/pageBean.getPageRow()+1;
            pageBean.setCountPage(countPage);
            List<Patient> allByPageBean = patientService.findAllByPageBean(pageBean);
            pageBean.setList(allByPageBean);
            message.setObj(pageBean);
            message.setFlag(true);
        } catch (Exception e) {
            message.setFlag(false);
            e.printStackTrace();
        }
        return message;
    }
    @RequestMapping("save")
    @ResponseBody
    public Message save(User user, Patient patient){
        System.out.println(user+"---------------"+patient);
        Message message = new Message();
        try {
            patientService.save(patient,user);

            message.setFlag(true);
        } catch (Exception e) {
            message.setFlag(false);
            e.printStackTrace();
        }
        return message;
    }
    @RequestMapping("delete")
    @ResponseBody
    public Message delete(Integer patientId){
        Message message = new Message();
        try {
            patientService.delete(patientId);
            message.setFlag(true);
        } catch (Exception e) {
            message.setFlag(false);
            e.printStackTrace();
        }
        return message;
    }
    @RequestMapping("update")
    @ResponseBody
    public Message update(Patient Patient){
        Message message = new Message();
        try {
            System.out.println(Patient);
            patientService.update(Patient);
            message.setFlag(true);
        } catch (Exception e) {
            message.setFlag(false);
            e.printStackTrace();
        }
        return message;
    }

    @RequestMapping("findOne")
    public String findOne(Model model,Integer patientId){
        Message message = new Message();
        try {
            Patient patient = patientService.findOne(patientId);
            model.addAttribute("patient",patient);
            message.setFlag(true);
        } catch (Exception e) {
            message.setFlag(false);
            e.printStackTrace();
        }
        return "patient/update";
    }

}
