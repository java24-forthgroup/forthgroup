package com.woniuxy.service.impl;

import com.woniuxy.dao.SkillgroupMapper;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Skillgroup;
import com.woniuxy.service.SkillgroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhao
 * @create 2020/03/2020/3/26 23:15:21
 */
@Service
@Transactional
public class SkillgroupServiceImpl implements SkillgroupService {

    @Autowired(required = false)
    SkillgroupMapper skillgroupMapper;

    @Override
    public List<Skillgroup> findAll() {
        return skillgroupMapper.findAll();
    }

    @Override
    public List<Skillgroup> selectByPage(PageBean<Skillgroup> pageBean) {
        return skillgroupMapper.selectByPage(pageBean);
    }

    @Override
    public int countAll(PageBean<Skillgroup> pageBean) {
        return skillgroupMapper.countAll(pageBean);
    }

    @Override
    public void save(Skillgroup Skillgroup) {
        skillgroupMapper.save(Skillgroup);
    }

    @Override
    public Skillgroup findOne(Integer SkillgroupId) {
        return skillgroupMapper.findOne(SkillgroupId);
    }

    @Override
    public void update(Skillgroup Skillgroup) {
        skillgroupMapper.update(Skillgroup);
    }

    @Override
    public void delete(Integer SkillgroupId) {
        skillgroupMapper.delete(SkillgroupId);
    }

    @Override
    public Integer queryDoctorBySkillgroup(Integer skillgroupId) {
        return skillgroupMapper.queryDoctorBySkillgroup(skillgroupId);
    }
}
