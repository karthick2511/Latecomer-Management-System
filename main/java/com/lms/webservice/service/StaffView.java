package com.lms.webservice.service;

import com.lms.webservice.dao.StaffViewDao;
import com.lms.webservice.model.UserModel;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;


@Path("/staffView")
public class StaffView {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Object> getStudentRecord(UserModel um) throws SQLException, ClassNotFoundException {
        return StaffViewDao.getStudentRecord(um);
    }
}
