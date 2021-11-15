package JobSearcher;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompanySearchTest {
  Companies companies = Companies.getInstance();
  CompanySearch search = new CompanySearch();
  Company c = new Company();
  
  Company c2 = new Company();
  
  @BeforeEach
  public void setup() {
    c.setName("n1");
    c.setLocation("l1");
    c.setIndustry("i1");
    c.setSector("s1");
    c2.setName("n2");
    c2.setLocation("l2");
    c2.setIndustry("i2");
    c2.setSector("s2");
    companies.addCompany(c);
    companies.addCompany(c2);
  }

  @AfterEach
  public void tearDown() {
    companies.deleteCompany(c);
    companies.deleteCompany(c2);
  }

  @Test
  public void testSearchByKeyword() {
    search.runSearch("keyword", "n1");
    ArrayList<Company> r = search.displayResults();
    assertEquals("n1", r.get(0).getName());
  }

  @Test
  public void testSearchByLocation() {
    search.runSearch("location", "l1");
    ArrayList<Company> r = search.displayResults();
    assertEquals("l1", r.get(0).getLocation());
  }
  @Test
  public void testSearchByIndustry() {
    search.runSearch("industry", "i2");
    ArrayList<Company> r = search.displayResults();
    assertEquals("i2", r.get(0).getIndustry());
  }
  @Test
  public void testSearchBySector() {
    search.runSearch("sector", "s2");
    ArrayList<Company> r = search.displayResults();
    assertEquals("s2", r.get(0).getSector());
  }
}
