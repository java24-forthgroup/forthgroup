package com.woniuxy.dao;

import com.woniuxy.pojo.Equipment;
import com.woniuxy.pojo.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentMapper {
    void save(Equipment obj);
    void update(Equipment obj);
    void delete(Integer equipmentId);
    Equipment findOne(Integer equipmentId);
    List<Equipment> findAll();


    List<Equipment> selectByPage(PageBean<Equipment> pageBean);

    int countAll();

    void deletes(Integer[] equipmentId);
}
