package JobSearcher;
import java.util.ArrayList;
import java.util.UUID;
/**
 * The employer class
 * @author The Back Rowers
 */
public class Employer extends User{
    private UUID employerID;
    private Boolean isAdmin; 
    private String firstName;
    private String lastName;
    private ArrayList<Job> listings;
    private Company company;
    private String phoneNumber;
    /**
     * The employer constructor
     */
    public Employer(){
        setType();  
        setIsAdmin();
        listings = new ArrayList<>();
    }
    /**
     * Sets the type of user to employer
     */
    public void setType() {
      super.typeOfUser = "Employer";
    }
    /**
     * Sets that the user is not an admin
     */
    public void setIsAdmin() {
        this.isAdmin = false;
    }
    /**
     * Sets the listings 
     * @param listings The job listings
     */
    public void setListings(ArrayList<Job> listings) {
        this.listings = listings;
    }
    /**
     * Sets the UUID of the employer
     * @param employerID The UUID of the employer
     */
    public void setEmployerID(UUID employerID) {
      this.employerID = employerID;
    }
    /**
     * Sets the company 
     * @param companyID The UUID of the company
     */
    public void setCompany(UUID companyID){
      Companies list = Companies.getInstance();
      this.company = list.getCompany(companyID);
    }
    /**
     * Sets the username of the employer
     * @param username The username of the employer
     */
    public void setUsername(String username){
      super.username = username;
    }
    /**
     * Sets the password of the employer
     * @param password The password of the employer
     */
    public void setPassword(String password){
      super.password = password;
    }
    /**
     * Sets the first name of the employer
     * @param firstName The first name of the employer
     */
    public void setFirstName(String firstName){
      this.firstName = firstName;
    }
    /**
     * Sets the last name of the employer
     * @param lastName The last name of the employer
     */
    public void setLastName(String lastName){
      this.lastName = lastName;
    }
    /**
     * Sets the phone number of the employer
     * @param phoneNumber The phone number of the employer
     */
    public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
    }
    /**
     * Gets whether the user is an admin
     * @return Returns true or false
     */
    public Boolean getIsAdmin() {
        return isAdmin;
    }
    /**
     * Gets the UUID of the employer
     * @return Returns the UUID
     */
    public UUID getEmployerID() {
      return employerID;
    }
    /**
     * Gets the first name of the employer
     * @return Returns the first name
     */
    public String getFirstName() {
      return firstName;
    }
    /**
     * Gets the last name of the employer
     * @return Returns the last name
     */
    public String getLastName() {
      return lastName;
    }
    /**
     * Gets the job listings
     * @return Returns list of jobs
     */
    public ArrayList<Job> getListings() {
      Jobs.getInstance();
      return listings;
    }
    /**
     * Gets the phone number of the employer
     * @return Returns the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * Gets the company that the employer works for
     * @return Returns the company
     */
    public Company getCompany() {
        return company;
    }
    public void addListing(Job job) {
      listings.add(job);
    }
    /**
     * Creates a job
     * @param name The name of the job
     * @param startDate The start date of the job
     * @param endDate The end date of the job
     * @param salary The salary of the job
     * @param description The description of the job
     * @param location The location of the job
     * @param isRemote Whether the job is remote 
     * @param company The company that the job is under
     * @param employer The employer offering the job
     * @return Returns a job
     */
    public Job createJob(String name, String startDate, String endDate, Double salary,String description,String location,boolean isRemote, Company company,Employer employer){
       Job listing = Jobs.getInstance().createJob(name, startDate, endDate, salary, description, location, isRemote, company, employer);
      return listing;
    }
    /**
     * Adds the job to the list of available jobs
     * @param job The job that is being offered
     */
    public void postJob(Job job){
      Jobs.getInstance().addJob(job);
    }
    /**
     * Shows the list of applications
     * @param job The job that the employer wants to see the applications of
     * @return Returns list of applications
     */
    public ArrayList<Application> seeApplications(Job job){
        return job.getApplications();
    }
    /**
     * Gets the ratings of the student
     * @param student The student that the employer wants to see the ratings of
     * @return Returns the ratings of the student
     */
    public Ratings getRatings(Student student){
        return student.getRatings();
    }
    /**
     * The employer gives the student a rating 
     * @param student The student that the employer is rating
     */
    public void rateStudent(Student student){

    }
}

