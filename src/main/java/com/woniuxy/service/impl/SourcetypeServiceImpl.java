package com.woniuxy.service.impl;

import com.woniuxy.dao.SourcetypeMapper;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Sourcetype;
import com.woniuxy.service.SourcetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SourcetypeServiceImpl implements SourcetypeService {
    @Autowired(required = false)
    SourcetypeMapper sourcetypeMapper;

    @Override
    public List<Sourcetype> findAll() {
        return sourcetypeMapper.findAll();
    }

    @Override
    public void delete(int typeId) {
        sourcetypeMapper.delete(typeId);
    }

    @Override
    public void save(Sourcetype sourcetype) {
        sourcetypeMapper.save(sourcetype);
    }

    @Override
    public Sourcetype findOne(int typeId) {
        return sourcetypeMapper.findOne(typeId);
    }

    @Override
    public void update(Sourcetype sourcetype) {
        sourcetypeMapper.update(sourcetype);
    }

    @Override
    public List<Sourcetype> findAllByPageBean(PageBean pageBean) {
        return sourcetypeMapper.findAllByPageBean(pageBean);
    }

    @Override
    public int countAll(PageBean page) {
        return sourcetypeMapper.countAll(page);
    }

    @Override
    public void delSourcetypes(Integer[] typeId) {
        sourcetypeMapper.delSourcetypes(typeId);
    }
}
