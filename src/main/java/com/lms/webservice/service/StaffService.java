package com.lms.webservice.service;

import com.lms.webservice.dao.LateComerAuditDao;
import com.lms.webservice.model.LatecomerModel;
import com.lms.webservice.model.ResponseModel;

import java.util.List;


public class StaffService {

    public static ResponseModel saveLateComerRecord(LatecomerModel attendance) throws Exception {
        if (LateComerAuditDao.checkValidStudentOrNot(attendance)) {
            if (!LateComerAuditDao.checkAttendanceRecordAlreadyExistOrNOt(attendance)) {
                try {
                    LateComerAuditDao.saveLateComerRecord(attendance);
                    return new ResponseModel("success", "record saved successfully...");
                } catch (Exception ex) {
                    return new ResponseModel("fail", ex.getMessage());
                }

            }
            return new ResponseModel("fail", "Already record exist..");
        }
        return new ResponseModel("fail", "invalid student");
    }

    public static List<LatecomerModel> getStudentRecord(Long registerNumber) throws Exception {
        return LateComerAuditDao.getStudentRecord(registerNumber);
    }
}