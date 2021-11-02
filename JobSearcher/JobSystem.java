package JobSearcher;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
/**
 * The facade of the system
 * @author The Back Rowers
 */
public class JobSystem {
    /**
     * The job system constructor
     */
    public JobSystem(){
        Companies.getInstance();
        Users.getInstance();
        Jobs.getInstance();
        DatabaseLoader.loadApplications();
    }
    /**
     * The login system for students
     * @param username The username of the student
     * @param password The password of the student
     * @return Returns the user as a student
     */
    public Student studentLogin(String username, String password){
        Student user = new Student();
        if(Users.getInstance().haveStudent(username)){
            ArrayList<Student> students = Users.getInstance().getStudents();
            for (Student student : students) {
                if(student.getUsername().equalsIgnoreCase(username)){
                    user = student;
                }
            }
            if(user.getPassword().equals(password)){
                return user;
            }
        }
        
        return null;
    }
    /**
     * The login system for employers
     * @param username The username of the employer
     * @param password The password of the employer
     * @return Returns the user as an employer
     */
    public Employer employerLogin(String username, String password){
        Employer user = new Employer();
        if(Users.getInstance().haveEmployer(username)){
            ArrayList<Employer> employers = Users.getInstance().getEmployers();
            for (Employer employer : employers) {
                if(employer.username.equalsIgnoreCase(username)){
                    user = employer;
                }
            }
            if(user.getPassword().equals(password)){
                return user;
            }
        }
      
        return null;
    }
    /**
     * The login system for an admin
     * @param username The username of an admin
     * @param password The password of an admin
     * @return Returns the user as an admin
     */
    public Job getJob(String jobTitle, String companyName) {
      for (Job j : Jobs.getInstance().getJobs()) {
        if (j.getName().equalsIgnoreCase(jobTitle) && j.getCompany().getName().equalsIgnoreCase(companyName)) {
          return j;
        }
      }
      return null;
    }
    /**
     * Checks if the company exists
     * @param companyName The name of the company that is being checked
     * @return Returns company if found
     */
    public Company companyExists(String companyName) {
        if (Companies.getInstance().haveCompany(companyName)) {
          ArrayList<Company> companies = Companies.getInstance().getCompanies();
          for (Company c : companies) {
            if (c.getName().equalsIgnoreCase(companyName)) {
              return c;
            }
          }
        }
        return null;
    }
    /**
     * Checks if the admin exists
     * @param adminID The UUID of the admin
     * @return Returns admin if found
     */
    public Admin adminExists(UUID adminID) {
      ArrayList<Admin> admins = Users.getInstance().getAdmins();
      for (Admin a : admins) {
        if (a.getID() == adminID) {
          return a;
        }
      }
      return null;
    }
    /**
     * Checks if the employer exists
     * @param employerID The UUID of the employer
     * @return Returns employer if found
     */
    public Employer employerExists(UUID employerID) {
      ArrayList<Employer> employers = Users.getInstance().getEmployers();
      for (Employer c : employers) {
        if (c.getEmployerID() == employerID) {
          return c;
        }
      }
      return null;
    }
    /**
     * Checks if the student exists
     * @param studentID The UUID of the student
     * @return Returns student if found
     */
    public Student studentExists(UUID studentID) {
      ArrayList<Student> students = Users.getInstance().getStudents();
      for (Student s : students) {
        if (s.getStudentId() == studentID) {
          return s;
        }
      }
      return null;
    }
    /**
     * Admin login
     * @param username The username of the admin
     * @param password The password of the admin
     * @return Returns admin
     */
    public Admin adminLogin(String username, String password){
        Admin user = new Admin();
        if(Users.getInstance().haveAdmin(username)){
            ArrayList<Admin> admins = Users.getInstance().getAdmins();
            for (Admin admin : admins) {
                if(admin.username.equalsIgnoreCase(username)){
                    user = admin;
                }
            }
            if(user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
    /**
     * Creates a student user
     * @param username The username of the student
     * @param password The password of the student
     * @param firstName The first name of the student
     * @param lastName Thelast name of the student
     * @param gpa The GPA of the student
     * @param eduAccount The eduAccount of the student
     * @param phoneNumber The phone number of the student
     */
    public void createStudent(String username, String password, String firstName, String lastName,String gpa,String eduAccount, String phoneNumber){
        Student student = new Student();
        UUID studentid = UUID.randomUUID();
        ArrayList<Application> applications = new ArrayList<Application>();
        Ratings studentRatings = new Ratings();
        student.setUsername(username);
        student.setPassword(password);
        student.setStudentID(studentid);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setGpa(gpa);
        student.setEduAccount(eduAccount);
        student.setPhoneNumber(phoneNumber);
        student.setRatings(studentRatings);
        student.setApplications(applications);
        student.setType();
        Users.getInstance().createStudent(student);
    }
    /**
     * Creates a resume
     * @param student The student that is creating the resume
     * @param skills The skills of the student
     * @param education The education of the student
     * @param achievements The achievements of the student
     */
    public void createResume(Student student, String skills, String education, String achievements){
        ArrayList<Experience> workExperience = new ArrayList<Experience>();
        Resume studentResume = new Resume();
        studentResume.setSkills(skills);
        studentResume.setEducation(education);
        studentResume.setAchievements(achievements);
        studentResume.setWorkExperience(workExperience);
        student.setResume(studentResume);
        DatabaseWriter.saveStudents();
    }
    /**
     * Adds experiences to resume
     * @param resume The resume that it is being added to
     * @param title The title of the experience
     * @param company The company of the experience
     * @param startDate The start date of the experience
     * @param endDate The end date of the experience
     * @param jobDescription The description of the experience
     */
    public void addExperience(Resume resume, String title, String company, String startDate, String endDate, String jobDescription){
        Experience experience = new Experience();
        experience.setTitle(title);
        experience.setCompany(company);
        experience.setStartDate(startDate);
        experience.setEndDate(endDate);
        experience.setJobDescription(jobDescription);
        resume.addWorkExperience(experience);
        DatabaseWriter.saveStudents();
    }
    /**
     * Saves the resume
     * @param student The student whose resume is being saved
     * @param fileName The name of the resume being saved
     */
    public void saveResume(Student student, String fileName){
      try {
        FileWriter writer = new FileWriter(fileName+ ".txt");
        writer.write(student.resumeWriter());;
        writer.close();
      } catch (IOException e) {
        
        e.printStackTrace();
      }
    }
    /**
     * Adds a rating to a student
     * @param student The student that is being rated
     * @param rating The rating of the student
     */
    public void addRating(Student student,int rating){
        student.addRating(rating);
        DatabaseWriter.saveStudents();
    }
    /**
     * Student applies to a job
     * @param student The student that is applying
     * @param job The job that the student is applying to
     */
    public void apply(Student student, Job job){
        student.apply(job);
    }
    /**
     * Displays the jobs
     * @param jobList The list of jobs
     */
    public void displayAllJobs() {
      displayJobs(Jobs.getInstance().getJobs());
    }
    /**
     * Dislays all the jobs
     * @param jobList The list of jobs posted
     */
    public void displayJobs(ArrayList<Job> jobList){
        for (Job job : jobList) {
            System.out.println(job);
        }
    }
    /**
     * Searches for jobs 
     * @param choice The category that the student wants to search in
     * @param keyword The phrase that the student wants to search
     */
    public void jobFilters() {
      JobSearch search = new JobSearch();
      int num = 1;
      for (String s : search.displayFilters()) {
        System.out.println(num + ". " + s);
        num++;
      }
    }
    /**
     * Displays the search filters
     */
    public void companyFilters() {
      CompanySearch search = new CompanySearch();
      for (String s : search.displayFilters()) {
        System.out.println(s);
      }
    }
    /**
     * Searches for jobs 
     * @param choice The category the user wants to search in
     * @param keyword The user's desired phrase
     */
    public void searchJobs(int choice, String keyword){
        String decision = "";
        switch(choice){
            case(1):
                decision = "name";
                break;
            case(2):
                decision = "location";
                break;
            case(3):
                decision = "remote";
                break;
            case(4):
                decision = "company";
                break;
            case(5):
                decision = "keyword";
                break;
        }
        JobSearch search = new JobSearch();
        search.search(decision, keyword);
        displayJobs(search.displayResults());

    }
    /**
     * Searches for company 
     * @param choice The category that the student wants to search in
     * @param keyword The phrase that the student wants to search
     */
    public void searchCompany(int choice,String keyword){
        String decision = "";
        switch(choice){
            case(1):
                decision = "location";
            case(2):
                decision = "sector";
            case(3):
                decision = "industry";
            case(4):
                decision = "keyword";
        }
        CompanySearch search = new CompanySearch();
        search.runSearch(decision, keyword);
        for (Company c : search.displayResults()) {
            System.out.println(c);
        }
    }
    /**
     * Creates an employer
     * @param username The username of the employer
     * @param password The password of the employer
     * @param firstName The first name of the employer
     * @param lastName The last name of the employer
     * @param phoneNumber The phone number of the employer
     */
    public void createEmployer(String username, String password, String firstName,String lastName, String phoneNumber){
        Employer employer = new Employer();
        UUID employerID = UUID.randomUUID();
        ArrayList<Job> listings = new ArrayList<Job>();
        employer.setUsername(username);
        employer.setPassword(password);
        employer.setEmployerID(employerID);
        employer.setFirstName(firstName);
        employer.setLastName(lastName);
        employer.setPhoneNumber(phoneNumber);
        employer.setListings(listings);
        employer.setType();
        Users.getInstance().createEmployer(employer);
    }
    /**
     * Adds a company to the employer
     * @param company The company that the employer works for
     * @param employer The employer that works for the company
     */
    public void addCompany(Company company, Employer employer){
        employer.setCompany(company.getCompanyID());
        DatabaseWriter.saveEmployers();
    }
    /**
     * Creates a job
     * @param name The name of the job
     * @param startDate The start date of the job
     * @param endDate The end date of the job
     * @param salary The salary of the job
     * @param description The description of the job
     * @param location The location of the job
     * @param isRemote Whether the job is remote
     * @param company The company of the job
     * @param employer The employer of the job
     */
    public void createJob(String name, String startDate, String endDate, Double salary,String description,String location,boolean isRemote, Company company,Employer employer){
        Job job = Jobs.getInstance().createJob(name, startDate, endDate, salary, description, location, isRemote, company, employer);
        Jobs.getInstance().addJob(job);
    }
    /**
     * Removes the job 
     * @param job The job that is being deleted
     */
    public void removeJob(Job job){
        Jobs.getInstance().deleteJob(job);
    }
    /**
     * The employer rejecting an applicant
     * @param application The application that is being rejected
     * @param job The job that is being rejected
     */
    public void rejectApplicant(Application application, Job job){
        job.removeApplication(application);
        DatabaseWriter.saveJobs();
    }
    /**
     * Displays the applicants
     * @param studentList The list of students that applied
     */
    public void displayApplicants(ArrayList<Student> studentList){
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
    /**
     * Creates an admin user
     * @param user The user that is becoming an admin
     * @param username The username of the user that is becoming an admin
     * @param password The password of the user that is becoming an admin
     */
    public void createAdmin(String username, String password){
        Admin admin = new Admin();
        UUID adminID = UUID.randomUUID();
        admin.setUsername(username);
        admin.setPassword(password);
        admin.setID(adminID);
        Users.getInstance().createAdmin(admin);
    }
    /**
     * Deletes a student user
     * @param student The student that is being deleted
     */
    public void deleteStudent(Student student){
        Users.getInstance().deleteStudent(student);
    }
    /**
     * Deletes an employer user
     * @param employer The employer that is being deleted
     */
    public void deleteEmployer(Employer employer){
        Users.getInstance().deleteEmployer(employer);
    }
    /**
     * Deletes an admin
     * @param admin The user that is being deleted
     */
    public void deleteAdmin(Admin admin){
      Users.getInstance().deleteAdmin(admin);
  }
  /**
   * Deletes a company
   * @param company The company that is being deleted
   */
    public void deleteCompany(Company company){
        Companies.getInstance().deleteCompany(company);
  }
  /**
   * Creates a company
   * @param name The name of the company
   * @param location The location of the company
   * @param industry The industry of the company
   * @param sector The sector of the company
   */
    public void createCompany(String name, String location, String industry, String sector){
        Company company = new Company();
        UUID companyID = UUID.randomUUID();
        company.setCompanyID(companyID);
        company.setName(name);
        company.setLocation(location);
        company.setIndustry(industry);
        company.setSector(sector);
        Companies.getInstance().addCompany(company);
    }
}
