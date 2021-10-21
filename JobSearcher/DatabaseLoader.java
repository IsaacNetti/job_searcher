package JobSearcher;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class DatabaseLoader extends DatabaseConstants {
  public static ArrayList<Company> loadCompanies() {
    ArrayList<Company> companies = new ArrayList<>();

    try {
      FileReader reader = new FileReader(COMPANIES_FILE);
      JSONParser parser = new JSONParser();
      JSONArray companiesJSON = (JSONArray)new JSONParser().parse(reader);

      for(int i = 0; i < companiesJSON.size(); i++){
        JSONObject companiesJSON = (JSONObject)companiesJSON.get(i);
        String id = (String)companiesJSON.get(COMPANIES_ID);
        String name = (String)companiesJSON.get(COMPANIES_NAME);
        String location = (String)companiesJSON.get(COMPANIES_LOCATION);
        String sector = (String)companiesJSON.get(COMPANIES_SECTOR);
        String industry = (String)companiesJSON.get(COMPANIES_INDUSTRY);

        companies.add(new Company(id, name, location, sector, industry));
      }
      return companies;
    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
  }
}
