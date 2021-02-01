package com.lms.webservice.model;

import java.sql.Date;
import java.sql.Time;

public class UserModel {
    private String userName;
    private String password;
    private String role = "unAuthorizerUser";
    private String description;
    private Time time;
    private String staffName;
    private long registerNumber;
    private Date date;
    private String name;
    private Date startingDate;
    private Date endDate;
    private int year;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    private String staffId;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private String department;

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    private String mailId;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    private long mobileNumber;

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    private Date dob;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getEndDate() { return endDate; }

    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public Date getStartingDate() { return startingDate; }

    public void setStartingDate(Date startingDate) { this.startingDate = startingDate; }

    public long getRegisterNumber() { return registerNumber; }

    public void setRegisterNumber(long registerNumber) { this.registerNumber = registerNumber; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }


    public Time getTime() { return time; }

    public void setTime(Time time) { this.time = time; }

    public String getStaffName() { return staffName; }

    public void setStaffName(String staffName) { this.staffName = staffName; }

    public void setDescription(String description) { this.description = description; }

    public String getDescription() { return description; }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
