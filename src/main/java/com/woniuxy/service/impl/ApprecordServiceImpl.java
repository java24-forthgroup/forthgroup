package com.woniuxy.service.impl;

import com.woniuxy.dao.ApprecordMapper;

import com.woniuxy.dao.PatientMapper;
import com.woniuxy.dao.SourceMapper;

import com.woniuxy.pojo.Apprecord;
import com.woniuxy.dao.PatientMapper;
import com.woniuxy.pojo.PageBean;

import com.woniuxy.pojo.Patient;
import com.woniuxy.pojo.Skillgroup;

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
    @Autowired(required = false)
    SourceMapper sourceMapper;
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
    public Integer book(Apprecord apprecord, Skillgroup skillgroup) {

        int count = sourceMapper.queryBySkillgroupId(skillgroup.getSkillgroupId());
        if(count==0){
            return 0;
        }else {
            apprecord.setAttendStatus("否");
            apprecord.setCostStatus("否");
            apprecordMapper.book(apprecord);
            sourceMapper.deductionSource(skillgroup.getSkillgroupId());
            return 1;
        }
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
        return apprecordMapper.findAllByPage(pageBean);
    }

    @Override
    public void delApprecords(Integer[] typeId) {

    }



    @Override
    public List<Apprecord> myBook(PageBean pageBean) {
        return apprecordMapper.myBook(pageBean);
    }
}
