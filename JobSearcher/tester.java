package JobSearcher;

import java.util.ArrayList;

public class tester {
    public static void main(String Args[]) {
        Users c = Users.getInstance();
        ArrayList<Employer> list = c.getEmployers();
        for (Employer e : list) {
          System.out.println(e.getUsername());
        }
    }
}
