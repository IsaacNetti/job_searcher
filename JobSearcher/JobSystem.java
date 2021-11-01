package JobSearcher;

import java.util.ArrayList;
import java.util.UUID;

public class JobSystem {
    
    public JobSystem(){

    }
    public void studentLogin(String username, String password){

    }
    public void employerLogin(String username, String password){

    }
    public void adminLogin(String username, String password){

    }
    public void createStudent(String username, String password, String firstName, String lastName,String gpa,String eduAccount, String phoneNumber){
        Student student = new Student();
        UUID studentid = UUID.randomUUID();
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
        Users.getInstance().createStudent(student);
    }
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
    public void addExperience(Resume resume, String title, String company, String startDate, String endDate, String jobDescription){
        Experience experience = new Experience();
        experience.setTitle(title);
        experience.setCompany(company);
        experience.setStartDate(startDate);
        experience.setEndDate(endDate);
        experience.setJobDescription(jobDescription);
        resume.addWorkExperience(experience);
        resume.getUser().setResume(resume);
        DatabaseWriter.saveStudents();
    }
    public void addRating(Student student,int rating){
        student.addRating(rating);
        DatabaseWriter.saveStudents();

    }
    public void apply(Application application, Job job){
        job.addApplication(application);
    }
    public void displayJobs(ArrayList<Job> jobList){
        for (Job job: jobList) {
            System.out.println(job);
        }
    }
    public void searchJobs(String keyword){
        
    }
    public void searchCompany(String keyword){
        
    }
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
        Users.getInstance().createEmployer(employer);


    }
    public void addCompany(Company company, Employer employer){
        employer.setCompany(company.getCompanyID());
        DatabaseWriter.saveEmployers();
    }
    public void createJob(String name, String startDate, String endDate, Double salary,String description,String location,boolean isRemote, Company company,Employer employer){
        Job job = Jobs.getInstance().createJob(name, startDate, endDate, salary, description, location, isRemote, company, employer);
        Jobs.getInstance().addJob(job);
    }
    public void removeJob(Job job){
        Jobs.getInstance().deleteJob(job);
    }
    public void rejectApplicant(Application application, Job job){
        job.removeApplication(application);
        DatabaseWriter.saveJobs();
    }
    public void displayApplicants(ArrayList<Student> studentList){
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
    public void deleteStudent(Student student){
        Users.getInstance().deleteStudent(student);
    }
    public void deleteEmployer(Employer employer){
        Users.getInstance().deleteEmployer(employer);
    }
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
