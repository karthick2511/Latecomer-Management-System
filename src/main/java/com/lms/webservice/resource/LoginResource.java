package com.lms.webservice.resource;

import com.lms.webservice.model.UserModel;
import com.lms.webservice.service.LoginService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/login")
public class LoginResource {

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String login(UserModel user) throws Exception {

        return LoginService.login(user);
    }
}
