package com.lms.webservice.dao;

import com.lms.webservice.model.UserModel;

import java.sql.*;
import java.util.ArrayList;

public class StaffViewDao {
    public static ArrayList<Object> getStudentRecord(UserModel um) throws ClassNotFoundException, SQLException {
        ArrayList<Object> studentRecord = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "password");
             PreparedStatement ps = con.prepareStatement("select dateOfRecord, inTime, coordinateStaffName, description from AttendanceMaster where registerNumber=? ")) {
            ps.setString(1, um.getRegisterNumber());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                studentRecord.add(rs.getDate(1));
                studentRecord.add(rs.getTime(2));
                studentRecord.add(rs.getString(3));
                studentRecord.add(rs.getString(4));
            }
        }
        return studentRecord;
    }
}
