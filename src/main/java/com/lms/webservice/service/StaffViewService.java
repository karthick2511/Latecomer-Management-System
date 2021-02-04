package com.lms.webservice.service;

import com.lms.webservice.dao.StaffViewDao;
import com.lms.webservice.model.ViewModel;
import com.lms.webservice.model.SaveAttendanceRecordAndViewResponseModel;

import java.util.List;


public class StaffViewService {

    public static List<SaveAttendanceRecordAndViewResponseModel> getStudentRecord(ViewModel view) throws Exception {
        return StaffViewDao.getStudentRecord(view);
    }
}
