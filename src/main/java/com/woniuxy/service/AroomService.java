package com.woniuxy.service;

import com.woniuxy.pojo.Aroom;
import com.woniuxy.pojo.PageBean;

import java.util.List;

public interface AroomService {
    List<Aroom> findAll();

    List<Aroom> selectByPage(PageBean<Aroom> pageBean);

    int countAll(PageBean<Aroom> pageBean);

    void save(Aroom Aroom);

    Aroom findOne(Integer eid);

    void update(Aroom Aroom);

    void delete(Integer eid);

}
