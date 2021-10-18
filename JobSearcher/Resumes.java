package JobSearcher;

import java.util.ArrayList;

public class Resumes {
    private static Resumes Resumes;
    private ArrayList<Resume> resumeList;

    public Resumes(){

    }
    public static void getInstance(){

    }
    public Resume getResume(Student student){
        Resume result = new Resume();
        return result;
    }
}
