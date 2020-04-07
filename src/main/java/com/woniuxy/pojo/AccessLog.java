package com.woniuxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zhao
 * @create 2020/04/2020/4/2 10:09:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessLog {

    private Integer logid;
    private String  method;
    private String url;
    private String ip;
    private String userName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String addDate;
    private  String status;




}
