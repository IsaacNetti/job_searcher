package JobSearcher;

import java.util.ArrayList;

public class JobSearch {
    private String[] filters;
    private ArrayList<Job> results;

    public JobSearch() {
        filters = new String[] { "name", "location", "remote", "company", "keyword" };
    }

    public void search(String choice, String keyword) {
        results = new ArrayList<Job>();
        Jobs list = Jobs.getInstance();
        if (choice.equalsIgnoreCase("keyword")) {
            for (Job c : list.getJobs()) {
                if (c.getCompany().getName().contains(keyword)) {
                    results.add(c);
                    break;
                }
                if (c.getCompany().getSector().contains(keyword)) {
                    results.add(c);
                    break;
                }
                if (c.getDescription().contains(keyword)) {
                    results.add(c);
                    break;
                }
                if (c.getCompany().getIndustry().contains(keyword)) {
                    results.add(c);
                    break;
                }
                if (c.getLocation().contains(keyword)) {
                    results.add(c);
                    break;
                }
            }
        } else if (choice.equalsIgnoreCase("name")) {
            for (Job c : list.getJobs()) {
                if (c.getCompany().getName().contains(keyword)) {
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
    public String[] displayFilters(){
        return filters;
    }
    public ArrayList<Job> displayResults(){
        return results;
    }
}
