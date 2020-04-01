package com.woniuxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Croom {
    private Integer croomId;
    private Integer aroomId;
    private String croomCode;
    private String croomAddr;
    private Aroom aroom;
}