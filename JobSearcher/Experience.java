package JobSearcher;

public class Experience {
    private String title;
    private Company Company;
    private String startDate;
    private String endDate;
    private String jobDescription;
    
    public Experience(String title, Company company, String startDate, String endDate, String JobDescription){
        setTitle(title);
        setCompany(company);
        setStartDate(startDate);
        setEndDate(endDate);
        setJobDescription(jobDescription);
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCompany(Company company) {
        Company = company;
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
    public Company getCompany() {
        return Company;
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
