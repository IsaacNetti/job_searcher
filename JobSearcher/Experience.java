package JobSearcher;

public class Experience {
    private String title;
    private String company;
    private String startDate;
    private String endDate;
    private String jobDescription;
    
    public Experience(String title, String company, String startDate, String endDate, String JobDescription){
        setTitle(title);
        setCompany(company);
        setStartDate(startDate);
        setEndDate(endDate);
        setJobDescription(jobDescription);
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
    public String getCompany() {
        return company;
    }
    public String getEndDate() {
        return endDate;
    }
    public String getJobDescription() {
        return jobDescription;
    }
    public String getStartDate() {
        return startDate;
    }
    public String getTitle() {
        return title;
    }
}
