package JobSearcher;
import java.util.ArrayList;

public class Employer {
    private String name;
    private ArrayList<Job> listings;
    private String company;
    private String phoneNumber;

    public Employer(){

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

}

