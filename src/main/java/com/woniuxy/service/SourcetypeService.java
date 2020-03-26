package com.woniuxy.service;

import com.woniuxy.pojo.Sourcetype;

import java.util.List;

/**
 * @author zhao
 * @create 2020/03/2020/3/26 23:51:29
 */
public interface SourcetypeService {

    List<Sourcetype> findAll();

    Sourcetype findOne(Integer typeId);
}
