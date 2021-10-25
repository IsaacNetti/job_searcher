package JobSearcher;
import java.util.ArrayList;
import java.util.UUID;

public class Job {
    private String name;
    private String startDate;
    private String endDate;
    private Double salary;
    private String description;
    private String location;
    private UUID jobID;
    private boolean isRemote;
    private ArrayList<Application> applicants;
    private String company;

    public Job(){

    }
    public void setJobID() {
        this.jobID = UUID.randomUUID();;
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
    public void setCompany(String company) {
        this.company = company;
    }
    public void setName(String name) {
        this.name = name;
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
    public String getCompany() {
        return company;
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
