package com.woniuxy.service;

import com.woniuxy.pojo.Apprecord;
import com.woniuxy.pojo.Aroom;
import com.woniuxy.pojo.Patient;

import java.util.Map;

public interface ApprecordService {
    void setPatientQueueNum(Map<String, Object> map);
    Apprecord getAroomByProjectId(Integer projectId);
    Apprecord findOne(Integer apprecordId);
    void update(Apprecord apprecord);
}
