package com.woniuxy.service.impl;

import com.woniuxy.dao.ApprecordMapper;
import com.woniuxy.dao.EmpMapper;
import com.woniuxy.dao.PatientMapper;
import com.woniuxy.dao.ProjectMapper;
import com.woniuxy.pojo.*;
import com.woniuxy.service.ApprecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    EmpMapper empMapper;
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    PatientMapper patientMapper;

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
    public void save(Apprecord apprecord) {
        apprecordMapper.save(apprecord);
    }

    @Override
    public Map findOne(int apprecordId) {
        Map<String ,Object> result = new HashMap();
        List<Emp> empList = empMapper.findAllDoctor();
        List<Project> projectList = projectMapper.findAll();
        Apprecord apprecord = apprecordMapper.findOne(apprecordId);
        result.put("empList",empList);
        result.put("projectList",projectList);
        result.put("apprecord",apprecord);
        return result ;
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
