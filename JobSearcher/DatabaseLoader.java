package JobSearcher;

import java.util.ArrayList;
import java.io.FileReader;
public class DatabaseLoader extends DatabaseConstants {
  public static ArrayList<Company> loadCompanies() {
    ArrayList<Company> companies = new ArrayList<>();

    try {
      FileReader reader = new FileReader(COMPANIES_FILE);
    } catch (Exception e) {

    }
  }
}
