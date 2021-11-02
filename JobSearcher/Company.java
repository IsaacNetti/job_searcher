package JobSearcher;

import java.util.UUID;
/**
 * The company class
 * @author The Back Rowers
 */
public class Company {

    private UUID companyID;
    private String name;
    private String location;
    private String industry;
    private String sector;
    /**
     * The company constructor
     */
    public Company(){

    }
    /**
     * Sets the UUID of the company
     * @param companyID The UUID of the company
     */
    public void setCompanyID(UUID companyID) {
      this.companyID = companyID;
    }
    /**
     * Sets the name of the company
     * @param name The name of the company
     */
    public void setName(String name) {
      this.name = name;
    }
    /**
     * Sets the location of the company
     * @param location The location of the company
     */
    public void setLocation(String location) {
      this.location = location;
    }
    /**
     * Sets the industry of the company
     * @param industry The industry of the company
     */
    public void setIndustry(String industry) {
      this.industry = industry;
    }
    /**
     * Sets the sector of the company
     * @param sector The sector of the company
     */
    public void setSector(String sector) {
      this.sector = sector;
    }
    /**
     * Gets the UUID of the company
     * @return Returns the UUID of the company
     */
    public UUID getCompanyID(){
        return companyID;
    }
    /**
     * Gets the name of the company
     * @return Returns the name of the company
     */
    public String getName(){
        return name;
    }
    /**
     * Gets the location of the company
     * @return Returns the location of the company
     */
    public String getLocation(){
        return location;
    }
    /**
     * Gets the industry of the company
     * @return Returns the industry of the company
     */
    public String getIndustry(){
        return industry;
    }
    /**
     * Gets the sector of the company
     * @return Returns the sector of the company
     */
    public String getSector(){
        return sector;
    }
    /**
     * Adds an employer to the company
     * @param employer The employer that is being added
     */
    public void addEmployer(Employer employer){
      employer.setCompany(companyID);
    }
    /**
     * Adds a job to the company
     * @param job The job that is part of the company
     */
    public void addJob(Job job){
        job.setCompany(companyID);
    }
    public String toString() {
      return "Name: " + getName() + "\nLocation: " + getLocation() + "\nIndustry: " + getIndustry() + "\nSector: " + getSector();
    }    
}
