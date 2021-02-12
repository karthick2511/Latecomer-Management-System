package com.lms.webservice.service;

import com.lms.webservice.dao.LateComerAuditDao;
import com.lms.webservice.model.LatecomerModel;

import java.sql.Date;
import java.util.List;

public class StudentService {

    public static List<LatecomerModel> getLateComerAuditByStudent(long registerNumber, Date fromDate, Date toDate) throws Exception {
        return LateComerAuditDao.getLateComerAuditByStudent(registerNumber, fromDate, toDate);

    }
}
