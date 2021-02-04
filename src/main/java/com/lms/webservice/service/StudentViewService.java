package com.lms.webservice.service;

import com.lms.webservice.dao.StudentViewDao;
import com.lms.webservice.model.ViewModel;
import com.lms.webservice.model.SaveAttendanceRecordModel;

import java.util.List;

public class StudentViewService {
    public static List<SaveAttendanceRecordModel> studentView(ViewModel view) throws Exception {
        return StudentViewDao.viewAttendance(view);

    }

}
