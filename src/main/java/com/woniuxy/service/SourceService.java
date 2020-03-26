package com.woniuxy.service;

import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Source;

import java.util.List;

/**
 * @author zhao
 * @create 2020/03/2020/3/26 18:25:15
 */
public interface SourceService {

    List<Source> findAll();

    List<Source> queryByPage(PageBean pageBean);

    int countByPage(PageBean pageBean);

    Source findOne(Integer SourceId);

    void save(Source source);

    void delete(Integer SourceId);

    void update(Source source);
    
}
