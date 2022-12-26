package com.redabens.skillstree.service;

import com.redabens.skillstree.dao.BaseDAOImpl;
import com.redabens.skillstree.entity.StudentCompetenceLevel;
import com.redabens.skillstree.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentLevelService {
    private BaseDAOImpl<StudentCompetenceLevel> studentBaseDAO = new BaseDAOImpl<>(StudentCompetenceLevel.class);

//    public Student checkStudentExists(String email,String password)
//    {
//        studentBaseDAO.("email",email);
//        if (student.size() > 0)
//        {
//            if (student.get(0).getPassword().equals(password))
//            {
//                return student.get(0);
//            }
//        }
//        return null;
//    }

}
