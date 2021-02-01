package com.lms.webservice.dao;

import com.lms.webservice.model.UserModel;

import java.sql.*;

public class FileUploadDao {
    public static int upload(UserModel um) throws ClassNotFoundException, SQLException {
       int status = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "password");
             PreparedStatement ps = con.prepareStatement("insert into master(registerNumber ,studentName ,lateDate,inTime, coordinateStaff, description)values (?,?,?,?,?,?)")) {
            ps.setLong(1, um.getRegisterNumber());
            ps.setString(2, um.getName());
            ps.setDate(3, um.getDate());
            ps.setTime(4, um.getTime());
            ps.setString(5, um.getStaffName());
            ps.setString(6, um.getDescription());
           status= ps.executeUpdate();
        }
        return status;
    }
}
