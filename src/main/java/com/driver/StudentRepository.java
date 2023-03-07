package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Component
public class StudentRepository {

    Map<String, Student> students;
    Map<String, Teacher> teachers;
    Map<String, List<String>> studentTeachers;

    public StudentRepository(){
        this.students = new HashMap<>();
        this.teachers = new HashMap<>();
        this.studentTeachers = new HashMap<>();
    }


    public void addStudent(Student student) {
        students.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.put(teacher.getName(), teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        if(students.containsKey(student) && teachers.containsKey(teacher)){
            List<String> pair = new ArrayList<>();
            if(studentTeachers.containsKey(teacher)){
                pair = studentTeachers.get(teacher);
            }
            pair.add(student);
            studentTeachers.put(teacher,pair);
        }
    }

    public Student getStudent(String name) {
        return students.get(name);
    }

    public Teacher getTeacher(String name) {
        return teachers.get(name);
    }

    public List<String> getStudentTeacherPairs(String teacher) {
        return studentTeachers.get(teacher);
    }

    public List<String> getAllStudents() {
        List<String> studentsAll = new ArrayList<>();
        for(String s : students.keySet()){
            studentsAll.add(s);
        }
        return studentsAll;
    }

    public void deleteTeacher(String teacher) {
        studentTeachers.remove(teacher);
        teachers.remove(teacher);
    }

    public void deleteAllTeachers() {
        teachers.clear();
        studentTeachers.clear();
    }
}
