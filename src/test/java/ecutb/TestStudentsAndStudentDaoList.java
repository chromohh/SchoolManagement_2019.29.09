package ecutb;

import ecutb.data_access.StudentDaoList;
import ecutb.model.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestStudentsAndStudentDaoList {
    private Student testStudent;
    private Student testStudent1;
    private Student testStudent2;
    private StudentDaoList testEmptyStudentDaoList;
    private StudentDaoList testNotEmptyStudentDaoList;

    @Before
    public void init(){
        testStudent = new Student(13, "Adam Adamsson","adam@mail.se", "Adamgatan 15");
        testStudent1 = new Student(14, "Håka Håkansson", "håkan@mail.se", "Håkanvägen 13");
        testStudent2 = new Student(15, "Edvin Edvinsson", "edvin@mail.se", "Edvinvägen 25");
        testEmptyStudentDaoList = new StudentDaoList();
        testNotEmptyStudentDaoList = new StudentDaoList();
        testNotEmptyStudentDaoList.saveStudent(testStudent);
        testNotEmptyStudentDaoList.saveStudent(testStudent1);
        testNotEmptyStudentDaoList.saveStudent(testStudent2);
    }

    @Test
    public void testGettersAndSettersForStudent(){
        Assert.assertEquals(testStudent.getAddress(),"Adamgatan 15" );
        Assert.assertEquals(testStudent.getEmail(),"adam@mail.se");
        Assert.assertEquals(testStudent.getId(), 13);
        Assert.assertEquals(testStudent.getName(), "Adam Adamsson");
        testStudent.setAddress("Adamvägen 73");
        testStudent.setEmail("adam1@mail.se");
        Assert.assertEquals(testStudent.getEmail(), "adam1@mail.se");
        Assert.assertEquals(testStudent.getAddress(),"Adamvägen 73" );
    }

    @Test
    public void TestSaveStudentsAndDelete(){
        List<Student> expected = new ArrayList<>();
        expected.add(testStudent);
        expected.add(testStudent1);

        StudentDaoList localTest = new StudentDaoList(); //här borde jag egentligen skapat en after metod så att jag inte hade behövt göra en ny lista.
        localTest.saveStudent(testStudent);
        localTest.saveStudent(testStudent);
        localTest.saveStudent(testStudent1);
        Assert.assertEquals(localTest.findAll(), expected);

        Assert.assertTrue(localTest.deleteStudent(testStudent));
        Assert.assertFalse(localTest.deleteStudent(testStudent));

    }
    @Test
    public void TestFindMethods() {
        Assert.assertNull(testNotEmptyStudentDaoList.findByEmail("asd"));
        Assert.assertEquals(testNotEmptyStudentDaoList.findByEmail("adam@mail.se"), testStudent);
        Assert.assertEquals(testNotEmptyStudentDaoList.findByEmail("ADAM@MAIL.SE"), testStudent);

        List<Student> expected = new ArrayList<>();
        List<Student> expectedEmpty = new ArrayList<>();
        expected.add(testStudent);
        Assert.assertEquals(testNotEmptyStudentDaoList.findByName("Adam Adamsson"), expected);
        Assert.assertEquals(testNotEmptyStudentDaoList.findByName("adam adamsson"), expected);
        Assert.assertEquals(testNotEmptyStudentDaoList.findByName("asd"), expectedEmpty);

        Assert.assertEquals(testNotEmptyStudentDaoList.findById(15), testStudent2);
        Assert.assertNull(testNotEmptyStudentDaoList.findById(999));
    }

}
