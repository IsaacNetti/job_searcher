package JobSearcher;

import java.util.UUID;

public class Company {

    private UUID companyID;
    private String name;
    private String location;
    private String industry;
    private String sector;

    public Company(){

    }
    public void setCompanyID(UUID companyID) {
      this.companyID = companyID;
    }
    public void setName(String name) {
      this.name = name;
    }
    public void setLocation(String location) {
      this.location = location;
    }
    public void setIndustry(String industry) {
      this.industry = industry;
    }
    public void setSector(String sector) {
      this.sector = sector;
    }
    public UUID getCompanyID(){
        return companyID;

    }
    public String getName(){
        return name;
    }
    public String getLocation(){
        return location;
    }
    public String getIndustry(){
        return industry;
    }
    public String getSector(){
        return sector;
    }
    public void addEmployer(Employer employer){

    }
    public void addJob(Job job){
        
    }    
}
