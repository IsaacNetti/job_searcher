package JobSearcher;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class DatabaseLoaderTester {
    private Users student = Users.getInstance();
    private ArrayList<Student> studentList = student.getStudents();

    @BeforeEach
    public void setup(){
        studentList.clear();
        Student newStudent = new Student();
        newStudent.setUsername("tag01");
        newStudent.setPassword("pop123");
        newStudent.setFirstName("Tag");
        newStudent.setLastName("Smith");
        newStudent.setGpa("3.0");
        newStudent.setEduAccount("tagS@email.sc.edu");
        Ratings ratings = new Ratings();
        ArrayList<Integer> rate = new ArrayList<>();
        rate.add(4);
        ratings.setRatings(rate);
        newStudent.setRatings(ratings);
        student.createStudent(newStudent);

        Student newStudent1 = new Student();
        newStudent1.setUsername("johnT");
        newStudent1.setPassword("soda444");
        newStudent1.setFirstName("John");
        newStudent1.setLastName("Travolta");
        newStudent1.setGpa("2.9");
        newStudent1.setEduAccount("johnT@email.sc.edu");
        newStudent1.setRatings(ratings);
        student.createStudent(newStudent1);

        Student newStudent2 = new Student();
        newStudent2.setUsername("frankeatsbeans");
        newStudent2.setPassword("pinto4life");
        newStudent2.setFirstName("Frank");
        newStudent2.setLastName("Sint");
        newStudent2.setGpa("4.0");
        newStudent2.setEduAccount("sint11@email.sc.edu");
        newStudent2.setRatings(ratings);
        student.createStudent(newStudent2);
        DatabaseWriter.saveStudents();
    }
    @AfterEach
    public void reset(){
        Users.getInstance().getStudents().clear();
        DatabaseWriter.saveStudents();
    }
    @Test
    void testGetStudentsSize(){
        studentList = DatabaseLoader.loadStudents();
        assertEquals(3, studentList.size());
    }
    @Test
    void testGetStudentsSizeZero(){
        Users.getInstance().getStudents().clear();
        DatabaseWriter.saveStudents();
        assertEquals(0, studentList.size());
    }
    @Test
    void testGetUserLastName(){
        studentList = DatabaseLoader.loadStudents();
        assertEquals("Smith", studentList.get(0).getLastName());
    }
}
