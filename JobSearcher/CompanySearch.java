package JobSearcher;

import java.util.ArrayList;
/**
 * The search class for companies
 * @author The Back Rowers
 */
public class CompanySearch {
    private String[] filters;
    private ArrayList<Company> results;
    /**
     * The company search constructor
     */
    public CompanySearch() {
        filters = new String[]{"location", "sector", "industry", "keyword"};
    }
    /**
     * Searches the list of companies based on keyword or different categories
     * @param choice The category that the user wants to search in
     * @param phrase The phrase that the user is searching for
     */
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
    /**
     * Displays the filters
     * @return Returns list of the filters
     */
    public String[] displayFilters(){
        return filters;
    }
    /**
     * Displays the results of the search
     * @return Returns list of the results
     */
    public ArrayList<Company> displayResults(){
        return results;
    }
}
