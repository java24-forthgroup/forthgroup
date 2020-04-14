package com.woniuxy.service.impl;

import com.woniuxy.dao.ApprecordMapper;
import com.woniuxy.dao.PatientMapper;
import com.woniuxy.dao.SourceMapper;
import com.woniuxy.pojo.Apprecord;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Skillgroup;
import com.woniuxy.service.ApprecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @auther: 秦浦华
 * @DATE: 2020/3/28   16:27
 */
@Service
@Transactional
public class ApprecordServiceImpl implements ApprecordService {
    @Autowired
    ApprecordMapper apprecordMapper;
    @Autowired
    PatientMapper patientMapper;
    @Autowired
    SourceMapper sourceMapper;
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
        patientMapper.update(apprecord.getPatient());
        apprecordMapper.update(apprecord);
    }

    @Override
    public List<Apprecord> findAllByPageBean(PageBean pageBean) {
        return apprecordMapper.findAllByPageBean(pageBean);
    }



    @Override
    public void delApprecords(Integer[] typeId) {

    }
}
