package JobSearcher;
import java.util.ArrayList;
import java.util.UUID;

public class Job {
    private UUID jobID;  
    private String name;
    private String startDate;
    private String endDate;
    private Double salary;
    private String description;
    private String location;
    private boolean isRemote;
    private ArrayList<Application> applicants;
    private Company company;
    private Employer employer;

    public Job(){

    }
    public void setJobID(UUID jobID) {
        this.jobID = jobID;
    }
    public void setName(String name) {
      this.name = name;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setRemote(boolean isRemote) {
        this.isRemote = isRemote;
    }
    public void setCompany(UUID companyID) {
        Companies list = Companies.getInstance();
        this.company = list.getCompany(companyID);
    }
    public void setEmployer(UUID employerID) {
        Employers list = Employers.getInstance();
        this.employer = list.getCompany(employerID);
    }

    public void addApplicant(Student student){

    }
    public void declineApplicant(Student student){

    }

    public String getStartDate() {
        return startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public Double getSalary() {
        return salary;
    }
    public String getDescription() {
        return description;
    }
    public Company getCompany() {
        return company;
    }
    public Employer getEmployer() {
        return employer;
    }
    public String getLocation() {
        return location;
    }
    public String getName() {
        return name;
    }
    public boolean getRemote(){
        return isRemote;
    }
    public ArrayList<Application> getApplicants(){
        return this.applicants;
    }
    public UUID getJobID() {
        return jobID;
    }
}
