package com.lms.webservice.resource;

import com.lms.webservice.model.ViewModel;
import com.lms.webservice.model.SaveAttendanceRecordAndViewResponseModel;
import com.lms.webservice.service.StaffViewService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/staffView")
public class StaffViewResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<SaveAttendanceRecordAndViewResponseModel> getAllAttendanceRecord(ViewModel view) throws Exception {
        return StaffViewService.getStudentRecord(view);
    }
}
