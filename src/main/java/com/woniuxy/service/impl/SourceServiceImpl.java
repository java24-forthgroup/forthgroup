package com.woniuxy.service.impl;

import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Source;
import com.woniuxy.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhao
 * @create 2020/03/2020/3/26 18:25:50
 */
@Service
@Transactional
public class SourceServiceImpl implements SourceService {
    @Autowired
    SourceService sourceService;

    @Override
    public List<Source> findAll() {
        return sourceService.findAll();
    }

    @Override
    public List<Source> queryByPage(PageBean pageBean) {
        return sourceService.queryByPage(pageBean);
    }

    @Override
    public int countByPage(PageBean pageBean) {
        return sourceService.countByPage(pageBean);
    }

    @Override
    public Source findOne(Integer SourceId) {
        return sourceService.findOne(SourceId);
    }

    @Override
    public void save(Source source) {
        sourceService.save(source);
    }

    @Override
    public void delete(Integer SourceId) {
        sourceService.delete(SourceId);
    }

    @Override
    public void update(Source source) {
        sourceService.update(source);
    }
}
