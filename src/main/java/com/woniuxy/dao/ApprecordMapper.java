package com.woniuxy.dao;

import com.woniuxy.pojo.Apprecord;

import java.util.Map;

public interface ApprecordMapper {
    void setPatientQueueNum(Map<String, Object> map);

    Apprecord getAroomByProjectId(Integer projectId);

    Apprecord findOne(Integer apprecordId);

    void update(Apprecord apprecord);
}
