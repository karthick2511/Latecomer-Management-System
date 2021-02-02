package com.lms.webservice.service;

import com.lms.webservice.dao.UploadStudentDetailDao;
import com.lms.webservice.model.UserModel;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

public class SaveStudentService {
    public static String save(UserModel um) throws SQLException, ClassNotFoundException {
        if (UploadStudentDetailDao.upload(um) > 0) {
            return "student details upload successfully...";
        } else {
            return "Already user exist...";
        }
    }
}
