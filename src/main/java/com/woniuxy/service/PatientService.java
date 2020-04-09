package com.woniuxy.service;

import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Patient;
import com.woniuxy.pojo.User;

import java.util.List;

public interface PatientService {
    List<Patient> findAll();
    void delete(int typeId);
    void save(Patient patient, User user);
    Patient findOne(int typeId);
    void update (Patient patient);
    List<Patient> findAllByPageBean(PageBean pageBean);

    int countAll(PageBean page);

    void delPatients(Integer[] typeId);

}

