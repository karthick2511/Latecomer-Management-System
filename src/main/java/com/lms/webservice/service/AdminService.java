package com.lms.webservice.service;

import com.lms.webservice.dao.LateComerAuditDao;
import com.lms.webservice.dao.StaffDao;
import com.lms.webservice.dao.StudentDao;
import com.lms.webservice.model.*;
import com.lms.webservice.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class AdminService {

    public static List<StudentModel> getAllStudent() throws Exception {
        return StudentDao.getAllStudent();
    }

    public static List<StaffModel> getAllStaff() throws Exception {
        return StaffDao.getAllStaff();
    }

    public static ResponseModel saveStaff(StaffModel staff) throws Exception {
        if (!StaffDao.isUserExist(staff)) {
            try (Connection connection = ConnectionUtil.getConnection()) {
                try {
                    connection.setAutoCommit(false);
                    StaffDao.saveStaff(connection, staff);
                    StaffDao.saveStaffAsUser(connection, staff);
                    connection.commit();
                    return new ResponseModel("success", "Staff and User created successfully");
                } catch (Exception ex) {
                    connection.rollback();
                    return new ResponseModel("failed", ex.getMessage());
                }
            }
        }
        return new ResponseModel("fail", "Staff Already Exist....");
    }


    public static ResponseModel saveStudent(StudentModel student) throws Exception {
        if (!StudentDao.isUserExist(student)) {
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
        return new ResponseModel("fail", "Student Already Exist....");
    }

    public static List<LatecomerModel> getLateComerRecord(int year, Date date) throws Exception {
        if (year>4){
            return LateComerAuditDao.getAllLateComerAuditByDate(date);
        }else {
            return LateComerAuditDao.getParticularLateComerAuditByDateAndYear(year,date);
        }
    }
}
