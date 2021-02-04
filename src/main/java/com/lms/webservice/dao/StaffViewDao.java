package com.lms.webservice.dao;

import com.lms.webservice.model.ViewModel;
import com.lms.webservice.model.SaveAttendanceRecordModel;
import com.lms.webservice.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StaffViewDao {
    public static List<SaveAttendanceRecordModel> getStudentRecord(ViewModel view) throws Exception {
        List<SaveAttendanceRecordModel> response = new ArrayList<>();
        String viewQuery = "select register_number, date_of_record, in_time, coordinate_staffName, description from master where register_number=? ";
        try (Connection con = ConnectionUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(viewQuery)) {
            ps.setString(1, view.getRegisterNumber());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SaveAttendanceRecordModel record = new SaveAttendanceRecordModel();
                record.setRegisterNumber((rs.getString(1)));
                record.setDate(rs.getDate(2));
                record.setInTime(rs.getTime(3));
                record.setCoordinateStaff(rs.getString(4));
                record.setDescription(rs.getString(5));

                response.add(record);
            }
        }
        return response;
    }
}
