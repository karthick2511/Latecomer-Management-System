package com.lms.webservice.service;

import com.lms.webservice.dao.StudentViewDao;
import com.lms.webservice.model.ViewModel;
import com.lms.webservice.model.SaveAttendanceRecordAndViewResponseModel;

import java.util.List;

public class StudentViewService {
    public static List<SaveAttendanceRecordAndViewResponseModel> studentView(ViewModel view) throws Exception {
        return StudentViewDao.viewAttendance(view);

    }

}
