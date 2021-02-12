package com.lms.webservice.resource;

import com.lms.webservice.model.LatecomerModel;
import com.lms.webservice.service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Date;
import java.util.List;

@Path("/student")
public class StudentResource {

    @Path("{registerNumber}/{fromDate}/{toDate}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<LatecomerModel> view(@PathParam("registerNumber") long registerNumber,
                                     @PathParam("fromDate") Date fromDate,
                                     @PathParam("toDate") Date toDate) throws Exception {
        return StudentService.getLateComerAuditByStudent(registerNumber, fromDate, toDate);
    }

}
