package com.woniuxy.service.impl;

import java.util.List;
import java.util.Map;

import com.woniuxy.dao.RoleMapper;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Role;
import com.woniuxy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired(required = false)
	RoleMapper mapper;

	@Override
	public List<Role> selectByPage(PageBean<Role> pageBean) {
		// TODO Auto-generated method stub
		return mapper.selectByPage(pageBean);
	}

	@Override
	public int countByPage(PageBean<Role> pageBean) {
		// TODO Auto-generated method stub
		return mapper.countByPage(pageBean);
	}

	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
		mapper.save(role);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

	@Override
	public List<Role> selectRolesByUid(Integer uid) {
		// TODO Auto-generated method stub
		return mapper.selectRolesByUid(uid);
	}

	@Override
	public void assignPermission(Map<String, Object> map) {
		// TODO Auto-generated method stub
		mapper.deleteAssignPermissionByRid(map.get("roleId"));
		mapper.assignPermission(map);
		
	}

	@Override
	public List<Integer> findByRid(Integer rid) {
		// TODO Auto-generated method stub
		return mapper.findByRid(rid);
	}

	@Override
	public Role findOne(Integer rid) {
		// TODO Auto-generated method stub
		return mapper.findOne(rid);
	}

	@Override
	public void update(Role role) {
		mapper.update(role);
	}

	@Override
	public void delete(Integer rid) {
        mapper.delete(rid);
	}
}
