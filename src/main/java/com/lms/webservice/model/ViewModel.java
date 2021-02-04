package com.lms.webservice.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.sql.Date;

@JsonIgnoreProperties
public class ViewModel {
    private String registerNumber;
    private Date startingDate;
    private Date endDate;
    private Date date;
    private int year;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }


    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }


    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
