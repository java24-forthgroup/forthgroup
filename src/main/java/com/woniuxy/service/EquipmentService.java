package com.woniuxy.service;

import com.woniuxy.pojo.Equipment;
import com.woniuxy.pojo.PageBean;

import java.util.List;

public interface EquipmentService {
    void save(Equipment obj);
    void update(Equipment obj);
    void delete(Integer equipmentId);
    Equipment findOne(Integer equipmentId);
    List<Equipment> findAll();


    List<Equipment> selectByPage(PageBean<Equipment> pageBean);

    int countAll();

    void deletes(Integer[] equipmentId);
}
