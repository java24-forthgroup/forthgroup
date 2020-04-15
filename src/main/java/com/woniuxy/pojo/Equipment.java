package com.woniuxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {
    private Integer equipmentId;
    private Aroom aroom;
    private String equipmentName;
    private String equipmentStatus;
}