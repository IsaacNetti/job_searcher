package JobSearcher;
import java.util.ArrayList;

public class Jobs {
    private static Jobs jobs;
    private ArrayList<Job> jobList;

    public Jobs(){

    }
    public static void getInstance(){

    }
    public boolean haveJob(String jobName){
        return true;
    }
    public Job getJob(String jobName){
        Job result = new Job();
        return result;
    }
}
