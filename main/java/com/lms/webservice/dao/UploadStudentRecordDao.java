package com.lms.webservice.dao;

import com.lms.webservice.model.UserModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UploadStudentRecordDao {
    public static int upload(UserModel um) throws ClassNotFoundException, SQLException {
        int status = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "password");
             PreparedStatement ps = con.prepareStatement("insert into attendanceMaster(registerNumber ,dateOfRecord,inTime, coordinateStaffName, description)values (?,?,?,?,?)")) {
            ps.setString(1, um.getRegisterNumber());
            ps.setDate(2, um.getDate());
            ps.setTime(3, um.getTime());
            ps.setString(4, um.getStaffName());
            ps.setString(5, um.getDescription());
            status = ps.executeUpdate();
        }
        return status;
    }
}
