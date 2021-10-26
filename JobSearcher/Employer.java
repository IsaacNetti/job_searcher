package JobSearcher;
import java.util.ArrayList;
import java.util.UUID;

public class Employer {
    private UUID employerID;
    private UUID companyID;  
    private String username;
    private String password;  
    private String firstName;
    private String lastName;
    private ArrayList<Job> listings;
    private String company;
    private String phoneNumber;

    public Employer(){

    }
    public void setEmployerID(UUID employerID) {
      this.employerID = employerID;
    }
    public void setCompanyID(UUID companyID) {
      this.companyID = companyID;
    }
    public void setCompany(String company){
      this.company = company;
    }
    public void setUsername(String username){
      this.username = username;
    }
    public void setPassword(String password){
      this.password = password;
    }
    public void setFirstName(String firstName){
      this.firstName = firstName;
    }
    public void setLastName(String lastName){
      this.lastName = lastName;
    }
    public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
    }
    public ArrayList<Job> getListings() {
      return listings;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getCompany() {
        return company;
    }
    public String getFirstName() {
        return firstName;
    }
    public UUID getEmployerID() {
        return employerID;
    }
    public Job createJob(String jobCreatingParameters){
        Job listing = new Job();
        return listing;
    }
    public void postJob(Job job){

    }
    public ArrayList<Application> seeApplications(Job job){
        return job.getApplicants();
    }
    public void hideJob(Job job){

    }
    public Ratings getRatings(Student student){
        return student.getRatings();
    }
    public void rateStudent(Student student){

    }
}

