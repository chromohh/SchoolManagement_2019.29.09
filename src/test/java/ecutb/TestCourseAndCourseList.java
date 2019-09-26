package ecutb;

import ecutb.data_access.StudentDao;
import ecutb.data_access.StudentDaoList;
import ecutb.model.Course;
import ecutb.model.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestCourseAndCourseList {
    private Course testcourse;
    private Course testcourse1;
    private Course testcourse2;
    private StudentDaoList emptyDaoList;
    private StudentDaoList daoList;
    private Student testStudent;

    @Before
    public void init(){
        testcourse = new Course(4, "Maths", LocalDate.parse("2020-08-04"), 36);
        testcourse1 = new Course(5, "Gym", LocalDate.parse("2020-08-12"), 40);
        testcourse2 = new Course(6, "Physics", LocalDate.parse("2020-09-08"), 25);
        emptyDaoList = new StudentDaoList();
        daoList = new StudentDaoList();
        daoList.saveCourse(testcourse);
        daoList.saveCourse(testcourse1);
        daoList.saveCourse(testcourse2);
        testStudent = new Student(15, "Edvin Edvinsson", "edvin@mail.se", "Edvinvägen 25");
    }

    @Test
    public void testGettersAndSetters(){
        Assert.assertEquals(testcourse.getCourseName(), "Maths");
        Assert.assertEquals(testcourse.getWeekDuration(), 36);
        Assert.assertEquals(LocalDate.parse("2020-08-04"), testcourse.getStartDate());
    }
    @Test
    public void testCourseRegisterAndUnregisterStudent(){
        testcourse.register(testStudent);
        testcourse.register(testStudent);
        List<Student> expected = new ArrayList<>();
        expected.add(testStudent);
        Assert.assertEquals(expected, testcourse.getStudents());

        expected.remove(testStudent);
        testcourse.unregister(testStudent);
        testcourse.unregister(testStudent);
        Assert.assertEquals(expected, testcourse.getStudents());
    }
    @Test
    public void testSaveCourseAndFindMethods(){
        Assert.assertNull(daoList.saveCourse(testcourse));

        List<Course> expectedDate = new ArrayList<>();
        expectedDate.add(testcourse1);
        Assert.assertEquals(expectedDate, daoList.findByDate(LocalDate.parse("2020-08-12")));
        Assert.assertEquals(daoList.findById(4), testcourse);
        Assert.assertNull(daoList.findById(99));
        Assert.assertEquals(daoList.findByName("gym"), expectedDate);

        List<Course> expected = new ArrayList<>();
        expected.add(testcourse);
        expected.add(testcourse1);
        expected.add(testcourse2);
        Assert.assertEquals(daoList.findAll(), expected);

    }

    @Test
    public void testRemove(){
        Assert.assertTrue(daoList.removeCourse(testcourse1));
        Assert.assertFalse(daoList.removeCourse(testcourse1));
    }
}
