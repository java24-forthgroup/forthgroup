package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.dao.CroomMapper;
import com.woniuxy.pojo.Croom;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.service.CroomService;

/**
 * @author AriesBn
 * @date: 2020年3月26日 下午4:51:00
 */
@Service
public class CroomServiceImpl implements CroomService {
	@Autowired
	CroomMapper mapper;
	@Override
	public List<Croom> findAll() {
		return mapper.selectByExample(null);
	}

	@Override
	public List<Croom> selectByPage(PageBean<Croom> pageBean) {
		return mapper.selectByPage(pageBean);
	}

	@Override
	public int countAll(PageBean<Croom> pageBean) {
		return mapper.countAll(pageBean);
	}

	@Override
	public void save(Croom croom) {
		mapper.insert(croom);
	}

	@Override
	public Croom findOne(Integer croomId) {
		return mapper.selectByPrimaryKey(croomId);
	}

	@Override
	public void update(Croom croom) {
		mapper.updateByPrimaryKey(croom);
	}

	@Override
	public void delete(Integer croomId) {
		mapper.deleteByPrimaryKey(croomId);
	}

}
