package com.lms.webservice.resource;

import com.lms.webservice.model.ResponseModel;
import com.lms.webservice.model.SaveAttendanceRecordModel;
import com.lms.webservice.service.SaveAttendanceRecordService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/saveAttendanceRecord")
public class SaveAttendanceRecordResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel saveAttendance(SaveAttendanceRecordModel attendance) throws Exception {
        return SaveAttendanceRecordService.save(attendance);
    }
}
