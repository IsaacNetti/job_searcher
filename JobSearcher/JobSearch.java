package JobSearcher;
import java.util.ArrayList;

public class JobSearch {
    public String keyword;
    public JobSearch(String keyword){
        this.keyword = keyword;
    }

    public ArrayList<Job> search(){
        ArrayList<Job> results = new ArrayList<Job>();
        Jobs list = Jobs.getInstance();
        for(Job c : list.getJobs()){
            if(c.getCompany().getName().contains(keyword)){
                results.add(c);
                break;
            }
            if(c.getCompany().getSector().contains(keyword)){
                results.add(c);
                break;
            }
            if(c.getDescription().contains(keyword)){
                results.add(c);
                break;
            }
            if(c.getCompany().getIndustry().contains(keyword)){
                results.add(c);
                break;
            }
            if(c.getLocation().contains(keyword)){
                results.add(c);
                break;
            }
        }
        return results;

    }
}
