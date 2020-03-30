package com.woniuxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apprecord {
    private Integer apprecordId;
    private Emp emp;
    private Project project;
    private Patient patient;
    private String attendStatus;
    private String costStatus;

}