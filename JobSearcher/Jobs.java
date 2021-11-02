package JobSearcher;
import java.util.ArrayList;
import java.util.UUID;
/**
 * The jobs application
 * @author The Back Rowers
 */
public class Jobs {
    private static Jobs jobs;
    private ArrayList<Job> jobList;
    /**
     * The jobs constructor
     */
    public Jobs(){
        jobList = DatabaseLoader.loadJobs();
    }
    /**
     * Gets an instance of jobs
     * @return Returns jobs
     */
    public static Jobs getInstance(){
        if (jobs == null) {
            jobs = new Jobs();
          }
          return jobs;
    }
    /**
     * Checks if a job is in the list of jobs
     * @param jobName The name of the job
     * @return Returns true or false
     */
    public boolean haveJob(String jobName){
        for (Job c : jobList) {
            if (c.getName().equals(jobName)) {
              return true;
            }
          }
          return false;
    }
    /**
     * Gets the job from the list of jobs
     * @param jobID The UUID of the job
     * @return Returns the job
     */
    public Job getJob(UUID jobID){
        for (Job c : jobList) {
            if (c.getJobID().compareTo(jobID) == 0) {
              return c;
            }
          }
          System.out.println("Job does not exist");
          return null;
    }
    /**
     * Gets the list of jobs
     * @return Returns the list of jobs
     */
    public ArrayList<Job> getJobs(){
      return jobList;
    }
    /**
     * Creates a job
     * @param name The name of the job
     * @param startDate The start date of the job
     * @param endDate The end date of the job
     * @param salary The salary of the job
     * @param description The description of the job
     * @param location The location of the job
     * @param isRemote Whether the job is remote
     * @param company The company of the job
     * @param employer The employer that posted the job
     * @return Returns job
     */
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
    /**
     * Adds a job to the list of jobs
     * @param job The job that is added
     */
    public void addJob(Job job){
      jobList.add(job);
      DatabaseWriter.saveJobs();
    }
    /**
     * Deletes a job on the list
     * @param job The job that is being deleted
     */
    public void deleteJob(Job job){
      jobList.remove(job);
      DatabaseWriter.saveJobs();
    }
}
