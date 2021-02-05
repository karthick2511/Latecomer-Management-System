package com.lms.webservice.service;

import com.lms.webservice.dao.StudentDao;
import com.lms.webservice.model.ResponseModel;
import com.lms.webservice.model.StudentModel;
import com.lms.webservice.util.ConnectionUtil;

import java.sql.Connection;
import java.util.List;

public class StudentService {

    public static ResponseModel saveStudent(StudentModel student) throws Exception {
        if (StudentDao.checkUserExistOrNot(student)) {
            return new ResponseModel("fail", "Student Already Exist....");
        } else {
            try (Connection connection = ConnectionUtil.getConnection()) {
                try {
                    connection.setAutoCommit(false);
                    StudentDao.saveStudent(connection, student);
                    StudentDao.saveStudentAsUser(connection, student);
                    connection.commit();
                    return new ResponseModel("success", "Student and User created successfully");
                } catch (Exception ex) {
                    connection.rollback();
                    return new ResponseModel("failed", ex.getMessage());
                }
            }
        }
    }

    public static List<StudentModel> viewAllStudent(StudentModel student) throws Exception {
        return StudentDao.getAllStudent(student);
    }
}
