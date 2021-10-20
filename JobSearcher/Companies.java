package JobSearcher;

import java.util.ArrayList;

public class Companies {
    private Companies companies;
    private ArrayList<Company> Companylist;

    private Companies(){

    }
    public static void getInstance(){
    
    }
    public boolean haveComapny(String companyName){
        return true;
    }
    public Company getCompany(String companyName){
        Company result = new Company();
        return result;
    }
    
}
