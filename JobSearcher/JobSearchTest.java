package JobSearcher;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JobSearchTest {
  Jobs jobs = Jobs.getInstance();
  JobSearch search = new JobSearch();
  Job j = new Job();
  Job j2 = new Job();

  @BeforeEach
  public void setup() {
    j.setName("n1");
    j.setLocation("l1");
    j.setDescription("d1");
    j2.setName("n2");
    j2.setLocation("l2");
    j2.setDescription("d2"); 
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
    search.search("location", "l1");
    ArrayList<Job> r = search.displayResults();
    assertEquals("l1", r.get(0).getLocation());
  }

  @Test
  public void testSearchByKeyword() {
    search.search("keyword", "d2");
    ArrayList<Job> r = search.displayResults();
    assertEquals("d2", r.get(0).getDescription());
  }
}