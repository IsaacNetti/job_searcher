package JobSearcher;
/**
 * JSON database of constants
 * @author The Back Rowers
 */
public abstract class DatabaseConstants {
  protected static final String ADMINS_FILE = "JobSearcher/datastorage/admins.json";
  protected static final String ADMINS_ID = "id";
  protected static final String ADMINS_USERNAME = "username";
  protected static final String ADMINS_PASSWORD = "password";

  protected static final String EMPLOYERS_FILE = "JobSearcher/datastorage/employers.json";
  protected static final String EMPLOYERS_ID = "id";
  protected static final String EMPLOYERS_USERNAME = "username";
  protected static final String EMPLOYERS_PASSWORD = "password";
  protected static final String EMPLOYERS_FIRSTNAME = "firstName";
  protected static final String EMPLOYERS_LASTNAME = "lastName";
  protected static final String EMPLOYERS_COMPANY_ID = "companyid";
  protected static final String EMPLOYERS_COMPANY = "company";
  protected static final String EMPLOYERS_PHONE_NUMBER = "phoneNumber";

  protected static final String STUDENTS_FILE = "JobSearcher/datastorage/students.json";
  protected static final String STUDENTS_ID = "id";
  protected static final String STUDENTS_USERNAME = "username";
  protected static final String STUDENTS_PASSWORD = "password";
  protected static final String STUDENTS_FIRSTNAME = "firstName";
  protected static final String STUDENTS_LASTNAME = "lastName";
  protected static final String STUDENTS_GPA = "gpa";
  protected static final String STUDENTS_EDU_ACCOUNT = "eduAccount";
  protected static final String STUDENTS_PHONE_NUMBER = "phoneNumber";
  protected static final String STUDENTS_FAVORITES = "favorites";
  protected static final String STUDENTS_RATINGS = "ratings";
  protected static final String STUDENTS_EDUCATION = "education";
  protected static final String STUDENTS_ACHIEVEMENTS = "achievements";
  protected static final String STUDENTS_SKILLS = "skills";
  protected static final String STUDENTS_EXPERIENCE = "experience";

  protected static final String RATINGS = "rating";
  
  protected static final String FAVORITES_ID = "id";

  protected static final String EXPERIENCES_TITLE = "title";
  protected static final String EXPERIENCES_COMPANY = "company";
  protected static final String EXPERIENCES_START = "start";
  protected static final String EXPERIENCES_END  = "end";
  protected static final String EXPERIENCES_DESCRIPTION = "description";

  // protected static final String COMPANIES_FILE = "JobSearcher/datastorage/companies.json";
  protected static final String COMPANIES_FILE = "/Users/siddharth/Documents/CSCE 247 /job_searcher/JobSearcher/datastorage/companies.json";
  protected static final String COMPANIES_ID = "id";
  protected static final String COMPANIES_NAME = "name";
  protected static final String COMPANIES_LOCATION = "location";
  protected static final String COMPANIES_SECTOR = "sector";
  protected static final String COMPANIES_INDUSTRY = "industry";

  protected static final String JOBS_FILE = "JobSearcher/datastorage/jobs.json";
  protected static final String JOBS_ID = "id";
  protected static final String JOBS_NAME = "name";
  protected static final String JOBS_COMPANY_ID = "companyid";
  protected static final String JOBS_EMPLOYER_ID = "employerid";
  protected static final String JOBS_START_DATE = "start";
  protected static final String JOBS_END_DATE = "end";
  protected static final String JOBS_SALARY = "salary";
  protected static final String JOBS_DESCRIPTION = "description";
  protected static final String JOBS_LOCATION = "location";
  protected static final String JOBS_REMOTE = "remote";
  
  protected static final String APPLICATIONS_FILE = "JobSearcher/datastorage/applications.json";
  protected static final String APPLICATIONS_ID = "id";
  protected static final String APPLICATIONS_JOB_ID = "jobID";
  protected static final String APPLICATIONS_STUDENT_ID = "studentID";
}