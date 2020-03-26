package com.woniuxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    private Integer scheduleId;
    private Integer sourceId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Date datestart;
    private Date datelast;
}