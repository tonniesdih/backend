package com.example.demo;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> getStudents() {

        String sql = "SELECT name, age, student_class, admission_number, stream FROM students";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Student(
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("student_class"),
                        rs.getString("admission_number"),
                        rs.getString("stream")
                )
        );
    }

    public int updateStudent(String admissionNumber, Student student) {

        String sql = """
            UPDATE students
            SET name = ?,
                age = ?,
                student_class = ?,
                stream = ?
            WHERE admission_number = ?
            """;

        return jdbcTemplate.update(
                sql,
                student.getName(),
                student.getAge(),
                student.getStudentClass(),
                student.getStream(),
                admissionNumber
        );
    }

    public int deleteStudent(String admissionNumber) {

        String sql = "DELETE FROM students WHERE admission_number = ?";

        return jdbcTemplate.update(sql, admissionNumber);
    }

    public int createStudent(Student student) {

        String sql = """
            INSERT INTO students
            (name, age, student_class, admission_number, stream)
            VALUES (?, ?, ?, ?, ?)
            """;

        return jdbcTemplate.update(
                sql,
                student.getName(),
                student.getAge(),
                student.getStudentClass(),
                student.getAdmissionNumber(),
                student.getStream()
        );
    }
}