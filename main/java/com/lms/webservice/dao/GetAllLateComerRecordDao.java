package com.lms.webservice.dao;

import com.lms.webservice.model.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetAllLateComerRecordDao {
    public static List<Object> getAllLateComer(UserModel um) throws ClassNotFoundException, SQLException {
        ArrayList<Object> attendanceRecord = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "password");
             PreparedStatement ps = con.prepareStatement("select dateOfRecord, inTime,coordinateStaffName, description from attendanceMaster where dateOfRecord=?  order by registerNumber")) {
            ps.setDate(1, um.getDate());
            //  ps.setInt(2, um.getYear());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                attendanceRecord.add(rs.getDate(1));
                attendanceRecord.add(rs.getTime(2));
                attendanceRecord.add(rs.getString(3));
                attendanceRecord.add(rs.getString(4));
            }
            return attendanceRecord;
        }
    }
}
