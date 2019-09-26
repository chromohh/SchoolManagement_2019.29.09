package ecutb.model;

import java.util.ArrayList;
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
        this.students = new ArrayList<>();
    }

    public void register(Student student){
       boolean noExist = false;
           for(Student student1 : students) {
               if (student1 == student) {
                   noExist = true;
               }
           }
           if (!noExist) {
               students.add(student);
           }
    }

    public void unregister(Student student){
        boolean noExist = false;
        for(Student student1: students){
            if(student1 == student){
                noExist = true;
            }
        }
        if(noExist){
            students.remove(student);
        }
    }

    public int getWeekDuration() { return weekDuration; }
    public void setWeekDuration(int weekDuration) { this.weekDuration = weekDuration; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public List<Student> getStudents() { return students; }
    public int getId() { return id; }
    public String getCourseName() { return courseName; }
}
