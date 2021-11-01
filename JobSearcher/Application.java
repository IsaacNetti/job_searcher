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
      this.student.addApplication(this);
    }
    private void setJob(Job job2) {
      Jobs list = Jobs.getInstance();
<<<<<<< HEAD
      this.job = list.getJob(job2);
=======
      this.job = list.getJob(jobID);
      this.job.addApplication(this);
>>>>>>> c07865044d1ea3c12a3dbcf7904d3bfcfdca2a70
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
