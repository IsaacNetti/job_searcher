package JobSearcher;

import java.util.ArrayList;
import java.util.UUID;

public class JobSystem {
    
    public JobSystem(){

    }
    public void createUser(String username, String password, String type){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setType(type);
    }
    public void createStudent(User user, String firstName, String lastName,String gpa,String eduAccount, String phoneNumber){
        Student student = new Student();
        UUID studentid = UUID.randomUUID();
        Ratings studentRatings = new Ratings();
        student.setUsername(user.getUsername());
        student.setPassword(user.getPassword());
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
    public void createEmployer(User user){

    }
    public void deleteUser(){

    }
    public void setAdmin(){

    }
    public void removeAdmin(){

    }
    public void createJob(){

    }
    public void removeJob(){

    }
    public void apply(){

    }
    public void rateUser(){

    }
    public void rejectApplicant(){

    }
    public void addExperience(){

    }
    public void searchJobs(){

    }
    public void searchCompany(){

    }
    public void displayApplicants(){
        
    }
}
