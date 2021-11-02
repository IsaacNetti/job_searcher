package JobSearcher;
/**
 * The experience class
 * @author The Back Rowers
 */
public class Experience {
    private String title;
    private String company;
    private String startDate;
    private String endDate;
    private String jobDescription;
    /**
     * The constructor of experience
     */
    public Experience(){
        
    }
    /**
     * Sets the title of the experience
     * @param title The title of the experience
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Sets the company of the experience
     * @param company The company of the experience
     */
    public void setCompany(String company) {
        this.company = company;
    }
    /**
     * Sets the end date of the experience
     * @param endDate The end date of the experience
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    /**
     * Sets the start date of the experience
     * @param startDate The start date of the experience
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    /**
     * Sets the description of the experience
     * @param jobDescription The description of the experience
     */
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
    /**
     * Gets the company of the experience
     * @return Returns the company
     */
    public String getCompany() {
        return company;
    }
    /**
     * Gets the end date of the experience
     * @return Returns the end date
     */
    public String getEndDate() {
        return endDate;
    }
    /**
     * Gets the description of the experience
     * @return Returns the description
     */
    public String getJobDescription() {
        return jobDescription;
    }
    /**
     * Gets the start date of the experience
     * @return Returns the start date
     */
    public String getStartDate() {
        return startDate;
    }
    /**
     * Gets the title of the experience
     * @return Returns the title
     */
    public String getTitle() {
        return title;
    }
}
