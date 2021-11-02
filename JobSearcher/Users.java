package JobSearcher;
import java.util.ArrayList;
import java.util.UUID;
/**
 * The users class
 * @author The Back Rowers
 */
public class Users {
    private static Users users;
    private ArrayList<Student> studentList;
    private ArrayList<Employer> employerList;
    private ArrayList<Admin> adminList;
  /**
   * The users constructor
   */
    public Users(){
        //studentList = DatabaseLoader.loadStudents();
        employerList = DatabaseLoader.loadEmployers();
        //adminList = DatabaseLoader.loadAdmins();
    }
    /**
     * Creates an instance of the user
     * @return Returns users
     */
    public static Users getInstance(){
        if (users == null) {
            users = new Users();
          }
          return users;
    }
    /**
     * Creates an admin
     * @param admin The user that is becoming an admin
     */
    public void createAdmin(Admin admin){
      adminList.add(admin);
      DatabaseWriter.saveAdmins();
    }
    /**
     * Deletes an admin
     * @param admin The admin that is being deleted
     */
    public void deleteAdmin(Admin admin){
      adminList.remove(admin);
      DatabaseWriter.saveAdmins();
    }
    /**
     * Checks if a user is an admin
     * @param username The username that is checked
     * @return Returns true or false
     */
    public boolean haveAdmin(String username){
        for (Admin a : adminList) {
            if (a.getUsername() == username) {
              return true;
            }
          }
          System.out.println("User does not exist");
          return false;
    }
    /**
     * Gets an admin
     * @param adminID The UUID of the admin
     * @return Returns the admin
     */
    public Admin getAdmin(UUID adminID){
        for (Admin a : adminList) {
            if (a.getID() == adminID) {
              return a;
            }
          }
          System.out.println("User does not exist");
          return null;
    }
    /**
     * Creates a student user
     * @param student The user that is being created
     */
    public void createStudent(Student student){
      studentList.add(student);
      DatabaseWriter.saveStudents();
    }
    /**
     * Deletes a student user
     * @param student The user that is being deleted
     */
    public void deleteStudent(Student student){
      studentList.remove(student);
      DatabaseWriter.saveStudents();
    }
    /**
     * Checks if a user is a student
     * @param username The username that is being checked
     * @return Returns true or false
     */
    public boolean haveStudent(String username){
        for (Student c : studentList) {
            if (c.getUsername() == username) {
              return true;
            }
          }
          System.out.println("User does not exist");
          return false;
    }
    /**
     * Gets the student 
     * @param studentID The UUID of the student
     * @return Returns the student
     */
    public Student getStudent(UUID studentID){
        for (Student c : studentList) {
            if (c.getStudentId() == studentID) {
              return c;
            }
          }
          System.out.println("User does not exist");
          return null;
    }
    /**
     * Checks if an employer exists
     * @param username The username that is being checked
     * @return Returns true or false
     */
    public boolean haveEmployer(String username){
      for (Employer c : employerList) {
          if (c.getUsername() == username) {
            return true;
          }
        }
        return false;
    }
    /**
     * Creates an employer
     * @param employer The user that is becoming an admin
     */
    public void createEmployer(Employer employer){
      employerList.add(employer);
      DatabaseWriter.saveEmployers();
    }
    /**
     * Deletes an employer
     * @param employer The user that is being deleted
     */
    public void deleteEmployer(Employer employer){
      employerList.remove(employer);
      DatabaseWriter.saveEmployers();
    }
    /**
     * Gets an employer
     * @param employerID The UUID of the employer
     * @return Returns the employer
     */
    public Employer getEmployer(UUID employerID){
      for (Employer c : employerList) {
          if (c.getEmployerID() == employerID) {
            return c;
          }
        }
        System.out.println("User does not exist");
        return null;
  }
  /**
   * Gets the list of employers
   * @return Returns the list of employers
   */
  public ArrayList<Employer> getEmployers(){
    return employerList;
  }
  /**
   * Gets the list of students
   * @return Returns the list of students
   */
  public ArrayList<Student> getStudents(){
    return studentList;
  }
  /**
   * Gets the list of admins
   * @return Returns the list of admins
   */
  public ArrayList<Admin> getAdmins(){
    return adminList;
  }
}
