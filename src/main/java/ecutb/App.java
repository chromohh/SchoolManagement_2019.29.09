package ecutb;

import ecutb.AppHelper;

import java.util.Scanner;

public class App
{

    public static void main( String[] args )
    {
        AppHelper help = new AppHelper();

        help.RemoveOrAddCourse();
        help.RemoveOrAddStudent();
        help.AddStudentToCourse();
        help.RemoveStudentFromCourse();

    }
}
