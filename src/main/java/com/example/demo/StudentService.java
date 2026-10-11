package com.example.demo;



import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.getStudents();
    }

    public String updateStudent(String admissionNumber, Student student) {

        int rowsUpdated =
                studentRepository.updateStudent(admissionNumber, student);

        if (rowsUpdated > 0) {
            return "Student updated successfully";
        } else {
            return "Student not found";
        }
    }

    public String deleteStudent(String admissionNumber) {

        int rowsDeleted =
                studentRepository.deleteStudent(admissionNumber);

        if (rowsDeleted > 0) {
            return "Student deleted successfully";
        } else {
            return "Student not found";
        }
    }

    public String createStudent(Student student) {

        int rowsInserted =
                studentRepository.createStudent(student);

//        if (rowsInserted > 0) {
//            return "Student created successfully";
//        } else {
//            return "Student was not created";
//        }

        return "20";
    }
}