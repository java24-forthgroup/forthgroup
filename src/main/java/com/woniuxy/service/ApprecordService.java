package com.woniuxy.service;

import com.woniuxy.pojo.Apprecord;
import com.woniuxy.pojo.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @auther: 秦浦华
 * @DATE: 2020/3/28   16:27
 */
public interface ApprecordService {
    int countAll(PageBean pageBean);

    List<Apprecord> findAllByPage(PageBean pageBean);
    List<Apprecord> findAll();
    void delete(int apprecordId);
    void book(Apprecord apprecord);
    Map findOne(int apprecordId);
    void update (Apprecord apprecord);
    List<Apprecord> findAllByPageBean(PageBean pageBean);

    void delApprecords(Integer[] typeId);
}
