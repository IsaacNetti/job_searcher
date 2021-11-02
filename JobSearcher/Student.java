package JobSearcher;
import java.util.ArrayList;
import java.util.UUID;
/**
 * The student class
 * @author The Back Rowers
 */
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
    /**
     * The student constructor
     */
    public Student(){
        setType();
        setIsAdmin();
        favorites = new ArrayList<>();
        applications = new ArrayList<>();
    }
    /**
     * Checks if user is admin
     */
    public void setIsAdmin() {
        this.isAdmin = false;
    }
    /**
     * Sets the type of user as student
     */
    public void setType() {
        super.typeOfUser = "Student";
    }
    /**
     * Sets the UUID of the student
     * @param studentID The UUID of the student
     */
    public void setStudentID(UUID studentID) {
        this.studentID = studentID;
    }
    /**
     * Sets the username of the student
     * @param username The username of the student
     */
    public void setUsername(String username) {
      this.username = username;
    }
    /**
     * Sets the password of the student
     * @param password The password of the student
     */
    public void setPassword(String password) {
      this.password = password;
    }
    /**
     * Sets the first name of the student
     * @param firstName The first name of the student
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Sets the last name of the student
     * @param lastName The last name of the student
     */
    public void setLastName(String lastName) {
      this.lastName = lastName;
    }
    /**
     * Sets the GPA of the student
     * @param gpa The GPA of the student
     */
    public void setGpa(String gpa) {
        this.gpa = gpa;
    }
    /**
     * Sets the eduAccount of the student
     * @param eduAccount The eduAccount of the student
     */
    public void setEduAccount(String eduAccount) {
      this.eduAccount = eduAccount;
  }
  /**
     * Sets the phone number of the student
     * @param phoneNumber The phone number of the student
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     * Sets the ratings of the student
     * @param ratings The ratings of the student
     */
    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }
    /**
     * Sets the resume of the student
     * @param resume The resume of the student
     */
    public void setResume(Resume resume) {
        this.resume = resume;
    }
    /**
     * Sets the application of the student
     * @param username The username of the student
     */
    public void setApplications(ArrayList<Application> applications) {
        this.applications = applications;
    }
    /**
     * Gets whether the user is an admint
     */
    public Boolean getIsAdmin() {
        return isAdmin;
    }
    /**
     * Gets the ratings
     * @return Returns ratings
     */
    public Ratings getRatings(){
        return this.ratings;
    }
    /**
     * Gets the UUID of the student
     * @return Returns UUID of the student
     */
    public UUID getStudentId() {
        return studentID;
    }
    /**
     * Gets the username
     * @return Returns username
     */
    public String getUsername() {
        return username;
    }
    /**
     * Adds an application to list of applications 
     * @param application The application that is being added
     */
    public void addApplication(Application application){
      applications.add(application);
    }
    /**
     * Applies to a job
     * @param job The job that is being applied to
     */
    public void apply(Job job) {
        Application a = new Application(studentID, job.getJobID());
    }
    /**
     * Creates a resume
     * @param skills The skills of the resume
     * @param education The education of the resume
     * @param achievements The achievements of the resume
     * @param workExperience The experience of the resume
     */
    public void createResume(String skills, String education, String achievements, ArrayList<Experience> workExperience){
        this.resume = new Resume();
        this.resume.setSkills(skills);
        this.resume.setEducation(education);
        this.resume.setAchievements(achievements);
        this.resume.setWorkExperience(workExperience);
    }
    /**
     * Adds jobs to favorites list
     * @param jobID The UUID of the job that is being favorited
     */
    public void addFavorites(UUID jobID) {
        Jobs list = Jobs.getInstance();
        favorites.add(list.getJob(jobID));
    }
    /**
     * Adds rating
     * @param rating The rating that is added to the employer
     */
    public void addRating(int rating){
        ratings.addRating(rating);
    }  
    /**
     * The toString of the student
     * @return Returns a string
     */
    public String toString(){
        return "";
    }
    /**
     * Gets the first name of the student
     * @return Returns the first name
     */
    public String getFirstName(){
        return firstName;
    }
    /**
     * Gets the last name of the student
     * @return Returns the last name
     */
    public String getLastName(){
        return lastName;
    }
    /**
     * Gets the GPA of the student
     * @return Returns the GPA
     */
    public String getGPA(){
        return gpa;
    }
    /**
     * Gets the eduAccount of the student
     * @return Returns the eduAccount
     */
    public String getEduAccount(){
        return eduAccount;
    }
    /**
     * Gets the phone number of the student
     * @return Returns the phone number
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }
    /**
     * Gets the favorites of the student
     * @return Returns the favorites
     */
    public ArrayList<Job> getFavorites(){
        return favorites;
    }
    /**
     * Gets the resume of the student
     * @return Returns the resume
     */
    public Resume getResume(){
        return resume;
    }
    /**
     * Gets the experience of the student
     * @return Returns the experiences
     */
    public ArrayList<Experience> getExperience(){
        return resume.getWorkExperience();
    }
    /**
     * Gets the applications of the student
     * @return Returns the applications
     */
    public ArrayList<Application> getApplications() {
      return this.applications;
    }
    /**
     * Strings together student information and their respective resume
     * @return Returns a string with information
     */
    public String resumeWriter(){
        return "Resume\n" + this.getFirstName() +" "+ this.getLastName()+"\n"+this.getEduAccount()+"\nGPA: "+this.getGPA()+"\nPhone number: "+ this.getPhoneNumber()+resume.toString();
    }
}
