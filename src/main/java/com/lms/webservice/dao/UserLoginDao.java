package com.lms.webservice.dao;

import com.lms.webservice.model.UserModel;
import com.lms.webservice.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginDao {

    public static boolean authenticateUser(UserModel user) throws Exception {
        String query = "select user_role from users where user_name= ? and password = ?";
        try (Connection con = ConnectionUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user.setUserRole(rs.getString(1));
                    return true;
                }
            }
            return false;
        }
    }
}
