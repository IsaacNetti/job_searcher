package JobSearcher;
import java.util.ArrayList;
import java.util.UUID;

public class Jobs {
    private static Jobs jobs;
    private ArrayList<Job> jobList;

    public Jobs(){
        jobList = DatabaseLoader.loadJobs();
        DatabaseLoader.loadApplications();
    }
    public static Jobs getInstance(){
        if (jobs == null) {
            jobs = new Jobs();
          }
          return jobs;
    }
    public boolean haveJob(String jobName){
        for (Job c : jobList) {
            if (c.getName() == jobName) {
              return true;
            }
          }
          return false;
    }
    public Job getJob(UUID jobID){
        for (Job c : jobList) {
            if (c.getJobID() == jobID) {
              return c;
            }
          }
          System.out.println("Job does not exist");
          return null;
    }
    public Job getJobs(){
      return jobs;
    }
    public Job createJob(String name, String startDate, String endDate, Double salary,String description,String location,boolean isRemote, Company company,Employer employer){
      Job job = new Job();
      job.setName(name);
      job.setStartDate(startDate);
      job.setEndDate(endDate);
      job.setSalary(salary);
      job.setDescription(description);
      job.setLocation(location);
      job.setRemote(isRemote);
      job.setCompany(company.getCompanyID());
      job.setEmployer(employer.getEmployerID());
      return job;
    }
    public void addJob(Job job){
      jobList.add(job);
      DatabaseWriter.saveJobs();
    }
    public void deleteJob(Job job){
      jobList.remove(job);
      DatabaseWriter.saveJobs();
    }
}
