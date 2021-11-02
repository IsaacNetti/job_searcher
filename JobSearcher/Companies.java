package JobSearcher;

import java.util.ArrayList;
import java.util.UUID;
/**
 * The companies class
 * @author The Back Rowers
 */
public class Companies {
    private static Companies companies;
    private ArrayList<Company> companylist;
    /**
     * The company constructor
     */
    private Companies() {
      companylist = DatabaseLoader.loadCompanies();
    }
    /**
     * Creates instance of company
     * @return Returns companies
     */
    public static Companies getInstance() {
      if (companies == null) {
        companies = new Companies();
      }
      return companies;
    }
    /**
     * Gets the arraylist of companies
     * @return Returns arraylist of companies
     */
    public ArrayList<Company> getCompanies(){
      return companylist;
    }
    /**
     * Checks if the company is in the list of companies
     * @param companyName The company name that is being checked
     * @return Returns true if the company name is in the list, otherwise, it returns false
     */
    public boolean haveCompany(String companyName) {
        for (Company c : companylist) {
          if (c.getName().equalsIgnoreCase(companyName)) {
            return true;
          }
        }
        return false;
    }
    /**
     * Adds a company to the company list 
     * @param company The company that is being added
     */
    public void addCompany(Company company){
      companylist.add(company);
      DatabaseWriter.saveCompanies();
    }
    /**
     * Gets the company, if available
     * @param companyID The UUID of the company
     * @return Returns a company
     */
    public Company getCompany(UUID companyID) {
      for (Company c : companylist) {
        if (c.getCompanyID() == companyID) {
          return c;
        }
      }
      System.out.println("Company does not exist");
      return null;
    }
    /**
     * Deletes a company
     * @param company The company that is being removed
     */
    public void deleteCompany(Company company){
      companylist.remove(company);
      DatabaseWriter.saveCompanies();
    }
}
