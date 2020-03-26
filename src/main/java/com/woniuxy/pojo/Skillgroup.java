package com.woniuxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skillgroup {
    private Integer skillgroupId;
    private Integer aroomId;
    private Integer sourceId;
    private String skillgroupName;
}