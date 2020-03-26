package com.woniuxy.dao;

import com.woniuxy.pojo.Skillgroup;
import com.woniuxy.pojo.PageBean;

import java.util.List;

/**
 * @author zhao
 * @create 2020/03/2020/3/26 23:17:33
 */
public interface SkillgroupMapper {

    List<Skillgroup> findAll();

    List<Skillgroup> selectByPage(PageBean<Skillgroup> pageBean);

    int countAll(PageBean<Skillgroup> pageBean);

    void save(Skillgroup Skillgroup);

    Skillgroup findOne(Integer SkillgroupId);

    void update(Skillgroup Skillgroup);

    void delete(Integer SkillgroupId);
    
}
