package com.lms.webservice.resource;

import com.lms.webservice.model.*;
import com.lms.webservice.service.AdminService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Date;
import java.util.List;

@Path("/admin")
public class AdminResource {

    @Path("/studentDetail")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel saveStudent(StudentModel student) throws Exception {
        return AdminService.saveStudent(student);
    }

    @Path("/studentDetailView")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentModel> viewAllStudent(StudentModel student) throws Exception {
        return AdminService.getAllStudent();
    }

    @Path("/staffDetail")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel saveStaff(StaffModel staff) throws Exception {
        return AdminService.saveStaff(staff);
    }

    @Path("/staffDetailView")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<StaffModel> viewAllStaff(StaffModel staff) throws Exception {
        return AdminService.getAllStaff();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LatecomerModel> getLateComerRecord(@QueryParam("year") int year, @QueryParam("date") Date date) throws Exception {
        return AdminService.getLateComerRecord(year,date);
    }
}
