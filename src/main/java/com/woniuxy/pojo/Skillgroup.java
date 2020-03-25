package com.woniuxy.pojo;

public class Skillgroup {
    private Integer skillgroupId;

    private Integer aroomId;

    private Integer sourceId;

    private String skillgroupName;

    public Integer getSkillgroupId() {
        return skillgroupId;
    }

    public void setSkillgroupId(Integer skillgroupId) {
        this.skillgroupId = skillgroupId;
    }

    public Integer getAroomId() {
        return aroomId;
    }

    public void setAroomId(Integer aroomId) {
        this.aroomId = aroomId;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public String getSkillgroupName() {
        return skillgroupName;
    }

    public void setSkillgroupName(String skillgroupName) {
        this.skillgroupName = skillgroupName == null ? null : skillgroupName.trim();
    }
}