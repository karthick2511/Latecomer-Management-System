package com.lms.webservice.service;

import com.lms.webservice.dao.AdminViewDao;
import com.lms.webservice.model.ViewModel;
import com.lms.webservice.model.ViewResponseModel;

import java.util.List;

public class AdminViewService {
    public static List<ViewResponseModel> getRecord(ViewModel view) throws Exception {
        if (view.getYear()>4){
            return AdminViewDao.getAllAttendanceRecord(view);
        }else {
            return AdminViewDao.getParticularAttendanceRecord(view);
        }
    }
}
