package com.woniuxy.pojo;

import java.util.Date;

public class Schedule {
    private Integer scheduleId;

    private Integer sourceId;

    private Date date;

    private Date datestart;

    private Date datelast;

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDatestart() {
        return datestart;
    }

    public void setDatestart(Date datestart) {
        this.datestart = datestart;
    }

    public Date getDatelast() {
        return datelast;
    }

    public void setDatelast(Date datelast) {
        this.datelast = datelast;
    }
}