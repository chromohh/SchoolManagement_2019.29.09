package ecutb.data_access;

import ecutb.model.Student;

import java.util.List;

public class CourseDaoList implements StudentDao {
    private static List<Student> students;

    @Override
    public Student saveStudent(Student student) {
        return null;
    }

    @Override
    public Student findByEmail(String email) {
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        return null;
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public boolean deleteStudent(Student student) {
        return false;
    }
}
