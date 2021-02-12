package com.lms.webservice.resource;

import com.lms.webservice.model.*;
import com.lms.webservice.service.StaffService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/staff")
public class StaffResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LatecomerModel> getAllAttendanceRecord(@QueryParam("registerNumber") Long registerNumber) throws Exception {
        return StaffService.getStudentRecord(registerNumber);
    }

    @Path("/lateComerAudit")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel saveLateComerRecord(LatecomerModel attendance) throws Exception {
        return StaffService.saveLateComerRecord(attendance);
    }
}
