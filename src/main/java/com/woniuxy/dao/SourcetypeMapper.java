package com.woniuxy.dao;

import com.woniuxy.pojo.PageBean;

import com.woniuxy.pojo.Sourcetype;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface SourcetypeMapper {
    List<Sourcetype> findAll();
    void delete(int typeId);
    void save(Sourcetype sourcetype);
    Sourcetype findOne(int typeId);
    void update (Sourcetype sourcetype);
    List<Sourcetype> findAllByPageBean(PageBean pageBean);

    int countAll(PageBean page);

    void delSourcetypes(Integer[] typeId);

}
