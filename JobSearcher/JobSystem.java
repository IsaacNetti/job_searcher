package JobSearcher;

import java.util.ArrayList;
import java.util.UUID;

public class JobSystem {
    
    public JobSystem(){

    }
    public Student studentLogin(String username, String password){
        Student user = new Student();
        if(Users.getInstance().haveStudent(username)){
            ArrayList<Student> students = Users.getInstance().getStudents();
            for (Student student : students) {
                if(student.username.equalsIgnoreCase(username)){
                    user = student;
                }
            }
            if(user.getPassword().equals(password)){
                return user;
            }
        }
        System.out.println("Incorrect login");
        return null;
    }
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
        System.out.println("Incorrect login");
        return null;
    }
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
        System.out.println("Incorrect login");
        return null;
    }
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
    public void apply(Student student, Job job){
        student.apply(job);
    }
    public void displayJobs(ArrayList<Job> jobList){
        for (Job job: jobList) {
            System.out.println(job);
        }
    }
    public void searchJobs(int choice, String keyword){
        String decision = "";
        switch(choice){
            case(1):
                decision = "name";
            case(2):
                decision = "location";
            case(3):
                decision = "remote";
            case(4):
                decision = "company";
            case(5):
                decision = "keyword";
        }
        JobSearch search = new JobSearch();
        search.search(decision, keyword);
        search.displayResults();

    }
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
        search.displayResults();
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
        employer.setType();
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
    public void createAdmin(User user,String username, String password){
        Admin admin = new Admin();
        UUID adminID = UUID.randomUUID();
        admin.setUsername(user, username);
        admin.setPassword(user, password);
        admin.addAdmin(user);
        admin.setID(adminID);
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
