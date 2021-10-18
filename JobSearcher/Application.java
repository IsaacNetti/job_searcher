package JobSearcher;

public class Application {
    private Student student;
    private Resume resume;

    public Application(Student student, Resume resume){
        this.student = student;
        this.resume = resume;
    }

    public Student getStudent(){
        return student;
    }

    public Resume getResume(){
        return resume;
    }

    public void acceptApplicant(){

    }

    public void rejectApplicant(){
        
    }
}
