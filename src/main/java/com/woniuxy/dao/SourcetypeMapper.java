package com.woniuxy.dao;

import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Source;
import com.woniuxy.pojo.Sourcetype;

import java.util.List;

/**
 * @author zhao
 * @create 2020/03/2020/3/26 23:41:15
 */
public interface SourcetypeMapper {

    List<Sourcetype> findAll();

    Sourcetype findOne(Integer typeId);
}
