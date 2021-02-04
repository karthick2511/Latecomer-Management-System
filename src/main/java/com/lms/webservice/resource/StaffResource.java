package com.lms.webservice.resource;

import com.lms.webservice.model.ResponseModel;
import com.lms.webservice.model.StaffModel;
import com.lms.webservice.service.StaffService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Staff")
public class StaffResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel saveStaff(StaffModel staff) throws Exception {
        return StaffService.saveStaff(staff);
    }
}
