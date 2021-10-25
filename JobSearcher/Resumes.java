package JobSearcher;

import java.util.ArrayList;
import java.util.UUID;

public class Resumes {
    private static Resumes resumes;
    private ArrayList<Resume> resumeList;

    public Resumes(){
        resumeList = DatabaseLoader.loadResumes();
    }
    public static Resumes getInstance(){
        if (resumes == null) {
            resumes = new Resumes();
          }
          return resumes;
    }
    public Resume getResume(UUID studentID){
        for (Resume c : resumeList) {
            if (c.getUser().getStudentId() == studentID) {
              return c;
            }
          }
          System.out.println("Resume does not exist");
          return null;
    }
}
