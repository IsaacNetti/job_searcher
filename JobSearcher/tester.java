package JobSearcher;

import java.util.ArrayList;

public class tester {
    public static void main(String Args[]) {
        Users c = Users.getInstance();
        ArrayList<Student> list = c.getStudents();
        System.out.println(c.haveStudent("KayleeQ188"));
    }
}
