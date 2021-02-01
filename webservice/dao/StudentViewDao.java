package com.lms.webservice.dao;

import com.lms.webservice.model.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentViewDao {
    public static List<UserModel> viewAttendance(UserModel um) throws SQLException,ClassNotFoundException {
        ArrayList<UserModel> attendanceRecord = new ArrayList<UserModel>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "password");
             PreparedStatement ps = con.prepareStatement("select lateDate, inTime, coordinateStaff, description from master where registerNumber=? and lateDate between ? and ? order by lateDate")) {
            ps.setLong(1, um.getRegisterNumber());
            ps.setDate(2, um.getStartingDate());
            ps.setDate(3, um.getEndDate());
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                um.setDate(rs.getDate(1));
                um.setTime(rs.getTime(2));
                um.setStaffName(rs.getNString(3));
                um.setDescription(rs.getString(4));
                attendanceRecord.add(um);
            }
        }return attendanceRecord;
    }
}
