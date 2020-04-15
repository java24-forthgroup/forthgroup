package com.woniuxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private Integer projectId;
    private Integer skillgroupId;
    private Integer equipmentId;
    private Skillgroup skillgroup;
    private Equipment equipment;
    private String projectName;
    private BigDecimal projectCost;
    private String projectComment;
}