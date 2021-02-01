package com.lms.webservice.dao;

import com.lms.webservice.model.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetAllLateComerRecordDao {
    public static List<UserModel> getAllLateComer(UserModel um) throws ClassNotFoundException, SQLException {
        ArrayList<UserModel> attendanceRecord = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "password");
            PreparedStatement ps = con.prepareStatement("select lateDate, inTime,coordinateStaff, description, year from master where lateDate=? and year=? order by year;")){
            ps.setDate(1,um.getDate());
            ps.setInt(2,um.getYear());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                um.setDate(rs.getDate(1));
                um.setTime(rs.getTime(2));
                um.setStaffName(rs.getString(3));
                um.setDescription(rs.getString(4));
                um.setYear(rs.getInt(5));
                attendanceRecord.add(um);
            }
            return attendanceRecord;
        }
    }
}
