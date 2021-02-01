package com.lms.webservice.resource;

import com.lms.webservice.dao.FileUploadDao;
import com.lms.webservice.model.UserModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.*;

@Path("/fileUpload")
public class FileUpload {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object upload(UserModel um) throws SQLException, ClassNotFoundException {
        if(FileUploadDao.upload(um) >=0 ){
            return "uploaded successfully.......";
        }else {
            return "Enter the valid records..";
        }

    }

    public static class UserLoginDao {

        public static void loginDao(UserModel user) throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "password");
                 PreparedStatement ps = con.prepareStatement("select userRole from userTable where userName= ? and password = ?")) {
                ps.setString(1, user.getUserName());
                ps.setString(2, user.getPassword());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    user.setRole(rs.getString(1));
                }
            }
        }
    }
}
