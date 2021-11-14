package JobSearcher;
import java.util.ArrayList;

public class DatabaseWriterTester {
    private Users users = Users.getInstance();
    private ArrayList<Student> studentList = users.getStudents();

    public void setup(){
        Users.getInstance().getStudents().clear();
        DatabaseWriter.saveStudents();
    }

    public void reset(){
        Users.getInstance().getStudents().clear();
        DatabaseWriter.saveStudents();
    }

    void testWritingZeroUsers(){
        studentList = DatabaseLoader.loadStudents();
        assertEquals(0,studentList.size());
    }

    void testWritingOneUser(){
        studentList.add((new Student("tag01", "pop123","Tag","Smith")));
        DatabaseWriter.saveStudents();
        assertEquals("tag01", DatabaseLoader.loadStudents().get(0).getUsername());
    }

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
    } 

    void testWritingEmptyUser(){

        studentList.add(new Student("","","","",""));
        DatabaseWriter.saveStudents();
        assertEquals("",DatabaseLoader.loadStudents().get(0).getUsername());
    }

    void testWritingNullUser(){
        studentList.add(new Student(null,"","",0,""));
        DatabaseWriter.saveStudents();
        assertEquals(null,DatabaseLoader.loadStudents().get(0).getUsername());
    }
}
