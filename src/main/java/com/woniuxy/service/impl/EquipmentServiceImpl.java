package com.woniuxy.service.impl;

import com.woniuxy.dao.EquipmentMapper;
import com.woniuxy.pojo.Equipment;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.service.EquipmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService{
    @Resource
    private EquipmentMapper equipmentMapper;

    @Override
    public void save(Equipment equipment) {
        equipmentMapper.save(equipment);

    }

    @Override
    public void update(Equipment equipment) {
        equipmentMapper.update(equipment);

    }

    @Override
    public void delete(Integer equipmentId) {
        equipmentMapper.delete(equipmentId);
    }

    @Override
    public Equipment findOne(Integer equipmentId) {
        return equipmentMapper.findOne(equipmentId);
    }

    @Override
    public List<Equipment> findAll() {
        return equipmentMapper.findAll();
    }

    @Override
    public List<Equipment> selectByPage(PageBean<Equipment> pageBean) {
        return equipmentMapper.selectByPage(pageBean);
    }

    @Override
    public int countAll() {
        return equipmentMapper.countAll();
    }

    @Override
    public void deletes(Integer[] equipmentId) {
        equipmentMapper.deletes(equipmentId);
    }
}
