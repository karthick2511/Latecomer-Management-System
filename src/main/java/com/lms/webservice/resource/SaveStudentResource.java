package com.lms.webservice.resource;

import com.lms.webservice.model.UserModel;
import com.lms.webservice.service.SaveStudentService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/saveStudent")
public class SaveStudentResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String save(UserModel um) throws SQLException, ClassNotFoundException {
        return SaveStudentService.save(um);
    }
}
