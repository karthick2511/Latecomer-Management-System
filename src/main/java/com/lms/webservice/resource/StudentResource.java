package com.lms.webservice.resource;

import com.lms.webservice.model.ResponseModel;
import com.lms.webservice.model.StudentModel;
import com.lms.webservice.service.StudentService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/student")
public class StudentResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel saveStudent(StudentModel student) throws Exception {
        return StudentService.saveStudent(student);
    }
}
