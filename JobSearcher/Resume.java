package JobSearcher;
import java.util.ArrayList;
/**
 * The resume class
 * @author The Back Rowers
 */
public class Resume {
    private Student user;
    private String skills;
    private ArrayList<Experience> workExperience;
    private String education;
    private String achievements;
    /**
     * The resume constructor
     */
    public Resume(){

    }
    /**
     * Sets the skills
     * @param skills The skills of the student
     */
    public void setSkills(String skills) {
        this.skills = skills;
    }
    /**
     * Sets the education
     * @param education The education of the student
     */
    public void setEducation(String education) {
        this.education = education;
    }
    /**
     * Sets the achievements
     * @param achievements The achievements of the student
     */
    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }
    /**
     * Sets the user
     * @param user The skills of the student
     */
    public void setUser(Student user) {
        this.user = user;
    }
    /**
     * Sets the work experience
     * @param workExperience The work experience of the student
     */
    public void setWorkExperience(ArrayList<Experience> workExperience){
        this.workExperience = workExperience;
    }
    /**
     * Adds the work experience
     * @param experience The experience of the student
     */
    public void addWorkExperience(Experience experience){
        workExperience.add(experience);
    }
    /**
     * Gets the skills
     * @return Returns the skills
     */
    public String getSkills() {
        return skills;
    }
    /**
     * Gets the work experience
     * @return Returns the work experience 
     */
    public ArrayList<Experience> getWorkExperience() {
        return workExperience;
    }
    /**
     * Gets the achievements
     * @return Returns the achievements
     */
    public String getAchievements() {
        return achievements;
    }
    /**
     * Gets the education
     * @return Returns the education
     */
    public String getEducation() {
        return education;
    }
    /**
     * Gets the user
     * @return Returns the user
     */
    public Student getUser() {
        return user;
    }
}
