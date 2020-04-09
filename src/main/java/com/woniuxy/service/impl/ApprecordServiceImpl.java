package com.woniuxy.service.impl;

import com.woniuxy.dao.ApprecordMapper;
import com.woniuxy.pojo.Apprecord;
import com.woniuxy.service.ApprecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class ApprecordServiceImpl implements ApprecordService {
    @Autowired(required = false)
    ApprecordMapper mapper;

    @Override
    public void setPatientQueueNum(Map<String, Object> map) {
        mapper.setPatientQueueNum(map);
    }

    @Override
    public Apprecord getAroomByProjectId(Integer projectId) {
        return mapper.getAroomByProjectId(projectId);
    }

    @Override
    public Apprecord findOne(Integer apprecordId) {
        return mapper.findOne(apprecordId);
    }

    @Override
    public void update(Apprecord apprecord) {
        mapper.update(apprecord);
    }
}
