package com.lms.webservice.dao;

import com.lms.webservice.model.StaffModel;
import com.lms.webservice.model.StudentModel;
import com.lms.webservice.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDao {

    public static boolean isUserExist(StaffModel staff) throws Exception {
        String checkUser = "select Staff_id from staff where Staff_id= ?";
        try (Connection con = ConnectionUtil.getConnection();
             PreparedStatement statement = con.prepareStatement(checkUser)) {
            con.setAutoCommit(false);
            statement.setString(1, staff.getStaffId());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        }
    }

    public static void saveStaff(Connection connection, StaffModel staff) throws SQLException {
        String staffSaveQuery = "insert into staff(staff_id, staff_name, password, mail_id, " +
                "address, mobile_number, dob) values (?,?,?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(staffSaveQuery)) {
            statement.setString(1, staff.getStaffId());
            statement.setString(2, staff.getStaffName());
            statement.setString(3, staff.getPassword());
            statement.setString(4, staff.getMailId());
            statement.setString(5, staff.getAddress());
            statement.setLong(6, staff.getMobileNumber());
            statement.setDate(7, staff.getDob());
            statement.executeUpdate();
        }
    }

    public static void saveStaffAsUser(Connection connection, StaffModel staff) throws SQLException {
        String saveUser = "insert into users(user_name,password,user_role) " +
                "select staff_id,password,user_role from staff where staff_id=?";
        try (PreparedStatement statement = connection.prepareStatement(saveUser)) {
            statement.setString(1, staff.getStaffId());
            statement.executeUpdate();
        }
    }

    public static List<StaffModel> getAllStaff() throws Exception {
        List<StaffModel> getStaff= new ArrayList<>();
        String getAllStaff ="select staff_id, staff_name, password, mail_id, address, mobile_number, dob from staff";
        try(Connection con =ConnectionUtil.getConnection();
            PreparedStatement statement = con.prepareStatement(getAllStaff)){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                StaffModel staff = new StaffModel();
                staff.setStaffId(rs.getString("staff_id"));
                staff.setStaffName(rs.getString("staff_name"));
                staff.setPassword(rs.getString("password"));
                staff.setMailId(rs.getString("mail_id"));
                staff.setAddress(rs.getString("address"));
                staff.setMobileNumber(rs.getLong("mobile_number"));
                staff.setDob(rs.getDate("dob"));
                getStaff.add(staff);
            }
        }
        return getStaff;
    }

}
