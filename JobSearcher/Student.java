package JobSearcher;
import java.util.ArrayList;
import java.util.UUID;

public class Student {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private double gpa;
    private UUID studentId;
    private String eduAccount;
    private String phoneNumber;
    private ArrayList<Job> favorites;
    private Ratings ratings;

    public Student(){

    }
    public void setStudentID(UUID studentID) {
        this.studentId = studentID;
    }
    public void setUsername(String username) {
      this.username = username;
    }
    public void setPassword(String password) {
      this.password = password;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
      this.lastName = lastName;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public void setEduAccount(String eduAccount) {
      this.eduAccount = eduAccount;
  }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Ratings getRatings(){
        return this.ratings;
    }
    public UUID getStudentId() {
        return studentId;
    }
    public void apply(Job job, Student student){
        job.addApplicant(student);
    }
    public Resume createResume(){
        Resume studentsResume = new Resume();
        return studentsResume;
    }
    public void addRating(int rating, String review){
        
    }
}
