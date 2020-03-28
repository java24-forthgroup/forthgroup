
package com.woniuxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
    private Integer permissionId;
    private String name;
    private Integer parentId;
    private String url;
    private Boolean open;
    private Boolean checked;
    private List<Permission> children = new ArrayList<Permission>();
}