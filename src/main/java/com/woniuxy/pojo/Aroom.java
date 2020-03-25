package com.woniuxy.pojo;

public class Aroom {
    private Integer aroomId;

    private String aroomName;

    private String aroomCode;

    private String aroomAddr;

    public Integer getAroomId() {
        return aroomId;
    }

    public void setAroomId(Integer aroomId) {
        this.aroomId = aroomId;
    }

    public String getAroomName() {
        return aroomName;
    }

    public void setAroomName(String aroomName) {
        this.aroomName = aroomName == null ? null : aroomName.trim();
    }

    public String getAroomCode() {
        return aroomCode;
    }

    public void setAroomCode(String aroomCode) {
        this.aroomCode = aroomCode == null ? null : aroomCode.trim();
    }

    public String getAroomAddr() {
        return aroomAddr;
    }

    public void setAroomAddr(String aroomAddr) {
        this.aroomAddr = aroomAddr == null ? null : aroomAddr.trim();
    }
}