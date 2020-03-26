package com.woniuxy.dao;

import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Source;

import java.util.List;

/**
 * @author zhao
 * @create 2020/03/2020/3/26 18:24:34
 */
public interface SourceMapper {

    List<Source> findAll();

    List<Source> queryByPage(PageBean pageBean);

    int countByPage(PageBean pageBean);

    Source findOne(Integer sourceId);

    void save(Source source);

    void delete(Integer sourceId);

    void update(Source source);

    void deleteSources(Integer[] sourceIds);
}
