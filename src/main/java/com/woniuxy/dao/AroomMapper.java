package com.woniuxy.dao;

import com.woniuxy.pojo.Aroom;
import com.woniuxy.pojo.PageBean;

import java.util.List;

public interface AroomMapper {
    List<Aroom> findAll();

    List<Aroom> selectByPage(PageBean<Aroom> pageBean);

    int countAll(PageBean<Aroom> pageBean);

    void save(Aroom Aroom);

    Aroom findOne(Integer AroomId);

    void update(Aroom Aroom);

    void delete(Integer AroomId);
}
