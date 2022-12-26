package com.redabens.skillstree.controller;

import com.redabens.skillstree.entity.Student;
import com.redabens.skillstree.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.redabens.skillstree.service.AuthService;
import com.google.gson.Gson;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping(value = "/checkStudentExists", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> checkStudentExists(@RequestBody Student data)
    {
        Gson gson = new Gson();
        HashMap<String, String> map = new HashMap<>();
        Student student = authService.checkStudentExists(data.getEmail(), data.getPassword());
        if (student != null)
        {
            map.put("id", String.valueOf(student.getId()));
            map.put("name", student.getFirstname() + " " + student.getLastname());
        }
        else
        {
            map.put("error", "Invalid email or password");
        }
        return ResponseEntity.ok(gson.toJson(map));
    }

    @PostMapping(value = "/checkTeacherExists", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> checkTeacherExists(@RequestBody Teacher data)
    {
        Gson gson = new Gson();
        HashMap<String, String> map = new HashMap<>();
        Teacher teacher = authService.checkTeacherExists(data.getEmail(), data.getPassword());
        if (teacher != null)
        {
            map.put("id", String.valueOf(teacher.getId()));
            map.put("name", teacher.getFirstname() + " " + teacher.getLastname());
        }
        else
        {
            map.put("error", "Invalid email or password");
        }
        return ResponseEntity.ok(gson.toJson(map));
    }


}