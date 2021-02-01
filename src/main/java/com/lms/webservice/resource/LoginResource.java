package com.lms.webservice.resource;

import com.lms.webservice.model.UserModel;
import com.lms.webservice.service.LoginService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/login")
public class LoginResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String login(UserModel user) throws Exception {
        return LoginService.login(user);
    }
}
