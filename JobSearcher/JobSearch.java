package JobSearcher;

import java.util.ArrayList;
/**
 * The class to search for jobs
 * @author The Back Rowers
 */
public class JobSearch {
    private String[] filters;
    private ArrayList<Job> results;
    /**
     * The job search constructor
     */
    public JobSearch() {
        filters = new String[] { "name", "location", "remote", "company", "keyword" };
    }
    /**
     * Searches the database of jobs that matches the user's input
     * @param choice The category that the user wants to search in
     * @param keyword The phrase that the user is searching for
     */
    public void search(String choice, String keyword) {
        results = new ArrayList<Job>();
        Jobs list = Jobs.getInstance();
        if (choice.equalsIgnoreCase("keyword")) {
            for (Job c : list.getJobs()) {
                if (c.getName().contains(keyword)) {
                    results.add(c);
                } else if (c.getCompany().getName().contains(keyword)) {
                    results.add(c);
                } else if (c.getCompany().getSector().contains(keyword)) {
                    results.add(c);
                } else if (c.getDescription().contains(keyword)) {
                    results.add(c);
                } else if (c.getCompany().getIndustry().contains(keyword)) {
                    results.add(c);
                } else if (c.getLocation().contains(keyword)) {
                    results.add(c);
                }
            }
        } else if (choice.equalsIgnoreCase("name")) {
            for (Job c : list.getJobs()) {
                if (c.getName().contains(keyword)) {
                    results.add(c);
                    break;
                }
            }
        } else if (choice.equalsIgnoreCase("location")) {
            for (Job c : list.getJobs()) {
                if (c.getCompany().getLocation().contains(keyword)) {
                    results.add(c);
                    break;
                }
            }
        } else if (choice.equalsIgnoreCase("remote")) {
            for (Job c : list.getJobs()) {
                if (c.getCompany().getLocation().contains(keyword)) {
                    results.add(c);
                    break;
                }
            }
        } else if (choice.equalsIgnoreCase("company")) {
            for (Job c : list.getJobs()) {
                if (c.getCompany().getName().contains(keyword)) {
                    results.add(c);
                    break;
                }
            }
        }
    }
    /**
     * Displays the filters 
     * @return Returns the list of filters
     */
    public String[] displayFilters(){
        return filters;
    }
    /**
     * Displays the results
     * @return Returns the list of jobs
     */
    public ArrayList<Job> displayResults(){
        return results;
    }
}
