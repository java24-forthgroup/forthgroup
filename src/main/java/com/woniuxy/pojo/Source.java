package com.woniuxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Source {
    private Integer sourceId;
    private Integer queueId;
    private Integer skillgroupId;
    private Integer typeId;
    private Integer sourceNum;

    //表中对应的对象类型
    private Queue queue;
    private  Skillgroup skillgroup;
    private  Sourcetype sourcetype;
}