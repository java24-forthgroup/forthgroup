package com.woniuxy.service.impl;

import com.woniuxy.dao.SourcetypeMapper;
import com.woniuxy.pojo.Sourcetype;
import com.woniuxy.service.SourceService;
import com.woniuxy.service.SourcetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhao
 * @create 2020/03/2020/3/26 23:52:03
 */
@Service
@Transactional
public class SourcetypeImpl implements SourcetypeService {
    @Autowired(required = false)
    SourcetypeMapper sourcetypeMapper;
    @Override
    public List<Sourcetype> findAll() {
        return sourcetypeMapper.findAll();
    }

    @Override
    public Sourcetype findOne(Integer typeId) {
        return sourcetypeMapper.findOne(typeId);
    }
}
