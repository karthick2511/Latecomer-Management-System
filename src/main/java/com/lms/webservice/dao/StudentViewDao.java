package com.lms.webservice.dao;

import com.lms.webservice.model.ViewModel;
import com.lms.webservice.model.SaveAttendanceRecordModel;
import com.lms.webservice.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentViewDao {
    public static List<SaveAttendanceRecordModel> viewAttendance(ViewModel view) throws Exception {
         String viewQuery = "select register_number, date_of_record, in_time, coordinate_staffName, description from master" +
                 " where register_number=? and date_of_record between ? and ? order by date_of_record";
        List<SaveAttendanceRecordModel> response = new ArrayList<>();
        try(Connection con= ConnectionUtil.getConnection();
        PreparedStatement statement = con.prepareStatement(viewQuery)) {
            statement.setString(1, view.getRegisterNumber());
            statement.setDate(2, view.getStartingDate());
            statement.setDate(3, view.getEndDate());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                SaveAttendanceRecordModel record = new SaveAttendanceRecordModel();
                record.setRegisterNumber(rs.getString(1));
                record.setDate(rs.getDate(2));
                record.setInTime(rs.getTime(3));
                record.setCoordinateStaff((rs.getString(4)));
                record.setDescription(rs.getString(5));
                response.add(record);
            }
        }return response;
    }
}
