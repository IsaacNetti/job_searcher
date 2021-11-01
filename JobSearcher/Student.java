package JobSearcher;
import java.util.ArrayList;
import java.util.UUID;

public class Student extends User{
    private String firstName;
    private String lastName;
    private String gpa;
    private UUID studentID;
    private String eduAccount;
    private String phoneNumber;
    private ArrayList<Job> favorites;
    private Boolean isAdmin;
    private Ratings ratings;
    private Resume resume;
    private ArrayList<Application> applications;

    public Student(){
        setType();
        setIsAdmin();
        favorites = new ArrayList<>();
        applications = new ArrayList<>();
    }
    public void setIsAdmin() {
        this.isAdmin = false;
    }
    public void  setType() {
        super.typeOfUser = "Student";
    }
    public void setStudentID(UUID studentID) {
        this.studentID = studentID;
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
    public void setApplications(ArrayList<Application> applications) {
        this.applications = applications;
    }
    public Boolean getIsAdmin() {
        return isAdmin;
    }
    public Ratings getRatings(){
        return this.ratings;
    }
    public UUID getStudentId() {
        return studentID;
    }
    public String getUsername() {
        return username;
    }
    public void addApplication(Application application){
      applications.add(application);
    }
    public void apply(Job job) {
        Application a = new Application(studentID, job.getJobID());
        job.addApplication(a);
        applications.add(a);
    }
    public void createResume(String skills, String education, String achievements, ArrayList<Experience> workExperience){
        this.resume = new Resume();
        this.resume.setSkills(skills);
        this.resume.setEducation(education);
        this.resume.setAchievements(achievements);
        this.resume.setWorkExperience(workExperience);
    }
    public void addFavorites(UUID jobID) {
        Jobs list = Jobs.getInstance();
        favorites.add(list.getJob(jobID));
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
    public ArrayList<Experience> getExperience(){
        return resume.getWorkExperience();
    }
    public ArrayList<Application> getApplications() {
      return this.applications;
    }
}
