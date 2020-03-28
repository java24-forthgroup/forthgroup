package com.woniuxy.controller;

import com.woniuxy.pojo.Message;
import com.woniuxy.pojo.Permission;
import com.woniuxy.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("permission")
public class PermissionController {

	@Autowired
	PermissionService permissionService;
	@RequestMapping("index")
	public String index() {
		return "permission/index";
	}
	@RequestMapping("save")
	public String save(Integer permissionId,Model model) {
		model.addAttribute("permissionId",permissionId);
		return "permission/save";
	}
	@RequestMapping("update")
	public String update(Integer permissionId,Model model) {
		Permission permission = permissionService.findOne(permissionId);
		model.addAttribute("permission", permission);
		return "permission/update";
	}

	@ResponseBody
	@RequestMapping("savePermission")
	public Object savePermission(Permission permission) {
		Message message = new Message();
		try {
			permissionService.save(permission);
			message.setFlag(true);
		}catch(Exception e) {
			e.printStackTrace();
			message.setFlag(false);
		}
		return message;
	}
	@ResponseBody
	@RequestMapping("delete")
	public Object delete(Integer permissionId) {
		Message message = new Message();
		try {
			permissionService.delete(permissionId);
			message.setFlag(true);
		}catch(Exception e) {
			e.printStackTrace();
			message.setFlag(false);
		}
		return message;
	}
	@ResponseBody
	@RequestMapping("updatePermission")
	public Object updateePermission(Permission permission) {
		Message message = new Message();
		try {
			System.out.println(permission);
			permissionService.update(permission);
			message.setFlag(true);
		}catch(Exception e) {
			e.printStackTrace();
			message.setFlag(false);
		}
		return message;
	}
	@ResponseBody
	@RequestMapping("loadData")
	public Object loadData() {

		List<Permission> permissionList = permissionService.findAll();
		List<Permission> zTree = new ArrayList<Permission>();
		
		Map<Integer,Permission> map = new HashMap<Integer,Permission>();
		for (Permission permission : permissionList) {
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
	
	public void queryZTree(Permission permission) {

		List<Permission> children = permissionService.selectByParentid(permission.getPermissionId());
		if(children!=null) {
			for(Permission child:children) {
				queryZTree(child);
			}
		}
		permission.setChildren(children);
	}
}
