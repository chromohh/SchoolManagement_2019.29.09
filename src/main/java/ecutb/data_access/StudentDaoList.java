package ecutb.data_access;

import ecutb.model.Student;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoList implements StudentDao {
    private static List<Student> students;

    public StudentDaoList(){
        this.students = new ArrayList<>();
    }

    @Override
    public Student saveStudent(Student student) {
      if(!students.contains(student)){ students.add(student); }
      return student;
    }

    @Override
    public Student findByEmail(String email) {
        for(Student student : students){
            if(email.equalsIgnoreCase(student.getEmail())){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> temp = new ArrayList<>();
        for(Student student : students){
            if(name.equalsIgnoreCase(student.getName())){
                temp.add(student);
            }
        }
        return temp;
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
        return students;
    }

    @Override
    public boolean deleteStudent(Student student) {
        if(students.contains(student)){students.remove(student); return true;}
        return false;
    }
}
