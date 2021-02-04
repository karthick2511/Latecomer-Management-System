package com.lms.webservice.dao;

import com.lms.webservice.model.StaffModel;
import com.lms.webservice.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffDao {

    public static boolean checkUserExistOrNot(StaffModel staff) throws Exception {
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
}
