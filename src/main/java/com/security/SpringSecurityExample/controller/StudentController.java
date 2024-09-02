package com.security.SpringSecurityExample.controller;


import com.security.SpringSecurityExample.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController{

    List<Student> students=new ArrayList<>(List.of(
            new Student(1,"Niki",77),
            new Student(2,"mani",66)

    ));

    @GetMapping("/students")
    public List<Student> getStudents(){

        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }

}
