package com.lms.webservice.resource;

import com.lms.webservice.dao.AddStudentDetailDao;
import com.lms.webservice.model.UserModel;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/addStudentDetail")
public class AddStudentDetail {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateStudentDetail(UserModel um) throws SQLException, ClassNotFoundException {
        int result = AddStudentDetailDao.updateStudentDetail(um);
        if(result>0){
            return "student details updates successfully";
        }else{
            return "check detail ";
        }
    }
}
