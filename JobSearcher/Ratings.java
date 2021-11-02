package JobSearcher;
import java.util.ArrayList;
import java.util.UUID;
/**
 * The ratings class
 * @author The Back Rowers
 */
    
    
public class Ratings {
    private ArrayList<Integer> ratings;
    private double rating;
    /**
     * The ratings constructor
     */
    public Ratings(){
      ratings = new ArrayList<>();
    }
    /**
     * Sets the rating to the average rating of the student
     */
    public void setRating() {
        this.rating = getAverageRating();
    }
    /**
     * Sets the rating 
     * @param ratings
     */
    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
        setRating();
    }
    /**
     * Sets the student UUID
     * @param studentID The UUID of the student
     */
    public void setStudent(UUID studentID) {
        Users list = Users.getInstance();
        this.student = list.getStudent(studentID);
    }
    /**
     * Gets the rating
     * @return Returns the rating of the student
     */
    public double getRating() {
        return rating;
    }
    /**
     * Gets the student
     * @return Returns the student
     */
    public Student getStudent() {
        return student;
    }
    /**
     * Gets the rating
     * @return Returns the list of ratings
     */
    public double getRating() {
        return rating;
    }
    public ArrayList<Integer> getRatings() {
        return ratings;
    }
    /**
     * Adds a rating
     * @param rating The rating that is being added
     */
    public void addRating(int rating){
        ratings.add(rating);
    }
    /**
     * Calculates the average rating
     * @return Returns the average rating of a student
     */
    public double getAverageRating(){
      double sumRatings = 0.0;
      for (int i = 0; i < ratings.size(); i++) {
        sumRatings += ratings.get(i);
      }
      int numRatings = ratings.size();
      return sumRatings / numRatings;
    }
}
