package com.woniuxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skillgroup {
    private Integer skillgroupId;
    private Integer sourceId;
    private Integer aroomId;
    private String skillgroupName;
    private Aroom aroom;
    private Skillgroup skillgroup;
    private Source source;

}