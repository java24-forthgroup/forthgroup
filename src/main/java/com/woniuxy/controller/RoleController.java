package com.woniuxy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.woniuxy.pojo.Message;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Permission;
import com.woniuxy.pojo.Role;
import com.woniuxy.service.PermissionService;
import com.woniuxy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("role")
public class RoleController {
	@Autowired
	RoleService roleService;
	@Autowired
	PermissionService permissionService;
	@RequestMapping("index")
	public String index() {
		return "role/index";
	}
	@RequestMapping("save")
	public String save() {
		return "role/save";
	}
	@RequestMapping("assignPermission")
	public String assignPermission(Integer roleId,Model model) {
		model.addAttribute("roleId", roleId);
		return "role/assignPermission";
	}
	@ResponseBody
	@RequestMapping("loadData")
	public Object loadData(Integer roleId) {

		List<Permission> permissionList = permissionService.findAll();
		//通过roleId在rolepermission中查出对应所有的permissionId
		List<Integer> assignPermissionIds =  roleService.findByRid(roleId);
		List<Permission> zTree = new ArrayList<Permission>();

		Map<Integer,Permission> map = new HashMap<Integer,Permission>();
		for (Permission permission : permissionList) {
			if(assignPermissionIds.contains(permission.getPermissionId())) {
				permission.setChecked(true);
			}else {
				permission.setChecked(false);
			}
			map.put(permission.getPermissionId(), permission);
		}
		
		for (Permission permission : permissionList) {
			permission.setOpen(true);
			if(permission.getParentId()==null) {
				zTree.add(permission);
			}else {
				Permission p = map.get(permission.getParentId());
				p.getChildren().add(permission);
			}
		}
		
		return zTree;
	}
	@ResponseBody
	@RequestMapping("indexByPage")
	public Object indexByPage(PageBean<Role> pageBean) {
		Message message = new Message();
		try {
			List<Role> roleList = roleService.selectByPage(pageBean);
			int countRow = roleService.countByPage(pageBean);
			pageBean.setCountRow(countRow);
			pageBean.setCountPage(countRow%pageBean.getPageRow()==0?countRow/pageBean.getPageRow():countRow/pageBean.getPageRow()+1);
			pageBean.setList(roleList);
			message.setObj(pageBean);
			message.setFlag(true);
		}catch(Exception e) {
			e.printStackTrace();
			message.setFlag(false);
		}
		return message;
	}
	@ResponseBody
	@RequestMapping("saveRole")
	public Object saveRole(Role role) {
		Message message = new Message();
		try {
			roleService.save(role);
			message.setFlag(true);
		}catch(Exception e) {
			e.printStackTrace();
			message.setFlag(false);
		}
		return message;
	}
	@ResponseBody
	@RequestMapping("assignPermissionDo")
	public Object assignPermissionDo(Integer roleId,Integer[] permissionIds) {
		Message message = new Message();
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("roleId", roleId);
			map.put("permissionIds", permissionIds);
			roleService.assignPermission(map);
			message.setFlag(true);
		}catch(Exception e) {
			e.printStackTrace();
			message.setFlag(false);
		}
		return message;
	}

	@RequestMapping("update")
	public String update(Integer roleId, Model model) {
		Role role = roleService.findOne(roleId);
		model.addAttribute("role", role);
		return "role/update";
	}

	@ResponseBody
	@RequestMapping("updateRole")
	public Object updateRole(Role role) {
		System.out.println(role);
		Message message = new Message();
		try {
			roleService.update(role);
			message.setFlag(true);
		} catch (Exception e) {
			e.printStackTrace();
			message.setFlag(false);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping("delete")
	public Object delete(Integer roleId) {
		Message message = new Message();
		try {
			roleService.delete(roleId);
			message.setFlag(true);
		} catch (Exception e) {
			e.printStackTrace();
			message.setFlag(false);
		}
		return message;
	}

}
