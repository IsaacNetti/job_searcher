package JobSearcher;
import java.util.ArrayList;

public class Resume {
    private Student user;
    private String skills;
    private ArrayList<Experience> workExperience;
    private String education;
    private String achievements;

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
    public void setWorkExperience(ArrayList<Experience> workExperience){
        this.workExperience = workExperience;
    }
    public void addWorkExperience(Experience experience){
        workExperience.add(experience);
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
    public Student getUser() {
        return user;
    }
}
