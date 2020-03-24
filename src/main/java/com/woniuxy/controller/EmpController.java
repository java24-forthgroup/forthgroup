package com.woniuxy.controller;

import com.woniuxy.pojo.Emp;
import com.woniuxy.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("emp")
public class EmpController {
    @Autowired
    EmpService empService;

    //展示所有员工信息，不带分页
    @RequestMapping("index")
    public String index(Model model) {
        System.out.println("dev分支提交");
        List<Emp> empList = empService.findAll();
        model.addAttribute("empList", empList);
        for (Emp e:empList){
            System.out.println(e);
        }
        return "emplist";
    }
}
