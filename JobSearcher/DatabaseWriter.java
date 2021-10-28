package JobSearcher;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class DatabaseWriter extends DatabaseConstants{
    

    public static void saveCompanies(){
        Companies companies = Companies.getInstance();
        ArrayList<Company> employers = companies.getCompanies();
        JSONArray jsonEmployers = new JSONArray();

        for(int i = 0; i<employers.size(); i++){
            jsonEmployers.add(getCompanyJSON(employers.get(i)));
        }

        try(FileWriter file = new FileWriter(COMPANIES_FILE)){
            file.write(jsonEmployers.toJSONString());
            file.flush();
            
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static JSONObject getCompanyJSON(Company company){
            JSONObject companiesDetails = new JSONObject();
            companiesDetails.put(COMPANIES_ID, company.getCompanyID());
            companiesDetails.put(COMPANIES_NAME, company.getName());
            companiesDetails.put(COMPANIES_LOCATION, company.getLocation());
            companiesDetails.put(COMPANIES_SECTOR, company.getSector());
            companiesDetails.put(COMPANIES_INDUSTRY, company.getIndustry());

        return companiesDetails;
    }
}
