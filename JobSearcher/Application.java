package JobSearcher;

import java.util.UUID;

public class Application {
    private UUID applicationID;  
    private Student student;
    private Job job;

    public Application(UUID studentID, UUID jobID) {
      setStudent(studentID);
      setJob(jobID);
    }
    public void setApplicationID(UUID applicationID) {
      this.applicationID = applicationID;
    }
    private void setStudent(UUID studentID) {
      Users list = Users.getInstance();
      this.student = list.getStudent(studentID);
      this.student.addApplication(this);
    }
    private void setJob(UUID jobID) {
      Jobs list = Jobs.getInstance();
      this.job = list.getJob(jobID);
      this.job.addApplication(this);
    }
    public Student getStudent(){
        return student;
    }

    public Job getJob(){
        return job;
    }
    public UUID getApplicationID(){
      return applicationID;
    }
    public void acceptApplicant(){

    }

    public void rejectApplicant(){
        
    }
}
