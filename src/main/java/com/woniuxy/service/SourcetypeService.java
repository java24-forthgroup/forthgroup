package com.woniuxy.service;

import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Sourcetype;

import java.util.List;

public interface SourcetypeService {
    List<Sourcetype> findAll();
    void delete(int typeId);
    void save(Sourcetype sourcetype);
    Sourcetype findOne(int typeId);
    void update (Sourcetype sourcetype);
    List<Sourcetype> findAllByPageBean(PageBean pageBean);

    int countAll(PageBean page);

    void delSourcetypes(Integer[] typeId);
}
