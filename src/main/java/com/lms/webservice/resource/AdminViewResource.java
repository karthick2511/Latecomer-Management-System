package com.lms.webservice.resource;

import com.lms.webservice.model.ViewModel;
import com.lms.webservice.model.ViewResponseModel;
import com.lms.webservice.service.AdminViewService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/adminView")
public class AdminViewResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<ViewResponseModel> getLatecomerRecord(ViewModel view) throws Exception {
       return AdminViewService.getRecord(view);
    }
}
