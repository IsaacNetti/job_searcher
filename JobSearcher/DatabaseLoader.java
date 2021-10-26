package JobSearcher;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.UUID;

public class DatabaseLoader extends DatabaseConstants {
  
  public static ArrayList<Employer> loadEmployers() {
    ArrayList<Employer> employers = new ArrayList<>();
    
    try {
      FileReader reader = new FileReader(EMPLOYERS_FILE);
      JSONParser parser = new JSONParser();
      JSONArray employersJSON = (JSONArray)parser.parse(reader);
      for(int i = 0; i < employersJSON.size(); i++){
        JSONObject employerJSON = (JSONObject)employersJSON.get(i);
        String id = (String)employerJSON.get(EMPLOYERS_ID);
        UUID uid = UUID.fromString(id);
        String companyID = (String)employerJSON.get(EMPLOYERS_COMPANY_ID);
        UUID uidCompany = UUID.fromString(companyID);
        String company = (String)employerJSON.get(EMPLOYERS_COMPANY);
        String username = (String)employerJSON.get(EMPLOYERS_USERNAME);
        String password = (String)employerJSON.get(EMPLOYERS_PASSWORD);
        String firstName = (String)employerJSON.get(EMPLOYERS_FIRSTNAME);
        String lastName = (String)employerJSON.get(EMPLOYERS_LASTNAME);
        String phoneNumber = (String)employerJSON.get(EMPLOYERS_PHONE_NUMBER);

        employers.add(new Employer());
        employers.get(employers.size() - 1).setEmployerID(uid);
        employers.get(employers.size() - 1).setCompanyID(uidCompany);
        employers.get(employers.size() - 1).setCompany(company);
        employers.get(employers.size() - 1).setUsername(username);
        employers.get(employers.size() - 1).setPassword(password);
        employers.get(employers.size() - 1).setFirstName(firstName);
        employers.get(employers.size() - 1).setLastName(lastName);
        employers.get(employers.size() - 1).setPhoneNumber(phoneNumber);
      }
      return employers;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return employers;
  }

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
