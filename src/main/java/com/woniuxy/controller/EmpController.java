package com.woniuxy.controller;

import com.woniuxy.pojo.*;
import com.woniuxy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("emp")
public class EmpController {
    @Autowired
    EmpService empService;
    @Autowired
    AroomService aroomService;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    SkillgroupService skillgroupService;

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
    public Object saveEmp(Emp emp,User user) {
        Message message = new Message();
        try {
            user.setUpwd("123");
            userService.save(user);
            System.out.println("添加用户成功");
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
            empService.delete(empId);
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

    @RequestMapping("assignRole")
    public String assignRole(Integer empId, Model model) {
        // 通过员工I获得对应的userId
        int userId = empService.findUserIdByempId(empId);
        // 获得已分配角色
        List<Role> assignRoles = roleService.findAssignRolesByUserId(userId);
        // 声明长度为已分配角色数量长度的数组
        Integer[] rids = new Integer[assignRoles.size()];
        // 声明存放位置
        int i = 0;
        // 遍历所有已分配角色,将对应的rid存放在rids[]中
        for (Role role : assignRoles) {
            rids[i++] = role.getRoleId();
        }
        // 获得未分配角色
        List<Role> unAssignRoles = roleService.findUnAssignRolesByUserId(rids);

        model.addAttribute("unAssignRoles", unAssignRoles);
        model.addAttribute("assignRoles", assignRoles);
        model.addAttribute("userId", userId);
        return "emp/assignRole";
    }

    @ResponseBody
    @RequestMapping("assignRoleDo")
    public Object assignRoleDo(Integer userId, Integer[] rightRids) {
        Message message = new Message();
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userId", userId);
            map.put("rids", rightRids);
            userService.assignRoles(map);
            message.setFlag(true);
        } catch (Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }

    @ResponseBody
    @RequestMapping("removeRole")
    public Object removeRole(Integer userId, Integer[] leftRids) {
        Message message = new Message();
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userId", userId);
            map.put("rids", leftRids);
            userService.removeRoles(map);
            message.setFlag(true);
        } catch (Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }
    @RequestMapping("queryDoctorBySkillgroup")
    @ResponseBody
    public List queryBySkillgroup(Integer skillgroupId){
        List<Emp> empList =null;
        try {
            Integer aroomId =  skillgroupService.queryDoctorBySkillgroup(skillgroupId);
            empList = empService.queryDoctorByAroomId(aroomId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(empList);
        return empList;
    }
}