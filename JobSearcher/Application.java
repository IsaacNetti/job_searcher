package JobSearcher;

import java.util.UUID;
/**
 * The application class
 * @author The Back Rowers
 */
public class Application {
    private UUID applicationID;  
    private Student student;
    private Job job;
    /**
     * The application constructor
     * @param studentID The UUID of the student
     * @param jobID The UUID of the job
     */
    public Application(UUID studentID, UUID jobID) {
      setStudent(studentID);
      setJob(jobID);
    }
    /**
     * Sets the application ID
     * @param applicationID The UUID of the application
     */
    public void setApplicationID(UUID applicationID) {
      this.applicationID = applicationID;
    }
    /**
     * Adds the application to list of students
     * @param studentID The UUID of the student
     */
    private void setStudent(UUID studentID) {
      Users list = Users.getInstance();
      this.student = list.getStudent(studentID);
      this.student.addApplication(this);
    }
    /**
     * Adds the application to the list of jobs
     * @param jobID The UUID of the job
     */
    private void setJob(UUID jobID) {
      Jobs list = Jobs.getInstance();
      this.job = list.getJob(jobID);
      this.job.addApplication(this);
    }
    /**
     * Gets the student
     * @return Returns student
     */
    public Student getStudent(){
        return student;
    }
    /**
     * Gets the job
     * @return Returns job
     */
    public Job getJob(){
        return job;
    }
    /**
     * Gets the application UUID
     * @return Returns UUID
     */
    public UUID getApplicationID(){
      return applicationID;
    }
    public String toString(){
      return student.getFirstName()+" "+student.getLastName()+"\nPhone number: "+student.getPhoneNumber()+"\nEmail: ."+student.getEduAccount();
    }
    public void acceptApplicant(){

    }

    public void rejectApplicant(){
        
    }
}
