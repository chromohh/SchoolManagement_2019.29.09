package ecutb.data_access;

import ecutb.model.Course;

import java.time.LocalDate;
import java.util.List;

public class StudentDaoList implements CourseDao {
    private static List<Course> courses;

    @Override
    public Course saveCourse(Course course) {
        if(!courses.contains(course)){courses.add(course); return course;}
        return null;
    }

    @Override
    public Course findById(int id) {
        for(Course course : courses){
            if(id == course.getId()){
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> findByName(String name) {
        return null;
    }

    @Override
    public List<Course> findB(LocalDate date) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public boolean removeCourse(Course course) {
        if(courses.contains(course)){courses.remove(course); return true;}
        return false;
    }
}
