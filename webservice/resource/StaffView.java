package com.lms.webservice.resource;

import com.lms.webservice.dao.GetAllLateComerRecordDao;
import com.lms.webservice.model.UserModel;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/lateComerRecord")

public class StaffView {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserModel> getAllLateComerRecord(UserModel um) throws SQLException, ClassNotFoundException {
        return GetAllLateComerRecordDao.getAllLateComer(um);
    }
}
