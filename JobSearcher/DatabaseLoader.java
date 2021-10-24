package JobSearcher;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.UUID;

public class DatabaseLoader extends DatabaseConstants {
  
  public static ArrayList<Company> loadCompanies() {
    ArrayList<Company> companies = new ArrayList<>();
    
    try {
      FileReader reader = new FileReader(COMPANIES_FILE);
      JSONParser parser = new JSONParser();
      JSONArray companiesJSON = (JSONArray)parser.parse(reader);
      for(int i = 0; i < companiesJSON.size(); i++){
        JSONObject companyJSON = (JSONObject)companiesJSON.get(i);
        String id = (String)companyJSON.get(COMPANIES_ID);
        UUID uid = UUID.fromString(id);
        String name = (String)companyJSON.get(COMPANIES_NAME);
        String location = (String)companyJSON.get(COMPANIES_LOCATION);
        String sector = (String)companyJSON.get(COMPANIES_SECTOR);
        String industry = (String)companyJSON.get(COMPANIES_INDUSTRY);

        companies.add(new Company());
        companies.get(companies.size() - 1).setCompanyID(uid);
        companies.get(companies.size() - 1).setName(name);
        companies.get(companies.size() - 1).setLocation(location);
        companies.get(companies.size() - 1).setSector(sector);
        companies.get(companies.size() - 1).setIndustry(industry);
      }
      return companies;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return companies;
  }
}
