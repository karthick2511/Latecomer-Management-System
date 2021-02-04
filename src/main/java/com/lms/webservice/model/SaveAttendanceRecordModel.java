package com.lms.webservice.model;

import java.sql.Date;
import java.sql.Time;

public class SaveAttendanceRecordModel {
    private String registerNumber;
    private Date date;
    private Time inTime;
    private String coordinateStaff;
    private String description;
    private int year;
    private String studentName;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

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


