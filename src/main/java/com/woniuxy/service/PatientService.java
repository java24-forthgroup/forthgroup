package com.woniuxy.service;

import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Patient;
import com.woniuxy.pojo.User;

import java.util.List;

public interface PatientService {
    //查全部
    List<Patient> findAll();
    //删除
    void delete(int typeId);
    //添加
    void save(Patient patient, User user);
    //通过patientId 查找 患者
    Patient findOne(int patientId);
    //修改
    void update (Patient patient);
    //条件查所有
    List<Patient> findAllByPageBean(PageBean pageBean);
    //总共多少条数据
    int countAll(PageBean page);

    void delPatients(Integer[] typeId);
    //通过userId查患者
    Patient findPatientByUserId(Integer userId);
}

