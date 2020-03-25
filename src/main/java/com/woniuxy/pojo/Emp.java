package com.woniuxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer empId;
    private Integer aroomId;
    private Integer userId;
    private String empName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date empBirthday;
    private String empGrade;

}