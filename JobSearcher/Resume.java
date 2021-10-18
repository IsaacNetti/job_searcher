package JobSearcher;
import java.util.ArrayList;

public class Resume {
    private Student user;
    private String skills;
    private ArrayList<Experience> workExperience;
    private String education;
    private String achievements;
    private String hobbies;
    
    public Resume(){

    }
    public void setSkills(String skills) {
        this.skills = skills;
    }
    public void setEducation(String education) {
        this.education = education;
    }
    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }
    public void setUser(Student user) {
        this.user = user;
    }
    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
    public void addWorkExperience(){

    }
    public String getSkills() {
        return skills;
    }
    public ArrayList<Experience> getWorkExperience() {
        return workExperience;
    }
    public String getAchievements() {
        return achievements;
    }
    public String getEducation() {
        return education;
    }
    public String getHobbies() {
        return hobbies;
    }
    public Student getUser() {
        return user;
    }
}
