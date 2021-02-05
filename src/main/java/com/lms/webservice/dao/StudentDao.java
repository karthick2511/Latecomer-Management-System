package com.lms.webservice.dao;

import com.lms.webservice.model.StudentModel;
import com.lms.webservice.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public static boolean checkUserExistOrNot(StudentModel student) throws Exception {
        String checkUser = "select register_number from student where register_number= ?";
        try (Connection con = ConnectionUtil.getConnection();
             PreparedStatement statement = con.prepareStatement(checkUser)) {
            statement.setString(1, student.getRegisterNumber());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                student.setRegisterNumber(rs.getString(1));
                return true;
            }
            return false;
        }
    }

    public static void saveStudent(Connection connection, StudentModel student) throws SQLException {
        String studentSaveQuery = "insert into student(register_number, student_name, department, mail_id, " +
                "address, mobile_number, dob,studying_year) values (?,?,?,?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(studentSaveQuery)) {
            statement.setString(1, student.getRegisterNumber());
            statement.setString(2, student.getStudentName());
            statement.setString(3, student.getDepartment());
            statement.setString(4, student.getMailId());
            statement.setString(5, student.getAddress());
            statement.setLong(6, student.getMobileNumber());
            statement.setDate(7, student.getDob());
            statement.setInt(8,student.getYear());
            statement.executeUpdate();
        }
    }

    public static void saveStudentAsUser(Connection connection, StudentModel student) throws SQLException {
        String saveUser = "insert into users(user_name,password,user_role) " +
                "select register_number,dob,user_role from student where register_number=?";
        try (PreparedStatement statement = connection.prepareStatement(saveUser)) {
            statement.setString(1, student.getRegisterNumber());
            statement.executeUpdate();
        }
    }

    public static List<StudentModel> getAllStudent(StudentModel student) throws Exception {
        List<StudentModel> getStudents = new ArrayList<>();
        String getAllStudent ="select register_number, student_name, department, mail_id, address, mobile_number, dob,studying_year from student";
        try(Connection con =ConnectionUtil.getConnection();
            PreparedStatement statement = con.prepareStatement(getAllStudent)){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                student.setRegisterNumber(rs.getString(1));
                student.setStudentName(rs.getString(2));
                student.setDepartment(rs.getString(3));
                student.setMailId(rs.getString(4));
                student.setAddress(rs.getString(5));
                student.setMobileNumber(rs.getLong(6));
                student.setDob(rs.getDate(7));
                student.setYear(rs.getInt(8));
                getStudents.add(student);
            }
        }
        return getStudents;
    }
}
