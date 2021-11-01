package JobSearcher;
import java.util.ArrayList;
import java.util.UUID;

public class Employer extends User{
    private UUID employerID;
    private Boolean isAdmin; 
    private String firstName;
    private String lastName;
    private ArrayList<Job> listings;
    private Company company;
    private String phoneNumber;

    public Employer(){
        setType();  
        setIsAdmin();
    }
    public void setType() {
      super.typeOfUser = "Employer";
    }
    public void setIsAdmin() {
        this.isAdmin = false;
    }
    public void setListings(ArrayList<Job> listings) {
        this.listings = listings;
    }
    public void setEmployerID(UUID employerID) {
      this.employerID = employerID;
    }
    public void setCompany(UUID companyID){
      Companies list = Companies.getInstance();
      this.company = list.getCompany(companyID);
    }
    public void setUsername(String username){
      super.username = username;
    }
    public void setPassword(String password){
      super.password = password;
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
    public Boolean getIsAdmin() {
        return isAdmin;
    }
    public UUID getEmployerID() {
      return employerID;
    }
    public String getFirstName() {
      return firstName;
    }
    public String getLastName() {
      return lastName;
    }
    public ArrayList<Job> getListings() {
      return listings;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public Company getCompany() {
        return company;
    }
    public Job createJob(String name, String startDate, String endDate, Double salary,String description,String location,boolean isRemote, Company company,Employer employer){
       Job listing = Jobs.getInstance().createJob(name, startDate, endDate, salary, description, location, isRemote, company, employer);
      return listing;
    }
    public void postJob(Job job){
      Jobs.getInstance().addJob(job);
    }
    public ArrayList<Application> seeApplications(Job job){
        return job.getApplications();
    }
    public Ratings getRatings(Student student){
        return student.getRatings();
    }
    public void rateStudent(Student student){

    }
}

