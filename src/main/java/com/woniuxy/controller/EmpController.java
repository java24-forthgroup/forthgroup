package com.woniuxy.controller;

import com.woniuxy.pojo.*;
import com.woniuxy.service.AroomService;
import com.woniuxy.service.EmpService;
import com.woniuxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("emp")
public class EmpController {
    @Autowired
    EmpService empService;
    @Autowired
    AroomService aroomService;
    @Autowired
    UserService userService;

    @RequestMapping("index")
    public String list(Model model) {
        List<Emp> empList = empService.findAll();
        model.addAttribute("empList", empList);
        return "emp/index";
    }

    @ResponseBody
    @RequestMapping("indexByPage")
    public Object indexByPage(PageBean<Emp> pageBean) {
        Message message = new Message();
        try {
            if(pageBean.getNowPage()==null) {
                pageBean.setNowPage(1);
            }
            List<Emp> empList = empService.selectByPage(pageBean);
            pageBean.setList(empList);
            int countRow = empService.countAll(pageBean);
            pageBean.setCountRow(countRow);
            int countPage = pageBean.getCountRow()%pageBean.getPageRow()==0?pageBean.getCountRow()/pageBean.getPageRow():pageBean.getCountRow()/pageBean.getPageRow()+1;
            pageBean.setCountPage(countPage);
            message.setFlag(true);
        }catch(Exception e) {
            message.setFlag(false);
        }
        message.setObj(pageBean);
        return message;
    }

    @RequestMapping("save")
    public String save(Model model) {
        List<Aroom> aroomList = aroomService.findAll();
        model.addAttribute("aroomList",aroomList);
        return "emp/save";
    }

    @ResponseBody
    @RequestMapping("saveEmp")
    public Object saveEmp(Emp emp, User user) {
        Message message = new Message();
        try {
            user.setUpwd("123");
            userService.save(user);
            emp.setUserId(user.getUserId());
            empService.save(emp);
            message.setFlag(true);
        } catch (Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }

    @RequestMapping("update")
    public String findOne(Integer empId, Model model) {
        Emp emp = empService.findOne(empId);
        List<Aroom> aroomList = aroomService.findAll();
        model.addAttribute("aroomList",aroomList);
        model.addAttribute("emp", emp);
        return "emp/update";
    }

    @ResponseBody
    @RequestMapping("updateEmp")
    public Object updateEmp(Emp emp) {
        Message message = new Message();
        try {
            empService.update(emp);
            message.setFlag(true);
        } catch (Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }

    @ResponseBody
    @RequestMapping("delete")
    public Object delete(Integer empId) {
        Message message = new Message();
        try {
            int userId = empService.findOne(empId).getUserId();
            empService.delete(empId);
            userService.delete(userId);
            message.setFlag(true);
        } catch (Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }

    @ResponseBody
    @RequestMapping("resetUpwd")
    public Object resetUpwd(Integer empId) {
        Message message = new Message();
        try {
            Emp emp = empService.findOne(empId);
            empService.update(emp);
            message.setFlag(true);
        } catch (Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }

    @RequestMapping("information")
    public String index(Model model, HttpSession session) {
        Emp emp = (Emp) session.getAttribute("loginUser");
        emp = empService.findOne(emp.getEmpId());
        model.addAttribute("emp", emp);
        return "empinformation";
    }
}

