package JobSearcher;
import java.util.ArrayList;
import java.util.UUID;
/**
 * The job class
 * @author The Back Rowers
 */
public class Job {
    private UUID jobID;  
    private String name;
    private String startDate;
    private String endDate;
    private Double salary;
    private String description;
    private String location;
    private boolean isRemote;
    private ArrayList<Application> applications;
    private Company company;
    private Employer employer;
    /**
     * The job constructor
     */
    public Job(){

    }
    /**
     * Sets the UUID of the job
     * @param jobID The UUID of the job
     */
    public void setJobID(UUID jobID) {
        this.jobID = jobID;
    }
    /**
     * Sets the name of the job
     * @param name The name of the job
     */
    public void setName(String name) {
      this.name = name;
    }
    /**
     * Sets the start date of the job
     * @param startDate The start date of the job
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    /**
     * Sets the end date of the job
     * @param endDate The end date of the job
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    /**
     * Sets the salary of the job
     * @param salary The salary of the job
     */
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    /**
     * Sets the description of the job
     * @param description The description of the job
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Sets the location of the job
     * @param location The location of the job
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /**
     * Sets if the job is remote
     * @param isRemote Whether the job is remote
     */
    public void setRemote(boolean isRemote) {
        this.isRemote = isRemote;
    }
    /**
     * Sets the company 
     * @param companyID The UUID of the company
     */
    public void setCompany(UUID companyID) {
        Companies list = Companies.getInstance();
        this.company = list.getCompany(companyID);
    }
    /**
     * Sets the employer 
     * @param employerID The UUID of the employer
     */
    public void setEmployer(UUID employerID) {
        Users list = Users.getInstance();
        this.employer = list.getEmployer(employerID);
        this.employer.addListing(this);;
    }
    /**
     * Adds an application to the list of job applications
     * @param application The application that is being added
     */
    public void addApplication(Application application){
        applications.add(application);
    }
    /**
     * Removes an application from the list of job applications
     * @param application The application that is being removed
     */
    public void removeApplication(Application application){
        applications.remove(application);
    }
    /**
     * Gets the start date of the job
     * @return Returns the start date of the job
     */
    public String getStartDate() {
        return startDate;
    }
    /**
     * Gets the end date of the job
     * @return Returns the end date of the job
     */
    public String getEndDate() {
        return endDate;
    }
    /**
     * Gets the salary of the job
     * @return Returns the salary of the job
     */
    public Double getSalary() {
        return salary;
    }
    /**
     * Gets the description of the job
     * @return Returns the description of the job
     */
    public String getDescription() {
        return description;
    }
    /**
     * Gets the company of the job
     * @return Returns the company of the job
     */
    public Company getCompany() {
        return company;
    }
    /**
     * Gets the employer of the job
     * @return Returns the employer of the job
     */
    public Employer getEmployer() {
        return employer;
    }
    /**
     * Gets the location of the job
     * @return Returns the location of the job
     */
    public String getLocation() {
        return location;
    }
    /**
     * Gets the name of the job
     * @return Returns the name of the job
     */
    public String getName() {
        return name;
    }
    /**
     * Gets whether the job is remote 
     * @return Returns whether the job is remote
     */
    public boolean getRemote(){
        return isRemote;
    }
    /**
     * Gets the UUID of the job
     * @return Returns the UUID of the job
     */
    public UUID getJobID() {
        return jobID;
    }
    /**
     * The toString of the job
     * @return Returns the toString of the job
     */
    public String toString(){
        return "Title: " + getName() + "\nCompany: " + getCompany().getName() + "\nLocation: " +getLocation() + "\nStart Date: " + getStartDate()
            + "\nEnd Date: " + getEndDate() + "\nSalary: " + getSalary() + "\nDescription: " + getDescription() + "\n";
    }
    /**
     * Gets the applications of the job
     * @return Returns the applications of the job
     */
    public ArrayList<Application> getApplications(){
        return applications;
    }
}
