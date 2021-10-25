package JobSearcher;
import java.util.ArrayList;
import java.util.UUID;

public class Student {
    private String name;
    private double gpa;
    private UUID studentId;
    private String eduAcc;
    private String phoneNumber;
    private ArrayList<Job> favorites;
    private Ratings ratings;

    public Student(){

    }
    public void setStudentId() {
        this.studentId = UUID.randomUUID();
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Ratings getRatings(){
        return this.ratings;
    }
    public UUID getStudentId() {
        return studentId;
    }
    public void apply(Job job, Student student){
        job.addApplicant(student);
    }
    public Resume createResume(){
        Resume studentsResume = new Resume();
        return studentsResume;
    }
    public void addRating(int rating, String review){
        
    }
}
