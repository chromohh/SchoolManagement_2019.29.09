package ecutb.data_access;

import ecutb.model.Course;
import java.time.LocalDate;
import java.util.List;

public interface CourseDao {
    Course saveCourse(Course course);
    Course findById(int id);
    List<Course> findByName(String name);
    List<Course> findB (LocalDate date);
    List<Course> findAll();
    boolean removeCourse(Course course);
}
