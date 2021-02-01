/*package com.lms.webservice.resource;

import com.lms.webservice.dao.AddStaffDetailDao;
import com.lms.webservice.dao.AddStudentDetailDao;
import com.lms.webservice.model.UserModel;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/addStaffDetail")
public class AddStaffDetail {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateStaffDetail(UserModel um) throws SQLException, ClassNotFoundException {
        int result = AddStaffDetailDao.updateStaffDetail(um);
        if(result>0){
            return "staff details updates successfully";
        }else{
            return "check detail ";
        }
    }
}
*/