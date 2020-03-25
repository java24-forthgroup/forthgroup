package com.woniuxy.pojo;

public class Equipment {
    private Integer equipmentId;

    private Integer aroomId;

    private String equipmentName;

    private String equipmentStatus;

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getAroomId() {
        return aroomId;
    }

    public void setAroomId(Integer aroomId) {
        this.aroomId = aroomId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName == null ? null : equipmentName.trim();
    }

    public String getEquipmentStatus() {
        return equipmentStatus;
    }

    public void setEquipmentStatus(String equipmentStatus) {
        this.equipmentStatus = equipmentStatus == null ? null : equipmentStatus.trim();
    }
}