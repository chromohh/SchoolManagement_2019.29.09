package ecutb;

import ecutb.data_access.CourseDaoList;
import ecutb.data_access.StudentDaoList;
import ecutb.model.Course;
import ecutb.model.Student;

import java.time.LocalDate;
import java.util.Scanner;

public class AppHelper {

    private StudentDaoList stdl;
    private CourseDaoList ctdl;
    int courseID;
    int studentID;

    public AppHelper(){
        stdl = new StudentDaoList();
        ctdl = new CourseDaoList();
        courseID = 0;
    }

    public void RemoveOrAddCourse(){
        Scanner myInput = new Scanner(System.in);
        System.out.println("1 to add new course \n2 to remove course \nany to return to start");
        switch(myInput.nextLine()){
            case "1":
                try{
                System.out.println("Create new course, start by entering a name");
                String name = myInput.next();
                System.out.println("now startdate formatted as yyyy-mm-dd");
                LocalDate date = LocalDate.parse(myInput.next());
                System.out.println("now week duration");
                int weeks = myInput.nextInt();
                this.courseID = courseID + 1;
                Course Course = new Course(courseID, name, date, weeks);
                ctdl.saveCourse(Course);
                }catch(Exception e){
                    System.out.println("faulty inputs, returning to main");
                }
                break;
            case "2":
                try{
                System.out.println("Remove by entering the ID of the course");
                for(Course c : ctdl.findAll()){
                    System.out.println("name: "+ c.getCourseName() + " Id: " + c.getId() + " startdate: " + c.getStartDate());
                }
                ctdl.removeCourse(ctdl.findById(myInput.nextInt()));}
                catch(Exception e){
                    System.out.println("faulty input, returning to main");
                }
                break;
            default:
                break;
        }
    }
    public void RemoveOrAddStudent(){
        Scanner myInput = new Scanner(System.in);
        System.out.println("1 to add new student \n2 to remove student\nany to return to start");
        String s = myInput.nextLine();
        switch(s){
            case "1":
                try{
                    System.out.println("Create new Student, start by entering a name");
                    String name = myInput.next();
                    System.out.println("now enter email address");
                    String email = myInput.next();
                    System.out.println("now address");
                    String address = myInput.next();
                    this.studentID = studentID + 1;
                    Student student = new Student(studentID, name, email, address);
                    stdl.saveStudent(student);
                }catch(Exception e){
                    System.out.println("faulty inputs, returning to main");
                }
                break;
            case "2":
                try{
                    System.out.println("Remove by entering the ID of the student");
                    for(Student c : stdl.findAll()){
                        System.out.println("name:"+ c.getName()+ " id:" +  c.getId() + " email:" + c.getEmail());
                    }
                    stdl.deleteStudent(stdl.findById(myInput.nextInt()));}
                catch(Exception e){
                    System.out.println("faulty input, returning to main");
                }
                break;
            default:
                break;
        }
    }
    public void AddStudentToCourse(){
        Scanner myInput = new Scanner(System.in);
       try{
        System.out.println("Choose wich course to add students to by entering the ID");
        for(Course c : ctdl.findAll()){
            System.out.println("name: "+ c.getCourseName() + " Id: " + c.getId() + " startdate: " + c.getStartDate());
        }
        int courseId = myInput.nextInt();
        System.out.println("Choose wich Student to add to course to by entering the ID");
        for(Student c : stdl.findAll()){
            System.out.println("name:"+ c.getName()+ " id:" +  c.getId() + " email:" + c.getEmail());
        }
        int studentId = myInput.nextInt();
        ctdl.findById(courseId).register(stdl.findById(studentId));
     }catch(Exception e){
           System.out.println("faulty inputs"); }
    }
    public void RemoveStudentFromCourse(){
        Scanner myInput = new Scanner(System.in);
        try{
            System.out.println("Choose wich course to remove students to by entering the ID");
            for(Course c : ctdl.findAll()){
                System.out.println("name: "+ c.getCourseName() + " Id: " + c.getId() + " startdate: " + c.getStartDate());
            }
            int courseId = myInput.nextInt();
            System.out.println("Choose wich Student to remove from the course to by entering the ID");
            for(Student c : stdl.findAll()){
                System.out.println("name:"+ c.getName()+ " id:" +  c.getId() + " email:" + c.getEmail());
            }
            int studentId = myInput.nextInt();
            ctdl.findById(courseId).unregister(stdl.findById(studentId));
        }catch(Exception e){
            System.out.println("faulty inputs"); }
    }
    public void SearchForCourse(){
      try{
        Scanner myInput = new Scanner(System.in);
        System.out.println("1 to search by id\n2 to search by name\n3 to search by startdate\n 4 to see all courses\nany to return");
        String x = myInput.nextLine();
        switch(x){
            case "1":
                System.out.println("Enter Id");
                int i = myInput.nextInt();
                System.out.println("Name:"+ctdl.findById(i).getCourseName()+" Id:"+ctdl.findById(i).getId()+ " StartDate:"+ ctdl.findById(i).getStartDate()+ " WeekDurations:" + ctdl.findById(i).getWeekDuration());
                break;
            case "2":
                System.out.println("Enter Name");
                String s = myInput.nextLine();
                for(Course course : ctdl.findByName(s)){
                System.out.println("Name:"+course.getCourseName()+" Id:"+course.getId()+ " StartDate:"+ course.getStartDate()+ " WeekDurations:" +course.getWeekDuration());
                }
            break;
            case "3":
                System.out.println("enter startdate formatted as yyyy-mm-dd");
                LocalDate l = LocalDate.parse(myInput.nextLine());
                for(Course course : ctdl.findByDate(l)){
                    System.out.println("Name:"+course.getCourseName()+" Id:"+course.getId()+ " StartDate:"+ course.getStartDate()+ " WeekDurations:" +course.getWeekDuration());
                }
            case "4":
                for(Course course : ctdl.findAll()){
                System.out.println("Name:"+course.getCourseName()+" Id:"+course.getId()+ " StartDate:"+ course.getStartDate()+ " WeekDurations:" +course.getWeekDuration());
                break;
            }
        }
      }catch(Exception n){
          System.out.println("faulty inputs");
      }
    }
    public void SearchForStudent(){
        try{
        Scanner myInput = new Scanner(System.in);
        System.out.println("1 to search by id\n2 to search by name\n3 to search by email\n 4 to see all students\nany to return");
        String x = myInput.nextLine();
        switch(x){
            case "1":
                System.out.println("Enter Id");
                int i = myInput.nextInt();
                System.out.println("Name:" + stdl.findById(i).getName() +" Id:"+stdl.findById(i).getId() + " Mail:"+ stdl.findById(i).getEmail() + " Address:" + stdl.findById(i).getAddress());
                break;
            case "2":
                System.out.println("Enter Name");
                String s = myInput.nextLine();
                for(Student student : stdl.findByName(s)){
                    System.out.println("Name:"+student.getName()+" Id:"+student.getId()+ " Mail:"+ student.getEmail()+ " Address:" +student.getAddress());
                }
                break;
            case "3":
                System.out.println("email");
                String l = myInput.nextLine();
                System.out.println("Name:"+stdl.findByEmail(l).getName()+" Id:"+stdl.findByEmail(l).getId()+ " Mail:"+ stdl.findByEmail(l).getEmail()+ " Address:" +stdl.findByEmail(l).getAddress());
            case "4":
                for(Student student : stdl.findAll()){
                    System.out.println("Name:"+student.getName()+" Id:"+student.getId()+ " Mail:"+ student.getEmail()+ " Address:" +student.getAddress());
                    break;
                }
        } }catch(Exception n){
        System.out.println("faulty inputs");
    }
    }
    public void EditCourse(){}
    public void EditStudent(){}
}


