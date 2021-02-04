package com.lms.webservice.dao;

import com.lms.webservice.model.ViewModel;
import com.lms.webservice.model.ViewResponseModel;
import com.lms.webservice.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminViewDao {
    public static List<ViewResponseModel> getAllAttendanceRecord(ViewModel view) throws Exception {
        String query = "select mt.register_number, date_of_record, in_time, coordinate_staffName, description, studying_year, st.student_name from master mt"+
                " join student st on mt.register_number = st.register_number where  date_of_record =?";
        List<ViewResponseModel> record = new ArrayList<>();
        try (Connection con = ConnectionUtil.getConnection();
             PreparedStatement statement = con.prepareStatement(query)) {
            statement.setDate(1,view.getDate());
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                ViewResponseModel response = new ViewResponseModel();
                response.setRegisterNumber(rs.getString(1));
                response.setDate(rs.getDate(2));
                response.setInTime(rs.getTime(3));
                response.setCoordinateStaff(rs.getString(4));
                response.setDescription(rs.getString(5));
                response.setYear(rs.getInt(6));
                response.setStudentName(rs.getString(7));
                record.add(response);
            }
        }
        return record;
    }

    public static List<ViewResponseModel> getParticularAttendanceRecord(ViewModel view) throws Exception {
        String query = "select mt.register_number, date_of_record, in_time, coordinate_staffName, description, studying_year, st.student_name from master mt"+
                " join student st on mt.register_number = st.register_number where studying_year and date_of_record =?";
        List<ViewResponseModel> record = new ArrayList<>();
        try (Connection con = ConnectionUtil.getConnection();
             PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1,view.getYear());
            statement.setDate(2,view.getDate());
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                ViewResponseModel response = new ViewResponseModel();
                response.setRegisterNumber(rs.getString(1));
                response.setDate(rs.getDate(2));
                response.setInTime(rs.getTime(3));
                response.setCoordinateStaff(rs.getString(4));
                response.setDescription(rs.getString(5));
                response.setYear(rs.getInt(6));
                response.setStudentName(rs.getString(7));
                record.add(response);
            }
        }
        return record;
    }
}
