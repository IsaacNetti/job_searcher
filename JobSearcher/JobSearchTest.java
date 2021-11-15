package JobSearcher;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JobSearchTest {
  Jobs jobs = Jobs.getInstance();
  JobSearch search = new JobSearch();
  Job j = new Job();
  Job j2 = new Job();
  Company c = new Company();
  Companies companies = Companies.getInstance();

  @BeforeEach
  public void setup() {
    UUID id = UUID.randomUUID();
    c.setCompanyID(id);
    c.setName("cn");
    c.setIndustry("ci");
    c.setLocation("cl");
    c.setSector("cs");
    companies.addCompany(c);
    j.setName("n1");
    j.setLocation("l1");
    j.setDescription("d1");
    j.setCompany(id);
    j2.setName("n2");
    j2.setLocation("l2");
    j2.setDescription("d2");
    j2.setCompany(id); 
    jobs.addJob(j);
    jobs.addJob(j2);
  }

  @AfterEach
  public void tearDown() {
    jobs.deleteJob(j);
    jobs.deleteJob(j2);
  }

  @Test
  public void testSearchByName() {
    search.search("name", "n1");
    ArrayList<Job> r = search.displayResults();
    assertEquals("n1", r.get(0).getName());
  }

  @Test
  public void testSearchByLocation() {
    search.search("location", "cl");
    ArrayList<Job> r = search.displayResults();
    assertEquals("cl", r.get(0).getCompany().getLocation());
  }

  @Test
  public void testSearchByKeyword() {
    search.search("keyword", "d2");
    ArrayList<Job> r = search.displayResults();
    assertEquals("d2", r.get(0).getDescription());
  }
}