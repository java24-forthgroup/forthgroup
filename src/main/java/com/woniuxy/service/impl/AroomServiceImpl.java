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
        return mapper.selectByExample(null);
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
    public void save(Aroom aroom) {
        mapper.insert(aroom);
    }

    @Override
    public Aroom findOne(Integer aroomId) {
        return mapper.selectByPrimaryKey(aroomId);
    }

    @Override
    public void update(Aroom aroom) {
        mapper.updateByPrimaryKey(aroom);
    }

    @Override
    public void delete(Integer aroomId) {
        mapper.deleteByPrimaryKey(aroomId);
    }

}
