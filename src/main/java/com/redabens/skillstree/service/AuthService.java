package com.redabens.skillstree.service;

import com.redabens.skillstree.dao.BaseDAOImpl;
import com.redabens.skillstree.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    private BaseDAOImpl<Student> studentBaseDAO = new BaseDAOImpl<>(Student.class);
    public Student checkStudentExists(String email,String password)
    {
        List<Student> student = studentBaseDAO.getAllWhere("email",email);
        if (student.size() > 0)
        {
            if (student.get(0).getPassword().equals(password))
            {
                return student.get(0);
            }
        }
        return null;
    }
//    Student student = baseDAO.getAllWhere("email", ");
}
