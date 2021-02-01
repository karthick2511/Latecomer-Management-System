package com.lms.webservice.service;

import com.lms.webservice.dao.UploadStudentRecordDao;
import com.lms.webservice.model.UserModel;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/uploadStudentRecord")
public class UploadStudentRecord {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object upload(UserModel um) throws SQLException, ClassNotFoundException {
        if (UploadStudentRecordDao.upload(um) >= 0) {
            return "uploaded successfully.......";
        } else {
            return "Already record updated.... ";
        }

    }
}
