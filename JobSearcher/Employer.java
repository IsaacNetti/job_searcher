package JobSearcher;
import java.util.ArrayList;
import java.util.UUID;

public class Employer {
    private String name;
    private ArrayList<Job> listings;
    private UUID employerID;
    private String company;
    private String phoneNumber;

    public Employer(){

    }
    public void setEmployerID(UUID employerID) {
        this.employerID = UUID.randomUUID();
    }
    public void setCompany(String company){

    }
    public void setName(String name){

    }
    public void setUsername(String username){

    }
    public void setPassword(String password){

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

    public ArrayList<Job> getListings() {
        return listings;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getCompany() {
        return company;
    }
    public String getName() {
        return name;
    }
    public UUID getEmployerID() {
        return employerID;
    }

}

