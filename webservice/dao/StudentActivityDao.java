package com.lms.webservice.dao;

import com.lms.webservice.model.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentActivityDao {
    public static List<UserModel> getStudentActivityStatus(UserModel um) throws ClassNotFoundException, SQLException {
        List<UserModel> studentActiveStatus = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "password");
             PreparedStatement ps = con.prepareStatement("select lateDate, inTime, coordinateStaff, description from master where registerNumber=? ")) {
            ps.setLong(1, um.getRegisterNumber());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                um.setDate(rs.getDate(1));
                um.setTime(rs.getTime(2));
                um.setStaffName(rs.getNString(3));
                um.setDescription(rs.getString(4));
                studentActiveStatus.add(um);
            }
        }
        return studentActiveStatus;
    }

}
