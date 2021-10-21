package JobSearcher;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class DatabaseWriter extends DatabaseConstants{
    

    public static void saveCompanies(){
        Companies companies = Companies.getInstance();
        ArrayList<Company> employers = companies.getCompany();
        JSONARRAY jsonEmployers = new JSONArray();

        for(int i = 0; i<employers.size(); i++){
            jsonEmployers.add(getCompanyJSON(employers.get(i)));
        }

        try(FileWriter file = new FileWriter(PEOPLE_FILE_NAME)){
            file.write(jsonEmployers.toJSONString());
            file.flush();
            
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
