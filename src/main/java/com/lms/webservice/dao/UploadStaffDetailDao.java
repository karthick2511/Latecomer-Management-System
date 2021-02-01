package com.lms.webservice.dao;

import com.lms.webservice.model.UserModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UploadStaffDetailDao {
    public static int upload(UserModel um) throws ClassNotFoundException, SQLException {
        int status = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "password");
             PreparedStatement ps = con.prepareStatement("insert into  staffDetail(staffId, staffName, password, mailId, address, mobileNumber, dob)values(?,?,?,?,?,?,?)");
             PreparedStatement userUpload = con.prepareStatement("insert into userTable(userName,password,userRole) select staffId,password,userRole from staffDetail where staffId=?")) {
            ps.setString(1, um.getStaffId());
            ps.setString(2, um.getStaffName());
            ps.setString(3, um.getPassword());
            ps.setString(4, um.getMailId());
            ps.setString(5, um.getAddress());
            ps.setLong(6, um.getMobileNumber());
            ps.setDate(7, um.getDob());
            status = ps.executeUpdate();
            userUpload.setString(1,um.getStaffId());
            userUpload.executeUpdate();
        }
        return status;
    }
}
