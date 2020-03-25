package com.woniuxy.pojo;

public class Croom {
    private Integer croomId;

    private Integer aroomId;

    private String croomCode;

    private String croomAddr;

    public Integer getCroomId() {
        return croomId;
    }

    public void setCroomId(Integer croomId) {
        this.croomId = croomId;
    }

    public Integer getAroomId() {
        return aroomId;
    }

    public void setAroomId(Integer aroomId) {
        this.aroomId = aroomId;
    }

    public String getCroomCode() {
        return croomCode;
    }

    public void setCroomCode(String croomCode) {
        this.croomCode = croomCode == null ? null : croomCode.trim();
    }

    public String getCroomAddr() {
        return croomAddr;
    }

    public void setCroomAddr(String croomAddr) {
        this.croomAddr = croomAddr == null ? null : croomAddr.trim();
    }
}