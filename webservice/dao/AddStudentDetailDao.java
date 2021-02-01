package com.lms.webservice.dao;

import com.lms.webservice.model.UserModel;

import java.sql.*;

public class AddStudentDetailDao {
    public static int updateStudentDetail(UserModel um) throws ClassNotFoundException, SQLException {
        int status =0;
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "password");
             PreparedStatement ps = con.prepareStatement("insert into  studentDetail(registerNumber, studentName, department, mailId, address, mobileNumber, dob)values(?,?,?,?,?,?,?)")) {
            ps.setLong(1,um.getRegisterNumber());
            ps.setString(2,um.getName());
            ps.setString(3,um.getDepartment());
            ps.setString(4,um.getMailId());
            ps.setString(5,um.getAddress());
            ps.setLong(6,um.getMobileNumber());
            ps.setDate(7,um.getDate());
            status = ps.executeUpdate();
        }
        return status;
    }
}
