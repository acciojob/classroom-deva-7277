package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class StudentService {

    @Autowired
    public StudentRepository studentRepository;


    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher) {
        studentRepository.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        studentRepository.addStudentTeacherPair(student,teacher);
    }

    public Student getStudent(String name) {
        return studentRepository.getStudent(name);
    }

    public Teacher getTeacher(String name) {
        return studentRepository.getTeacher(name);
    }

    public List<String> getStudentTeacherPairs(String teacher) {
        return studentRepository.getStudentTeacherPairs(teacher);
    }

    public List<String> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public void deleteTeacher(String teacher) {
        studentRepository.deleteTeacher(teacher);
    }

    public void deleteAllTeachers() {
        studentRepository.deleteAllTeachers();
    }
}
