package com.woniuxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Queue {
    private Integer queueId;
    private Integer queueNum;
    private Integer aroomId;
    private String patientStatus;
    private Aroom aroom;
    private Patient patient;

    public Queue(Integer queueId,Integer queueNum,Integer aroomId){
        this.queueId=queueId;
        this.queueNum=queueNum;
        this.aroomId=aroomId;
    }
}