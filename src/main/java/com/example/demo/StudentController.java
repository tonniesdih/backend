package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getstudents")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PutMapping("/updatestudent/{admissionNumber}")
    public String updateStudent(
            @PathVariable String admissionNumber,
            @RequestBody Student student) {

        return studentService.updateStudent(admissionNumber, student);
    }

    @DeleteMapping("/deletestudent/{admissionNumber}")
    public String deleteStudent(
            @PathVariable String admissionNumber) {

        return studentService.deleteStudent(admissionNumber);
    }

    @PostMapping("/createstudent")
    public String createStudent(@RequestBody Student student) {

//        return "Inserted Successfully";
         studentService.createStudent(student);
        return "Inserted Successfully";
    }

//    @PostMapping("/createstudent")
//    public String createStudent(@RequestBody Student student) {
//
//        int result = Integer.parseInt(studentService.createStudent(student));
//
//        if (result > 0) {
//            return "Student created successfully";
//        }
//
//        return "Student was not created";
//    }
}