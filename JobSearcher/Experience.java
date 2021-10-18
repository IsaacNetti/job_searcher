package JobSearcher;

public class Experience {
    private String title;
    private String Company;
    private String startDate;
    private String endDate;
    private String jobDescription;
    
    public Experience(){

    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCompany(String company) {
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
    public String getCompany() {
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
