package com.woniuxy.service;

import com.woniuxy.pojo.Apprecord;
import com.woniuxy.pojo.PageBean;

import java.util.List;
import java.util.Map;

public interface ApprecordService {
    void setPatientQueueNum(Map<String, Object> map);
    Apprecord getAroomByProjectId(Integer projectId);
    Apprecord findOne(Integer apprecordId);
    int countAll(PageBean pageBean);
    List<Apprecord> findAllByPage(PageBean pageBean);
    List<Apprecord> findAll();
    void delete(int apprecordId);
    void book(Apprecord apprecord);
    Apprecord findOne(int apprecordId);
    void update (Apprecord apprecord);
    List<Apprecord> findAllByPageBean(PageBean pageBean);
    void delApprecords(Integer[] typeId);
}
