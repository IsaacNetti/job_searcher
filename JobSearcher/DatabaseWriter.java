package JobSearcher;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 * Writes the data into the JSON file
 * @author The Back Rowers
 */
public class DatabaseWriter extends DatabaseConstants{
    /**
     * Saves a company into the JSON database
     */
    public static void saveCompanies(){
        Companies companies = Companies.getInstance();
        ArrayList<Company> employers = companies.getCompanies();
        JSONArray jsonEmployers = new JSONArray();

        for(int i = 0; i<employers.size(); i++){
            jsonEmployers.add(getCompanyJSON(employers.get(i)));
        }

        try(FileWriter file = new FileWriter(COMPANIES_FILE)){
            file.write(jsonEmployers.toJSONString());
            file.flush();
            
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * Accesses the company JSON file
     * @param company The company that is being accessed
     * @return Returns the JSON database
     */
    public static JSONObject getCompanyJSON(Company company){
            JSONObject companiesDetails = new JSONObject();
            companiesDetails.put(COMPANIES_ID, company.getCompanyID());
            companiesDetails.put(COMPANIES_NAME, company.getName());
            companiesDetails.put(COMPANIES_LOCATION, company.getLocation());
            companiesDetails.put(COMPANIES_SECTOR, company.getSector());
            companiesDetails.put(COMPANIES_INDUSTRY, company.getIndustry());

        return companiesDetails;
    }
    /**
     * Saves the job into the JSON database
     */
    public static void saveJobs(){
        Jobs jobs = Jobs.getInstance();
        ArrayList<Job> jobOpportunity = jobs.getJobs();
        JSONArray jsonJobs = new JSONArray();

        for(int i = 0; i<jobOpportunity.size(); i++){
            jsonJobs.add(getJobsJSON(jobOpportunity.get(i)));
        }

        try(FileWriter file = new FileWriter(JOBS_FILE)){
            file.write(jsonJobs.toJSONString());
            file.flush();
            
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * Accesses job JSON file
     * @param job The job that is being accessed
     * @return Returns the JSON object
     */
    public static JSONObject getJobsJSON(Job job){
            JSONObject jobsDetails = new JSONObject();
            jobsDetails.put(JOBS_ID, job.getJobID());
            jobsDetails.put(JOBS_NAME, job.getName());
            jobsDetails.put(JOBS_COMPANY_ID, job.getCompany());
            jobsDetails.put(JOBS_EMPLOYER_ID, job.getEmployer());
            jobsDetails.put(JOBS_START_DATE, job.getStartDate());
            jobsDetails.put(JOBS_END_DATE, job.getEndDate());
            jobsDetails.put(JOBS_SALARY, job.getSalary());
            jobsDetails.put(JOBS_DESCRIPTION, job.getDescription());
            jobsDetails.put(JOBS_LOCATION, job.getLocation());
            jobsDetails.put(JOBS_REMOTE, job.getRemote());

        return jobsDetails;
    }
    /**
     * Saves the employers into the JSON database
     */
    public static void saveEmployers(){
        Users users = Users.getInstance();
        ArrayList<Employer> workers = users.getEmployers();
        JSONArray jsonUsers = new JSONArray();

        for(int i = 0; i<workers.size(); i++){
            jsonUsers.add(getEmployersJSON(workers.get(i)));
        }

        try(FileWriter file = new FileWriter(EMPLOYERS_FILE)){
            file.write(jsonUsers.toJSONString());
            file.flush();
            
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * Accesses employer JSON file
     * @param employer The employer that is being accessed
     * @return Returns the JSON object
     */
    public static JSONObject getEmployersJSON(Employer employer){
            JSONObject employersDetails = new JSONObject();
            employersDetails.put(EMPLOYERS_ID, employer.getEmployerID());
            employersDetails.put(EMPLOYERS_USERNAME, employer.getUsername());
            employersDetails.put(EMPLOYERS_PASSWORD, employer.getPassword());
            employersDetails.put(EMPLOYERS_FIRSTNAME, employer.getFirstName());
            employersDetails.put(EMPLOYERS_LASTNAME, employer.getLastName());
            employersDetails.put(EMPLOYERS_COMPANY_ID, employer.getCompany().getCompanyID());
            employersDetails.put(EMPLOYERS_COMPANY, employer.getCompany().getName());
            employersDetails.put(EMPLOYERS_PHONE_NUMBER, employer.getPhoneNumber());


        return employersDetails;
    }
    /**
     * Saves the students into the JSON database
     */
    public static void saveStudents(){
        Users users = Users.getInstance();
        ArrayList<Student> candidates = users.getStudents();
        JSONArray jsonUsers = new JSONArray();

        for(int i = 0; i<candidates.size(); i++){
            jsonUsers.add(getStudentsJSON(candidates.get(i)));
        }

        try(FileWriter file = new FileWriter(STUDENTS_FILE)){
            file.write(jsonUsers.toJSONString());
            file.flush();
            
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * Accesses student JSON file
     * @param student The student that is being accessed
     * @return Returns the JSON object
     */
    public static JSONObject getStudentsJSON(Student student){
            JSONObject studentsDetails = new JSONObject();
            JSONArray studentRatings = new JSONArray();
            JSONArray studentFavorites = new JSONArray();
            JSONArray studentExperiences = new JSONArray();
            for (int i = 0; i < student.getRatings().getRatings().size(); i++) {
                JSONObject rating = new JSONObject();
                rating.put(RATINGS, student.getRatings().getRatings().get(i));
                studentRatings.add(rating);
            }
            for (int i = 0; i < student.getFavorites().size(); i++) {
                JSONObject favorite = new JSONObject();
                favorite.put(FAVORITES_ID, student.getFavorites().get(i));
                studentFavorites.add(favorite);
            }
            for (int i = 0; i < student.getResume().getWorkExperience().size(); i++) {
                JSONObject experiences = new JSONObject();
                experiences.put(EXPERIENCES_TITLE, student.getResume().getWorkExperience().get(i).getTitle());
                experiences.put(EXPERIENCES_COMPANY, student.getResume().getWorkExperience().get(i).getCompany());
                experiences.put(EXPERIENCES_START, student.getResume().getWorkExperience().get(i).getStartDate());
                experiences.put(EXPERIENCES_END, student.getResume().getWorkExperience().get(i).getEndDate());
                experiences.put(EXPERIENCES_DESCRIPTION, student.getResume().getWorkExperience().get(i).getJobDescription());
                studentExperiences.add(experiences);
            }
            
            studentsDetails.put(STUDENTS_ID, student.getStudentId().toString());
            studentsDetails.put(STUDENTS_USERNAME, student.getUsername());
            studentsDetails.put(STUDENTS_PASSWORD, student.getPassword());
            studentsDetails.put(STUDENTS_FIRSTNAME, student.getFirstName());
            studentsDetails.put(STUDENTS_LASTNAME, student.getLastName());
            studentsDetails.put(STUDENTS_GPA, student.getGPA());
            studentsDetails.put(STUDENTS_EDU_ACCOUNT, student.getEduAccount());
            studentsDetails.put(STUDENTS_PHONE_NUMBER, student.getPhoneNumber());
            studentsDetails.put(STUDENTS_FAVORITES, student.getFavorites());
            studentsDetails.put(STUDENTS_EDUCATION, student.getResume().getEducation());
            studentsDetails.put(STUDENTS_ACHIEVEMENTS, student.getResume().getAchievements());
            studentsDetails.put(STUDENTS_SKILLS, student.getResume().getSkills());
            try {
                studentsDetails.put(STUDENTS_EXPERIENCE, studentExperiences);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            
            studentsDetails.put(STUDENTS_RATINGS, studentRatings);
            


        return studentsDetails;
    }
    /**
     * Saves the applications into the JSON database
     */
    public static void saveApplications(){
        Jobs jobs = Jobs.getInstance();
        ArrayList<Job> opportunity = jobs.getJobs();
        JSONArray studentID = new JSONArray();
        JSONArray Jobs = new JSONArray();
        JSONArray jsonApplications = new JSONArray();
        for(int i = 0; i<opportunity.size(); i++){
            for(int j = 0; j<opportunity.get(i).getApplications().size(); j++){
                jsonApplications.add(getApplicationsJSON(opportunity.get(i).getApplications().get(j)));
            }
        }
        try(FileWriter file = new FileWriter(APPLICATIONS_FILE)){
            file.write(jsonApplications.toJSONString());
            file.flush();
            
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * Accesses application JSON file
     * @param application The application that is being accessed
     * @return Returns the JSON object
     */
    public static JSONObject getApplicationsJSON(Application application){
            JSONObject applicationsDetails = new JSONObject();
            applicationsDetails.put(APPLICATIONS_ID, application.getApplicationID());
            applicationsDetails.put(APPLICATIONS_JOB_ID, application.getJob().getJobID());
            applicationsDetails.put(APPLICATIONS_STUDENT_ID, application.getStudent().getStudentId());
           
        return applicationsDetails;
    }
    /**
     * Saves the admins into the JSON database
     */
    public static void saveAdmins(){
        Users users = Users.getInstance();
        ArrayList<Admin> administrators = users.getAdmins();
        JSONArray jsonUsers = new JSONArray();

        for(int i = 0; i<administrators.size(); i++){
            jsonUsers.add(getAdministratorsJSON(administrators.get(i)));
        }

        try(FileWriter file = new FileWriter(ADMINS_FILE)){
            file.write(jsonUsers.toJSONString());
            file.flush();
            
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * Accesses admin JSON file
     * @param admin The admin that is being accessed
     * @return Returns the JSON object
     */
    public static JSONObject getAdministratorsJSON(Admin admin){
            JSONObject adminDetails = new JSONObject();
            adminDetails.put(ADMINS_ID, admin.getID());
            adminDetails.put(ADMINS_USERNAME, admin.getUsername());
            adminDetails.put(ADMINS_PASSWORD, admin.getPassword());

        return adminDetails;
    }
}
