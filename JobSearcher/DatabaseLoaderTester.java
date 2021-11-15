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

        Student newStudent1 = new Student();
        newStudent.setUsername("johnT");
        newStudent.setPassword("soda444");
        newStudent.setFirstName("John");
        newStudent.setLastName("Travolta");
        newStudent.setGpa("2.9");
        newStudent.setEduAccount("johnT@email.sc.edu");

        Student newStudent2 = new Student();
        newStudent.setUsername("frankeatsbeans");
        newStudent.setPassword("pinto4life");
        newStudent.setFirstName("Frank");
        newStudent.setLastName("Sint");
        newStudent.setGpa("4.0");
        newStudent.setEduAccount("sint11@email.sc.edu");

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
