package com.redabens.skillstree.service;

import com.redabens.skillstree.dao.BaseDAOImpl;
import com.redabens.skillstree.entity.Student;
import com.redabens.skillstree.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    private BaseDAOImpl<Student> studentBaseDAO = new BaseDAOImpl<>(Student.class);
    private BaseDAOImpl<Teacher> teacherBaseDAO = new BaseDAOImpl<>(Teacher.class);
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

    public Teacher checkTeacherExists(String email,String password)
    {
        List<Teacher> teacher = teacherBaseDAO.getAllWhere("email",email);
        if (teacher.size() > 0)
        {
            if (teacher.get(0).getPassword().equals(password))
            {
                return teacher.get(0);
            }
        }
        return null;
    }
}
