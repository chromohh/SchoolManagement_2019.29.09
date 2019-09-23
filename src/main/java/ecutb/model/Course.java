package ecutb.model;

import java.util.Collections;
import java.util.List;
import java.time.LocalDate;

public class Course {
    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students;

    public Course(int id, String courseName, LocalDate startDate, int weekDuration){
        this.id = id;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
    }
    public void register(Student student){
        students.add(student);
    }

    public void unregister(Student student){
        students.remove(student);
    }
}
