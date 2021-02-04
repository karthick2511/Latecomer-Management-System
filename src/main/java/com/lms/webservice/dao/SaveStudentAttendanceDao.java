package com.lms.webservice.dao;

import com.lms.webservice.model.SaveAttendanceRecordModel;
import com.lms.webservice.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SaveStudentAttendanceDao {

    public static boolean checkAttendanceRecordAlreadyExistOrNOt(SaveAttendanceRecordModel attendanceRecord) throws Exception {
        String query = "Select register_number from master where register_number =? and date_of_record = ?";
        try (Connection con = ConnectionUtil.getConnection();
             PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, attendanceRecord.getRegisterNumber());
            statement.setDate(2, attendanceRecord.getDate());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
        }
        return false;
    }

    public static void save(SaveAttendanceRecordModel attendance) throws Exception {
        String saveAttendance = "insert into master(register_number ,date_of_record,in_time, " +
                "coordinate_staffName, description,studying_year)values (?,?,?,?,?,?)";
        try (Connection con = ConnectionUtil.getConnection();
             PreparedStatement statement = con.prepareStatement(saveAttendance)) {
            statement.setString(1, attendance.getRegisterNumber());
            statement.setDate(2, attendance.getDate());
            statement.setTime(3, attendance.getInTime());
            statement.setString(4, attendance.getCoordinateStaff());
            statement.setString(5, attendance.getDescription());
            statement.setInt(6,attendance.getYear());
            statement.executeUpdate();
        }

    }
}
