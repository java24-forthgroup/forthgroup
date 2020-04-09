package com.woniuxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aroom {
    private Integer aroomId;
    private String aroomName;
    private String aroomCode;
    private String aroomAddr;
    
}