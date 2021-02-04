package com.lms.webservice.model;

import java.sql.Date;
import java.sql.Time;

public class UserModel {

    private String userName;
    private String password;
    private String userRole = "unAuthorizerUser";
<<<<<<< HEAD
    private Date date;
=======
    private String description;
    private Time time;
    private String staffName;
    private Date date;
    private Date startingDate;
    private Date endDate;
>>>>>>> 773e895e88b20b7dca8fcc219a2dc3fc9b701d10
    private int year;
    private String staffId;




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

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

<<<<<<< HEAD
=======
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

>>>>>>> 773e895e88b20b7dca8fcc219a2dc3fc9b701d10
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

<<<<<<< HEAD
=======
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

>>>>>>> 773e895e88b20b7dca8fcc219a2dc3fc9b701d10
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

}
