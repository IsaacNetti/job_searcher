package JobSearcher;
import java.util.ArrayList;
import java.util.UUID;

public class Student extends User{
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String gpa;
    private UUID studentId;
    private String eduAccount;
    private String phoneNumber;
    private ArrayList<Job> favorites;
    private Ratings ratings;
    private Resume resume;

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
    public void setGpa(String gpa) {
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
    public String getUsername() {
        return username;
    }
    public void apply(Job job, Student student){
        job.addApplicant(student);
    }
    public void createResume(String skills, String education, String achievements, ArrayList<Experience> workExperience){
        this.resume = new Resume();
        this.resume.setSkills(skills);
        this.resume.setEducation(education);
        this.resume.setAchievements(achievements);
        this.resume.setWorkExperience(workExperience);
    }
    public void addRating(int rating, String review){
        
    }
    
}
