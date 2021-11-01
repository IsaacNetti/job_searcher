package JobSearcher;

import java.util.ArrayList;

public class CompanySearch {
    private String[] filters;
    private ArrayList<Company> results;

    public CompanySearch() {
        filters = new String[]{"location", "sector", "industry", "keyword"};
    }
    public void runSearch(String choice, String phrase) {
        Companies list = Companies.getInstance();
        results = new ArrayList<>();  
        if (choice.equalsIgnoreCase("keyword")) {
          for (Company c : list.getCompanies()) {
            if (c.getName().contains(phrase)) {
              results.add(c);
              break;
            }
            if (c.getLocation().contains(phrase)) {
              results.add(c);
              break;
            }
            if (c.getSector().contains(phrase)) {
              results.add(c);
              break;
            }
            if (c.getIndustry().contains(phrase)) {
              results.add(c);
              break;
            }
          }
        } else if (choice.equalsIgnoreCase("location")) {
            for (Company c : list.getCompanies()) {  
              if (c.getLocation().contains(phrase)) {
                results.add(c);
              }
            }
        } else if (choice.equalsIgnoreCase("sector")) {
            for (Company c : list.getCompanies()) {  
              if (c.getSector().contains(phrase)) {
                results.add(c);
              }
            }
        } else if (choice.equalsIgnoreCase("industry")) {
            for (Company c : list.getCompanies()) {  
              if (c.getIndustry().contains(phrase)) {
                results.add(c);
              }
            }
        }
    }
    public String[] displayFilters(){
        return filters;
    }
    public ArrayList<Company> displayResults(){
        return results;
    }
}
