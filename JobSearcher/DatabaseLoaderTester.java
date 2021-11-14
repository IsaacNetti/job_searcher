package JobSearcher;

import java.util.ArrayList;
import 
public class DatabaseLoaderTester {
    private Users student = Users.getInstance();
    private ArrayList<Student> studentList = student.getStudents();

    public void setup(){
        studentList.clear();
        Student newStudent = new Student();
        newStudent.setUsername("tag01");
        newStudent.setPassword("pop123");
        newStudent.setFirstName("Tag");
        newStudent.setLastName("Smith");
        newStudent.setGpa("3.0");
        newStudent.setEduAccount("tagS@email.sc.edu");
    }

    public void reset(){
        Users.getInstance().getStudents().clear();
        DatabaseWriter.saveStudents();
    }

    void testGetStudentsSize(){
        studentList = DatabaseLoader.loadStudents();
        assertEquals(3, studentList.size());
    }

    void testGetStudentsSizeZero(){
        Users.getInstance().getStudents().clear();
        DatabaseWriter.saveStudents();
        assertEquals(0, studentList.size());
    }

    void testGetUserLastName(){
        studentList = DatabaseLoader.loadStudents();
        assertEquals("Smith",studentList.get(0).getLastName());
    }
}
