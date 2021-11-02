package JobSearcher;

import java.util.ArrayList;
import java.util.UUID;

public class tester {
    public static void main(String Args[]) {
        Users c = Users.getInstance();
        ArrayList<Student> list = c.getStudents();
        System.out.println(c.haveStudent("KayleeQ188"));
        UUID studentid = UUID.fromString("34644dad-c03e-4cd4-b1a9-d2e5d1c9483"); 
        Student student = c.getStudent(studentid);
        JobSystem system = new JobSystem();
        system.saveResume(student.getResume(), "yurmom");
    }


}
