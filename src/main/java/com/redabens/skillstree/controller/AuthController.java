package com.redabens.skillstree.controller;

//import org.springframework.stereotype.Controller;
import com.redabens.skillstree.dao.BaseDAOImpl;
import com.redabens.skillstree.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
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

//    @GetMapping
//    public ResponseEntity<String> getwalo()
//    {
//        return ResponseEntity.ok("walo");
//    }

//    @PostMapping("/auth")
//    public String test(){
//        System.out.println("here");
//        return "hello";
//    }

}