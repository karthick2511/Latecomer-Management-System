package com.lms.webservice.service;

import com.lms.webservice.dao.UploadStaffDetailDao;
import com.lms.webservice.model.UserModel;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/uploadStaffDetail")
public class UploadStaffDetail {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String uploadStaffDetail(UserModel um) throws SQLException, ClassNotFoundException {
        if (UploadStaffDetailDao.upload(um) > 0) {
            return "Staff detail Upload successfully...";
        } else {
            return "Already user exist....";
        }
    }
}
