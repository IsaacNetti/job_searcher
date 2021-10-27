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

  public static ArrayList<Student> loadStudents() {
    ArrayList<Student> students = new ArrayList<>();
    
    try {
      FileReader reader = new FileReader(STUDENTS_FILE);
      JSONParser parser = new JSONParser();
      JSONArray studentsJSON = (JSONArray)parser.parse(reader);
      for (int i = 0; i < studentsJSON.size(); i++) {
        JSONObject studentJSON = (JSONObject)studentsJSON.get(i);
        String id = (String)studentJSON.get(STUDENTS_ID);
        UUID uid = UUID.fromString(id);
        String username = (String)studentJSON.get(EMPLOYERS_USERNAME);
        String password = (String)studentJSON.get(EMPLOYERS_PASSWORD);
        String firstName = (String)studentJSON.get(STUDENTS_FIRSTNAME);
        String lastName = (String)studentJSON.get(STUDENTS_LASTNAME);
        String gpa = (String)studentJSON.get(STUDENTS_GPA);
        String eduAccount = (String)studentJSON.get(STUDENTS_EDU_ACCOUNT);
        String favorites = (String)studentJSON.get(STUDENTS_FAVORITES);
        String ratings = (String)studentJSON.get(STUDENTS_RATINGS);
        String phoneNumber = (String)studentJSON.get(STUDENTS_PHONE_NUMBER);
        String education = (String)studentJSON.get(STUDENTS_EDUCATION);
        String achievements = (String)studentJSON.get(STUDENTS_ACHIEVEMENTS);
        String skills = (String)studentJSON.get(STUDENTS_SKILLS);

        ArrayList<Experience> experiences = new ArrayList<>();
        JSONArray experiencesJSON = (JSONArray)studentJSON.get(STUDENTS_EXPERIENCE);
        for (int j = 0; j < experiencesJSON.size(); j++) {
          JSONObject experienceJSON = (JSONObject)experiencesJSON.get(i);
          String title = (String)experienceJSON.get(EXPERIENCES_TITLE);
          String company = (String)experienceJSON.get(EXPERIENCES_COMPANY);
          String startDate = (String)experienceJSON.get(EXPERIENCES_START);
          String endDate = (String)experienceJSON.get(EXPERIENCES_END);
          String description = (String)experienceJSON.get(EXPERIENCES_DESCRIPTION);
          experiences.add(new Experience(title, company, startDate, endDate, description));
        } 

        students.add(new Student());
        students.get(students.size() - 1).setStudentID(uid);
        students.get(students.size() - 1).setUsername(username);
        students.get(students.size() - 1).setPassword(password);
        students.get(students.size() - 1).setFirstName(firstName);
        students.get(students.size() - 1).setLastName(lastName);
        students.get(students.size() - 1).setGpa(gpa);
        students.get(students.size() - 1).setEduAccount(eduAccount);
        students.get(students.size() - 1).setPhoneNumber(phoneNumber);
        
      }
      return students;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return students;
  }

  public static ArrayList<Job> loadJobs() {
    ArrayList<Job> jobs = new ArrayList<>();
    
    try {
      FileReader reader = new FileReader(JOBS_FILE);
      JSONParser parser = new JSONParser();
      JSONArray jobsJSON = (JSONArray)parser.parse(reader);
      for(int i = 0; i < jobsJSON.size(); i++){
        JSONObject jobJSON = (JSONObject)jobsJSON.get(i);
        String id = (String)jobJSON.get(JOBS_ID);
        UUID uid = UUID.fromString(id);
        String name = (String)jobJSON.get(JOBS_NAME);
        String companyID = (String)jobJSON.get(JOBS_COMPANY_ID);
        UUID uidCompany = UUID.fromString(companyID);
        String employerID = (String)jobJSON.get(JOBS_EMPLOYER_ID);
        UUID uidEmployer = UUID.fromString(employerID);
        String startDate = (String)jobJSON.get(JOBS_START_DATE);
        String endDate = (String)jobJSON.get(JOBS_END_DATE);
        double salary = (double)jobJSON.get(JOBS_SALARY);
        String description = (String)jobJSON.get(JOBS_DESCRIPTION);
        String location = (String)jobJSON.get(JOBS_LOCATION);
        boolean isRemote = (boolean)jobJSON.get(JOBS_REMOTE);

        jobs.add(new Job());
        jobs.get(jobs.size() - 1).setJobID(uid);
        jobs.get(jobs.size() - 1).setName(name);
        jobs.get(jobs.size() - 1).setStartDate(startDate);
        jobs.get(jobs.size() - 1).setEndDate(endDate);
        jobs.get(jobs.size() - 1).setSalary(salary); 
        jobs.get(jobs.size() - 1).setCompany(uidCompany);
        jobs.get(jobs.size() - 1).setDescription(description); 
        jobs.get(jobs.size() - 1).setLocation(location);
        jobs.get(jobs.size() - 1).setRemote(isRemote);
      }
      return jobs;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return jobs;
  }

  public static ArrayList<Application> loadApplications() {
    ArrayList<Application> applications = new ArrayList<>();
    
    try {
      FileReader reader = new FileReader(JOBS_FILE);
      JSONParser parser = new JSONParser();
      JSONArray applicationsJSON = (JSONArray)parser.parse(reader);
      for(int i = 0; i < applicationsJSON.size(); i++){
        JSONObject applicationJSON = (JSONObject)applicationsJSON.get(i);
        String id = (String)applicationJSON.get(JOBS_ID);
        UUID uid = UUID.fromString(id);
        String jobID = (String)applicationJSON.get(JOBS_COMPANY_ID);
        UUID uidJob = UUID.fromString(jobID);
        String studentID = (String)applicationJSON.get(JOBS_EMPLOYER_ID);
        UUID uidStudent = UUID.fromString(studentID);
      }
      return applications;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return applications;
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
