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
}
