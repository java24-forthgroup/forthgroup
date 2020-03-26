package com.woniuxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private Integer patientId;
    private Integer roleId;
    private Integer userId;
    private String patientName;
    private Integer patientAge;
    private String patientSex;
    private Integer patientCount;
    private String patientStatus;
}