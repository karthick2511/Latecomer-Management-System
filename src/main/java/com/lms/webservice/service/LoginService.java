package com.lms.webservice.service;

import com.lms.webservice.dao.UserLoginDao;
import com.lms.webservice.model.UserModel;

public class LoginService {

    public static String login(UserModel user) throws Exception {
        if (UserLoginDao.authenticateUser(user)) {
            switch (user.getUserRole()) {
                case "student":
                    return "valid user role Student...";
                case "staff":
                    return "valid user role staff";
                case "admin":
                    return "valid user role admin";
            }
        }
        return "username or password incorrect......";
    }
}
