package com.woniuxy.service.impl;

import com.woniuxy.dao.SourceMapper;
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
    @Autowired(required = false)
    SourceMapper sourceMapper;

    @Override
    public List<Source> findAll() {
        return sourceMapper.findAll();
    }

    @Override
    public List<Source> queryByPage(PageBean pageBean) {
        return sourceMapper.queryByPage(pageBean);
    }

    @Override
    public int countByPage(PageBean pageBean) {
        return sourceMapper.countByPage(pageBean);
    }

    @Override
    public Source findOne(Integer sourceId) {
        return sourceMapper.findOne(sourceId);
    }

    @Override
    public void save(Source source) {
        sourceMapper.save(source);
    }

    @Override
    public void delete(Integer sourceId) {
        sourceMapper.delete(sourceId);
    }

    @Override
    public void update(Source source) {
        sourceMapper.update(source);
    }

    @Override
    public void deleteSources(Integer[] sourceIds) {
        sourceMapper.deleteSources(sourceIds);
    }

    @Override
    public int queryBySkillgroupId(Integer skillgroup) {
        return sourceMapper.queryBySkillgroupId(skillgroup);
    }
}
