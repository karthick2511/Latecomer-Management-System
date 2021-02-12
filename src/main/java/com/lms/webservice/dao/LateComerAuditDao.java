package com.lms.webservice.dao;

import com.lms.webservice.model.LatecomerModel;
import com.lms.webservice.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LateComerAuditDao {

    public static boolean checkValidStudentOrNot(LatecomerModel attendanceRecord) throws Exception {
        String query = "Select register_number from student where register_number =?";
        try (Connection con = ConnectionUtil.getConnection();
             PreparedStatement statement = con.prepareStatement(query)) {
            statement.setLong(1, attendanceRecord.getRegisterNumber());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkAttendanceRecordAlreadyExistOrNOt(LatecomerModel attendanceRecord) throws Exception {
        String query = "Select register_number from late_comer_audit where register_number =? and date_of_record = ?";
        try (Connection con = ConnectionUtil.getConnection();
             PreparedStatement statement = con.prepareStatement(query)) {
            statement.setLong(1, attendanceRecord.getRegisterNumber());
            statement.setDate(2, attendanceRecord.getDate());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
        }
        return false;
    }

    public static void saveLateComerRecord(LatecomerModel attendance) throws Exception {
        String saveAttendance = "insert into late_comer_audit(register_number ,date_of_record,in_time, " +
                "coordinate_staffName, description,studying_year)values (?,?,?,?,?,?)";
        try (Connection con = ConnectionUtil.getConnection();
             PreparedStatement statement = con.prepareStatement(saveAttendance)) {
            statement.setLong(1, attendance.getRegisterNumber());
            statement.setDate(2, attendance.getDate());
            statement.setTime(3, attendance.getInTime());
            statement.setString(4, attendance.getCoordinateStaff());
            statement.setString(5, attendance.getDescription());
            statement.setInt(6, attendance.getYear());
            statement.executeUpdate();
        }

    }

    public static List<LatecomerModel> getLateComerAuditByStudent(long registerNumber, Date fromDate, Date toDate) throws Exception {
        String viewQuery = "select register_number, date_of_record, in_time, coordinate_staffName, description from late_comer_audit" +
                " where register_number=? and date_of_record between ? and ? order by date_of_record";
        List<LatecomerModel> response = new ArrayList<>();
        try (Connection con = ConnectionUtil.getConnection();
             PreparedStatement statement = con.prepareStatement(viewQuery)) {
            statement.setLong(1, registerNumber);
            statement.setDate(2, fromDate);
            statement.setDate(3, toDate);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                LatecomerModel record = new LatecomerModel();
                record.setRegisterNumber(rs.getLong("register_number"));
                record.setDate(rs.getDate("date_of_record"));
                record.setInTime(rs.getTime("in_time"));
                record.setCoordinateStaff(rs.getString("coordinate_staffName"));
                record.setDescription(rs.getString("description"));
                response.add(record);
            }
        }
        return response;
    }

    public static List<LatecomerModel> getStudentRecord(Long registerNumber) throws Exception {
        List<LatecomerModel> response = new ArrayList<>();
        String viewQuery = "select lca.register_number, lca.date_of_record, in_time, coordinate_staffName, description, lca.studying_year,st.student_name from late_comer_audit lca join student st" +
                " on lca.register_number = st.register_number where lca.register_number=?";

        try (Connection con = ConnectionUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(viewQuery)) {
            ps.setLong(1, registerNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LatecomerModel record = new LatecomerModel();
                record.setRegisterNumber((rs.getLong("lca.register_number")));
                record.setDate(rs.getDate("lca.date_of_record"));
                record.setInTime(rs.getTime("in_time"));
                record.setCoordinateStaff(rs.getString("coordinate_staffName"));
                record.setDescription(rs.getString("description"));
                record.setYear(rs.getInt("lca.studying_year"));
                record.setStudentName(rs.getString("st.student_name"));
                response.add(record);
            }
        }
        return response;
    }

    public static List<LatecomerModel> getAllLateComerAuditByDate(Date date) throws Exception {
        String query = "select lca.register_number, date_of_record, in_time, coordinate_staffName, description, lca.studying_year, st.student_name from late_comer_audit lca" +
                " join student st on lca.register_number = st.register_number where  date_of_record =?";
        List<LatecomerModel> record = new ArrayList<>();
        try (Connection con = ConnectionUtil.getConnection();
             PreparedStatement statement = con.prepareStatement(query)) {
            statement.setDate(1, date);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                LatecomerModel response = new LatecomerModel();
                response.setRegisterNumber(rs.getLong("lca.register_number"));
                response.setDate(rs.getDate("date_of_record"));
                response.setInTime(rs.getTime("in_time"));
                response.setCoordinateStaff(rs.getString("coordinate_staffName"));
                response.setDescription(rs.getString("description"));
                response.setYear(rs.getInt("lca.studying_year"));
                response.setStudentName(rs.getString("st.student_name"));
                record.add(response);
            }
        }
        return record;
    }

    public static List<LatecomerModel> getParticularLateComerAuditByDateAndYear(int year, Date date) throws Exception {
        String query = "select lca.register_number, date_of_record, in_time, coordinate_staffName, description, lca.studying_year, st.student_name from late_comer_audit lca" +
                " join student st on lca.register_number = st.register_number where lca.studying_year=? and date_of_record =?";
        List<LatecomerModel> record = new ArrayList<>();
        try (Connection con = ConnectionUtil.getConnection();
             PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, year);
            statement.setDate(2, date);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                LatecomerModel response = new LatecomerModel();
                response.setRegisterNumber(rs.getLong("lca.register_number"));
                response.setDate(rs.getDate("date_of_record"));
                response.setInTime(rs.getTime("in_time"));
                response.setCoordinateStaff(rs.getString("coordinate_staffName"));
                response.setDescription(rs.getString("description"));
                response.setYear(rs.getInt("lca.studying_year"));
                response.setStudentName(rs.getString("st.student_name"));
                record.add(response);
            }
        }
        return record;
    }
}
