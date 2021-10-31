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
    private Boolean isAdmin;
    private Ratings ratings;
    private Resume resume;

    public Student(){

    }
    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
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
    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }
    public void setResume(Resume resume) {
        this.resume = resume;
    }
    public Boolean getIsAdmin() {
        return isAdmin;
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
    public void addRating(int rating){
        ratings.addRating(rating);
    }
    
    public String toString(){
        return "";
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getGPA(){
        return gpa;
    }
    public String getEduAccount(){
        return eduAccount;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public ArrayList<Job> getFavorites(){
        return favorites;
    }
    public Resume getResume(){
        return resume;
    }
    public String getEducation(){
        return education;
    }
    public String getAchievements(){
        return achievements;
    }
    public String getSkills(){
        return skills;
    }
    public String getExperience(){
        return workExperience;
    }
}
