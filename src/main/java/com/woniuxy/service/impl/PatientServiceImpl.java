package com.woniuxy.service.impl;

import com.woniuxy.dao.EmpMapper;
import com.woniuxy.dao.PatientMapper;
import com.woniuxy.dao.ProjectMapper;
import com.woniuxy.dao.UserMapper;
import com.woniuxy.pojo.*;
import com.woniuxy.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired(required = false)
    PatientMapper patientMapper;
    @Autowired(required = false)
    UserMapper userMapper;
    @Autowired(required = false)
    EmpMapper empMapper;
    @Autowired(required = false)
    ProjectMapper projectMapper;

    @Override
    public List<Patient> findAll() {
        return patientMapper.findAll();
    }

    @Override
    public void delete(int typeId) {
        patientMapper.delete(typeId);
    }

    @Override
    public void save(Patient patient, User user) {
        userMapper.save(user);
        user = userMapper.findOneByUname(user.getUname());
        patient.setUserId(user.getUserId());
        patient.setPatientStatus("否");
        patient.setPatientCount(0);
        patient.setRoleId(4);
        patientMapper.save(patient);
    }

    @Override
    public Patient findOne(int typeId) {
        return patientMapper.findOne(typeId);
    }

    @Override
    public void update(Patient patient) {
        patientMapper.update(patient);
    }

    @Override
    public List<Patient> findAllByPageBean(PageBean pageBean) {
        return patientMapper.findAllByPageBean(pageBean);
    }

    @Override
    public int countAll(PageBean page) {
        return patientMapper.countAll(page);
    }

    @Override
    public void delPatients(Integer[] typeId) {
    }
    @Override
    public Patient findPatientByUserId(Integer userId) {
        Patient patient = patientMapper.findPatientByUserId(userId);
        return patient;
    }

}
