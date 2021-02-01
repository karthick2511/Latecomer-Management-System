package com.lms.webservice.dao;

import com.lms.webservice.model.UserModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UploadStudentDetailDao {
    public static int upload(UserModel um) throws ClassNotFoundException, SQLException {
        int status = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "password");
             PreparedStatement ps = con.prepareStatement("insert into  studentDetail(registerNumber, studentName, department, mailId, address, mobileNumber, dob)values(?,?,?,?,?,?,?)");
             PreparedStatement userUpload = con.prepareStatement("insert into userTable(userName,password,userRole) select registerNumber,dob,userRole from studentDetail where registerNumber=?")) {
            ps.setString(1, um.getRegisterNumber());
            ps.setString(2, um.getStudentName());
            ps.setString(3, um.getDepartment());
            ps.setString(4, um.getMailId());
            ps.setString(5, um.getAddress());
            ps.setLong(6, um.getMobileNumber());
            ps.setDate(7, um.getDob());
            status = ps.executeUpdate();
            userUpload.setString(1, um.getRegisterNumber());
            userUpload.executeUpdate();
        }
        return status;
    }
}
