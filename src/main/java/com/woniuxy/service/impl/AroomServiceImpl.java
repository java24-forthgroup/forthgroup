package com.woniuxy.service.impl;

import com.woniuxy.dao.AroomMapper;
import com.woniuxy.pojo.Aroom;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.service.AroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AroomServiceImpl implements AroomService {
    @Autowired(required = false)
    AroomMapper mapper;

    @Override
    public List<Aroom> findAll() {
        return mapper.findAll();
    }

    @Override
    public List<Aroom> selectByPage(PageBean<Aroom> pageBean) {
        return mapper.selectByPage(pageBean);
    }

    @Override
    public int countAll(PageBean<Aroom> pageBean) {
        return mapper.countAll(pageBean);
    }

    @Override
    public void save(Aroom Aroom) {
        mapper.save(Aroom);
    }

    @Override
    public Aroom findOne(Integer AroomId) {
        return mapper.findOne(AroomId);
    }

    @Override
    public void update(Aroom Aroom) {
        mapper.update(Aroom);
    }

    @Override
    public void delete(Integer AroomId) {
        mapper.delete(AroomId);
    }

}
