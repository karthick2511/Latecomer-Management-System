package com.lms.webservice.service;

import com.lms.webservice.dao.StaffDao;
import com.lms.webservice.dao.StudentDao;
import com.lms.webservice.model.ResponseModel;
import com.lms.webservice.model.StaffModel;
import com.lms.webservice.model.StudentModel;
import com.lms.webservice.util.ConnectionUtil;

import java.sql.Connection;
import java.util.List;


public class StaffService {

    public static ResponseModel saveStaff(StaffModel staff) throws Exception {
        if (StaffDao.checkUserExistOrNot(staff)) {
            return new ResponseModel("fail", "Staff Already Exist....");
        } else {
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
        }

        public static List<StaffModel> viewAllStaff(StaffModel staff) throws Exception {
        return StaffDao.getAllStaff(staff);
        }
    }