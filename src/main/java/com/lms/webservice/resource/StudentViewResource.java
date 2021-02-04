package com.lms.webservice.resource;

import com.lms.webservice.model.ViewModel;
import com.lms.webservice.model.SaveAttendanceRecordModel;
import com.lms.webservice.service.StudentViewService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/studentView")
public class StudentViewResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<SaveAttendanceRecordModel> view(ViewModel view) throws Exception {
        return StudentViewService.studentView(view);
    }
}
