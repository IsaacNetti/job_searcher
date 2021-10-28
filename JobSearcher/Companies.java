package JobSearcher;

import java.util.ArrayList;
import java.util.UUID;

public class Companies {
    private static Companies companies;
    private ArrayList<Company> companylist;

    private Companies() {
      companylist = DatabaseLoader.loadCompanies();
    }
    public static Companies getInstance() {
      if (companies == null) {
        companies = new Companies();
      }
      return companies;
    }
    public ArrayList<Company> getCompanies(){
      return companylist;
    }
    public boolean haveCompany(String companyName) {
        for (Company c : companylist) {
          if (c.getName().equalsIgnoreCase(companyName)) {
            return true;
          }
        }
        return false;
    }
    public Company getCompany(UUID companyID) {
      for (Company c : companylist) {
        if (c.getCompanyID() == companyID) {
          return c;
        }
      }
      System.out.println("Company does not exist");
      return null;
    }
}
