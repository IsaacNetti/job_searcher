package JobSearcher;

import java.util.UUID;

public class Application {
    private UUID applicationID;  
    private Student student;
    private Job job;

    public Application(UUID studentID, Job jobID) {
      setStudent(studentID);
      setJob(jobID);
    }
    public void setApplicationID(UUID applicationID) {
      this.applicationID = applicationID;
    }
    private void setStudent(UUID studentID) {
      Users list = Users.getInstance();
      this.student = list.getStudent(studentID);
    }
    private void setJob(Job job2) {
      Jobs list = Jobs.getInstance();
      this.job = list.getJob(job2);
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
      if((getStudent().equals(student)) && (getApplicationID().equals(applicationID)) && (getJob().equals(job)))
      return;
    }

    public void rejectApplicant(){
      if((!getStudent().equals(student)) && (!getApplicationID().equals(applicationID)) && (!getJob().equals(job)))
      return;
        
    }
}
