package com.lms.webservice.service;

import com.lms.webservice.dao.UserLoginDao;
import com.lms.webservice.model.UserModel;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/login")
public class LoginService {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String login(UserModel user) throws Exception {
        if (UserLoginDao.authenticateUser(user)) {
            switch (user.getUserRole()) {
                case "student":
                    return "valid user role Student...";
                case "staff":
                    return "valid user role staff";
                case "admin":
                    return "valid user role admin";
            }
        }
        return "username or password incorrect......";
    }
}
