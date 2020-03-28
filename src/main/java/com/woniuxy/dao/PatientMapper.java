package com.woniuxy.dao;

import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Patient;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PatientMapper {
    List<Patient> findAll();
    void delete(int typeId);
    void save(Patient patient);
    Patient findOne(int typeId);
    void update (Patient patient);
    List<Patient> findAllByPageBean(PageBean pageBean);

    int countAll(PageBean page);

    void delPatients(Integer[] typeId);
}
