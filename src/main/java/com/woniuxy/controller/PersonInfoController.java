package com.woniuxy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.pojo.Emp;
import com.woniuxy.pojo.Patient;
import com.woniuxy.pojo.User;
import com.woniuxy.service.EmpService;
import com.woniuxy.service.PatientService;
import com.woniuxy.service.PermissionService;
import com.woniuxy.service.RoleService;
import com.woniuxy.service.UserService;

/**
 * @author AriesBn
 */
@Controller
@RequestMapping("Info")
public class PersonInfoController {
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	EmpService empService;
	@Autowired
	PatientService patientService;
	@Autowired
	PermissionService permissionService;
	
	//根据不同的角色跳到不同的页面
	@RequestMapping("PersonInfo")
	public String getPersionInfo(HttpServletRequest req,Model model){
		User loginUser = (User) req.getSession().getAttribute("loginUser");
		String roleName=roleService.findAssignRolesByUserId(loginUser.getUserId()).get(0).getRoleName();
		model.addAttribute("roleName", roleName);
		if(roleName.equals("患者")){
			model.addAttribute("patientInfo", patientService.findPatientByUserId(loginUser.getUserId()));
			return "personInfo/patientInfo";
		}
		if(roleName.equals("系统管理员")){
			return "personInfo/adminInfo";
		}
		model.addAttribute("empInfo", empService.findOneDoctorByUserId(loginUser.getUserId()));
		return "personInfo/empInfo";
	}
	
	//个人密码修改界面
	@RequestMapping("PwdEdit")
	public String PwdEditJsp(Integer userId,Model model){
		model.addAttribute("findUser", userService.findUserById(userId));
		return "personInfo/pwdEdit";
	}
	//确定密码修改
	@RequestMapping("PwdEditSubmit")
	@ResponseBody
	public String PwdEditJsp(User userEdit){
		userService.update(userEdit);
		return "ok";
	}
}
