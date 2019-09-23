package ecutb.data_access;

import ecutb.model.Student;

import javax.swing.*;
import java.util.List;

public class CourseDaoList implements StudentDao {
    private static List<Student> students;

    @Override
    public Student saveStudent(Student student) {
      if(!students.contains(student)){ students.add(student); }
      return student;
    }

    @Override
    public Student findByEmail(String email) {
        for(Student student : students){
            if(email.equals(student.getEmail())){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        return null;
    }

    @Override
    public Student findById(int id) {
        for(Student student : students){
            if(id == student.getId()){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public boolean deleteStudent(Student student) {
        if(students.contains(student)){students.remove(student); return true;}
        return false;
    }
}
