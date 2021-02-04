package com.lms.webservice.service;

import com.lms.webservice.dao.SaveStudentAttendanceDao;
import com.lms.webservice.model.ResponseModel;
import com.lms.webservice.model.SaveAttendanceRecordModel;


public class SaveAttendanceRecordService {

    public static ResponseModel save(SaveAttendanceRecordModel attendance) throws Exception {
        if (SaveStudentAttendanceDao.checkValidStudentOrNot(attendance)) {
            if (SaveStudentAttendanceDao.checkAttendanceRecordAlreadyExistOrNOt(attendance)) {
                return new ResponseModel("fail", "Already record exist..");
            } else {
                try {
                    SaveStudentAttendanceDao.save(attendance);
                    return new ResponseModel("success", "record saved successfully...");
                } catch (Exception ex) {
                    return new ResponseModel("fail", ex.getMessage());
                }

            }
        }return new ResponseModel("fail","invalid student record");
    }}
