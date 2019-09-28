package ecutb;

import ecutb.AppHelper;

import java.sql.SQLOutput;
import java.util.Scanner;

public class App
{
    private static AppHelper help = new AppHelper();

    public static void main( String[] args )
    {
        System.out.println("School Management Systém™");

        boolean keepAlive = true;
        while(keepAlive){
            Scanner myInput = new Scanner(System.in);
            System.out.println("1 to add or remove course\n2 to add or remove student\n3 to add or remove student from course\n4 to search for student\n5 to search for course\n6 to edit course\n7 to edit student\nE to exit");
            String x = myInput.nextLine();
            switch(x){
                case "1": help.RemoveOrAddCourse();
                break;
                case "2": help.RemoveOrAddStudent();
                break;
                case "3": RemoveorAddStudentFromCourse();
                break;
                case "4": help.SearchForStudent();
                case "5": help.SearchForCourse();
                case "6":
                case "7":

                case "E": keepAlive = false; break;
            }
        }

    }

    public static void RemoveorAddStudentFromCourse(){
        Scanner myInput = new Scanner(System.in);
        System.out.println("1 to add to course\n2 to remove from course\n any to return");
        String s = myInput.nextLine();
        switch(s){
            case "1" : help.AddStudentToCourse();
            break;
            case "2" : help.RemoveStudentFromCourse();
            break;
        }
    }
}
