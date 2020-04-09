package com.woniuxy.service.impl;

import com.woniuxy.dao.ApprecordMapper;
import com.woniuxy.pojo.Apprecord;
import com.woniuxy.dao.PatientMapper;
import com.woniuxy.pojo.PageBean;

import com.woniuxy.service.ApprecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ApprecordServiceImpl implements ApprecordService {
    @Autowired(required = false)
    ApprecordMapper apprecordMapper;
    @Autowired(required = false)
    PatientMapper patientMapper;

    @Override
    public void setPatientQueueNum(Map<String, Object> map) {
        apprecordMapper.setPatientQueueNum(map);
    }

    @Override
    public List<Apprecord> getAroomByProjectId(Integer projectId) {
        return apprecordMapper.getAroomByProjectId(projectId);
    }

    @Override
    public Apprecord findOne(Integer apprecordId) {
        return apprecordMapper.findOne(apprecordId);
    }

    @Override
    public int countAll(PageBean pageBean) {
        return apprecordMapper.countAll(pageBean);
    }

    @Override
    public List<Apprecord> findAllByPage(PageBean pageBean) {
        return apprecordMapper.findAllByPage(pageBean);
    }

    @Override
    public List<Apprecord> findAll() {
        return apprecordMapper.findAll();
    }

    @Override
    public void delete(int apprecordId) {
        apprecordMapper.delete(apprecordId);
    }

    @Override
    public void book(Apprecord apprecord) {
        apprecord.setAttendStatus("否");
        apprecord.setCostStatus("否");
        apprecordMapper.book(apprecord);
    }

    @Override
    public Apprecord findOne(int apprecordId) {
        Apprecord apprecord = apprecordMapper.findOne(apprecordId);
        return apprecord ;
    }

    @Override
    public void update(Apprecord apprecord) {
        apprecordMapper.update(apprecord);
        //patientMapper.update(apprecord.getPatient());
        //apprecordMapper.update(apprecord);
    }

    @Override
    public List<Apprecord> findAllByPageBean(PageBean pageBean) {
        return apprecordMapper.findAllByPageBean(pageBean);
    }

    @Override
    public void delApprecords(Integer[] typeId) {

    }
}
