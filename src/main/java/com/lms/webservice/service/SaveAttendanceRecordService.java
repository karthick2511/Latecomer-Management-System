package com.lms.webservice.service;

import com.lms.webservice.dao.SaveStudentAttendanceDao;
import com.lms.webservice.model.ResponseModel;
import com.lms.webservice.model.SaveAttendanceRecordAndViewResponseModel;
import com.lms.webservice.model.ViewModel;


public class SaveAttendanceRecordService {

    public static ResponseModel save(SaveAttendanceRecordAndViewResponseModel attendance) throws Exception {
        if (SaveStudentAttendanceDao.checkAttendanceRecordAlreadyExistOrNOt(attendance)) {
            return new ResponseModel("fail", "Already record exist..");
        } else {
            try {
                SaveStudentAttendanceDao.save(attendance);
                return new ResponseModel("success", "record saved successfully...");
            } catch (Exception ex) {
                return new ResponseModel("fail", "");
            }

        }
    }
}
