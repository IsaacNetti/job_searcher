package JobSearcher;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class DatabaseWriterTester {
    private Users users = Users.getInstance();
    private ArrayList<Student> studentList = users.getStudents();
    @BeforeEach
    public void setup(){
        Users.getInstance().getStudents().clear();
        DatabaseWriter.saveStudents();
    }
    @AfterEach
    public void reset(){
        Users.getInstance().getStudents().clear();
        DatabaseWriter.saveStudents();
    }
    @Test
    void testWritingZeroUsers(){
        studentList = DatabaseLoader.loadStudents();
        assertEquals(0,studentList.size());
    }
    @Test
    void testWritingOneUser(){
        Student newStudent = new Student();
        newStudent.setUsername("tag01");
        newStudent.setPassword("pop123");
        newStudent.setFirstName("Tag");
        newStudent.setLastName("Smith");
        newStudent.setGpa("3.0");
        newStudent.setEduAccount("tagS@email.sc.edu");
        DatabaseWriter.saveStudents();
        assertEquals("tag01", DatabaseLoader.loadStudents().get(0).getUsername());
    }
    @Test
    void testWritingFourUsers(){
        Student newStudent = new Student();
        newStudent.setUsername("tag01");
        newStudent.setPassword("pop123");
        newStudent.setFirstName("Tag");
        newStudent.setLastName("Smith");
        newStudent.setGpa("3.0");
        newStudent.setEduAccount("tagS@email.sc.edu");

        Student newStudent1 = new Student();
        newStudent.setUsername("tag01");
        newStudent.setPassword("pop123");
        newStudent.setFirstName("Tag");
        newStudent.setLastName("Smith");
        newStudent.setGpa("3.0");
        newStudent.setEduAccount("tagS@email.sc.edu");

        Student newStudent2 = new Student();
        newStudent.setUsername("tag01");
        newStudent.setPassword("pop123");
        newStudent.setFirstName("Tag");
        newStudent.setLastName("Smith");
        newStudent.setGpa("3.0");
        newStudent.setEduAccount("tagS@email.sc.edu");

        Student newStudent3 = new Student();
        newStudent.setUsername("tag01");
        newStudent.setPassword("pop123");
        newStudent.setFirstName("Tag");
        newStudent.setLastName("Smith");
        newStudent.setGpa("3.0");
        newStudent.setEduAccount("tagS@email.sc.edu");

        DatabaseWriter.saveStudents();
        assertEquals("tag01",DatabaseLoader.loadStudents().get(2).getUsername());
    } 
    @Test
    void testWritingEmptyUser(){
        Student newStudent = new Student();
        newStudent.setUsername("");
        newStudent.setPassword("");
        newStudent.setFirstName("");
        newStudent.setLastName("");
        newStudent.setGpa("");
        newStudent.setEduAccount("");
        DatabaseWriter.saveStudents();
        assertEquals("",DatabaseLoader.loadStudents().get(0).getUsername());
    }
    @Test
    void testWritingNullUser(){
        Student newStudent = new Student();
        newStudent.setUsername(null);
        newStudent.setPassword("");
        newStudent.setFirstName("");
        newStudent.setLastName("");
        newStudent.setGpa("");
        newStudent.setEduAccount("");
        DatabaseWriter.saveStudents();
        assertEquals(null,DatabaseLoader.loadStudents().get(0).getUsername());
    }
}
