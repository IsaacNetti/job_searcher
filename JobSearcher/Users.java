package JobSearcher;
import java.util.ArrayList;

public class Users {
    private static Users users;
    private ArrayList<Student> studentList;
    private ArrayList<Employer> employerList;

    public Users(){
        studentList = DatabaseLoader.loadStudents();
        employerList = DatabaseLoader.loadEmployers();
    }
    public static Users getInstance(){
        if (users == null) {
            users = new Users();
          }
          return users;
    }
    public boolean haveStudent(String username){
        for (Student c : studentList) {
            if (c.getUsername() == username) {
              return true;
            }
          }
          return false;
    }
    public User getStudent(String username){
        for (Student c : studentList) {
            if (c.getUsername() == username) {
              return c;
            }
          }
          System.out.println("User does not exist");
          return null;
    }
    public boolean haveEmployer(String username){
      for (Employer c : employerList) {
          if (c.getUsername() == username) {
            return true;
          }
        }
        return false;
  }
  public User getEmployer(String username){
      for (Employer c : employerList) {
          if (c.getUsername() == username) {
            return c;
          }
        }
        System.out.println("User does not exist");
        return null;
  }
}
