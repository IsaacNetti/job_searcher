package JobSearcher;

import java.util.ArrayList;

public class CompanySearch {
    private String[] filters;
    private boolean[] filter;

    public CompanySearch(){
        filter = new boolean[]{location, sector, industry};
    }
    public String[] displayFilters(){
        return filters;
    }
    public boolean[] getFilters(){
        return getFilters();
    }
    public ArrayList<Company> displayResults(){
        ArrayList<Company> results = new ArrayList<Company>();
        return results;
    }
}
