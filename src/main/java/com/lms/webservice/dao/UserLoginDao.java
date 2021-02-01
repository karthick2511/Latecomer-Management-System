package com.lms.webservice.dao;

import com.lms.webservice.model.UserModel;

import java.sql.*;

public class UserLoginDao {

    public static void loginDao(UserModel user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "password");
             PreparedStatement ps = con.prepareStatement("select userRole from userTable where userName= ? and password = ?")) {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setUserRole(rs.getString(1));
            }
        }
    }
}
