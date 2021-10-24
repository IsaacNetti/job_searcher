package JobSearcher;

import java.util.ArrayList;

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
    public boolean haveCompany(String companyName) {
        for (Company c : companylist) {
          if (c.getName() == companyName) {
            return true;
          }
        }
        return false;
    }
    public Company getCompany(String companyName) {
        Company result = new Company();
        return result;
    }
}
