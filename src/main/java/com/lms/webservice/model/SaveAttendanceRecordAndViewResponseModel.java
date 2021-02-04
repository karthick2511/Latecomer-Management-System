package com.lms.webservice.model;

import java.sql.Time;
import java.sql.Date;

public class SaveAttendanceRecordAndViewResponseModel {
    private String registerNumber;
    private Date date;
    private Time inTime;
    private String coordinateStaff;
    private String description;

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getInTime() {
        return inTime;
    }

    public void setInTime(Time inTime) {
        this.inTime = inTime;
    }

    public String getCoordinateStaff() {
        return coordinateStaff;
    }

    public void setCoordinateStaff(String coordinateStaff) {
        this.coordinateStaff = coordinateStaff;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


