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

    } catch (Exception e) {

    }
  }
}
