package JobSearcher;
import java.util.ArrayList;
import java.util.UUID;

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
    public void createStudent(Student student){
      studentList.add(student);
      DatabaseWriter.saveStudents();
    }
    public void deleteStudent(Student student){
      studentList.remove(student);
      DatabaseWriter.saveStudents();
    }
    public boolean haveStudent(String username){
        for (Student c : studentList) {
            if (c.getUsername() == username) {
              return true;
            }
          }
          System.out.println("User does not exist");
          return false;
    }
    public Student getStudent(UUID studentID){
        for (Student c : studentList) {
            if (c.getStudentId() == studentID) {
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
    public void createEmployer(Employer employer){
      employerList.add(employer);
      DatabaseWriter.saveEmployers();
  }
  public void deleteEmployer(Employer employer){
    employerList.remove(employer);
    DatabaseWriter.saveEmployers();
}
    public Employer getEmployer(UUID employerID){
      for (Employer c : employerList) {
          if (c.getEmployerID() == employerID) {
            return c;
          }
        }
        System.out.println("User does not exist");
        return null;
  }
  public ArrayList<Employer> getEmployers(){
    return employerList;
  }
  public ArrayList<Student> getStudents(){
    return studentList;
  }
}
