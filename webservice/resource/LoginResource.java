package com.lms.webservice.resource;

import com.lms.webservice.model.UserModel;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/login1")
public class LoginResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String login(UserModel user) throws SQLException, ClassNotFoundException {
        FileUpload.UserLoginDao.loginDao(user);
        String validation = user.getRole();
        String result;
        switch (validation){
            case "student":
                result ="valid user role Student...";
                return result;
            case "staff":
                result ="valid user role staff";
                return result;
            case "admin":
                result ="valid user role admin";
                return result;
            default:
                result ="username or password incorrect......";
                return  result;
        }
    }
}
