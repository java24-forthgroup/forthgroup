package com.woniuxy.service;

import java.util.List;

import com.woniuxy.pojo.Croom;
import com.woniuxy.pojo.PageBean;

/**
 * @author AriesBn
 * @date: 2020年3月26日 下午4:47:12
 */
public interface CroomService {
    List<Croom> findAll();

    List<Croom> selectByPage(PageBean<Croom> pageBean);

    int countAll(PageBean<Croom> pageBean);

    void save(Croom Croom);

    Croom findOne(Integer eid);

    void update(Croom Croom);

    void delete(Integer eid);
}
