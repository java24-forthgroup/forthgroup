package com.woniuxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    private Integer scheduleId;
    private Skillgroup skillgroup;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;

    private String datestart;

    private String datelast;

    private Source source;
}