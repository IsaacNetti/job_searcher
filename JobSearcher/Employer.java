package JobSearcher;
import java.util.ArrayList;
import java.util.UUID;

public class Employer extends User{
    private UUID employerID;
    private UUID companyID;  
    private String username;
    private String password; 
    private Boolean isAdmin; 
    private String firstName;
    private String lastName;
    private ArrayList<Job> listings;
    private Company company;
    private String phoneNumber;

    public Employer(){

    }
    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    public void setListings(ArrayList<Job> listings) {
        this.listings = listings;
    }
    public void setEmployerID(UUID employerID) {
      this.employerID = employerID;
    }
    public void setCompanyID(UUID companyID) {
      this.companyID = companyID;
    }
    public void setCompany(Company company){
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
    public Boolean getIsAdmin() {
        return isAdmin;
    }
    public UUID getEmployerID() {
      return employerID;
    }
    public UUID getCompanyID() {
      return companyID;
    }
    public String getUsername() {
      return username;
    }
    public String getPassword() {
      return password;
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
    public ArrayList<Student> seeApplications(Job job){
        return job.getApplicants();
    }
    public Ratings getRatings(Student student){
        return student.getRatings();
    }
    public void rateStudent(Student student){

    }
}

