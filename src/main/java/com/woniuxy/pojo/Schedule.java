package com.woniuxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    private Integer scheduleId;
    private Integer sourceId;
    private Date date;
    private Date datestart;
    private Date datelast;
}