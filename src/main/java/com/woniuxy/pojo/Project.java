package com.woniuxy.pojo;

import java.math.BigDecimal;

public class Project {
    private Integer projectId;

    private Integer skillgroupId;

    private Integer equipmentId;

    private String projectName;

    private BigDecimal projectCost;

    private String projectComment;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getSkillgroupId() {
        return skillgroupId;
    }

    public void setSkillgroupId(Integer skillgroupId) {
        this.skillgroupId = skillgroupId;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public BigDecimal getProjectCost() {
        return projectCost;
    }

    public void setProjectCost(BigDecimal projectCost) {
        this.projectCost = projectCost;
    }

    public String getProjectComment() {
        return projectComment;
    }

    public void setProjectComment(String projectComment) {
        this.projectComment = projectComment == null ? null : projectComment.trim();
    }
}