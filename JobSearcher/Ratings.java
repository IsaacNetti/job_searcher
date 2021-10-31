package JobSearcher;
import java.util.ArrayList;
import java.util.UUID;

public class Ratings {
    private ArrayList<Integer> ratings;
    private double rating;
    private Student student;

    public Ratings(){
      ratings = new ArrayList<>();
    }
    public void setRating() {
        this.rating = getAverageRating();
    }
    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
        setRating();
    }
    public void setStudent(UUID studentID) {
        Users list = Users.getInstance();
        this.student = list.getStudent(studentID);
    }
    public double getRating() {
        return rating;
    }
    public Student getStudent() {
        return student;
    }
    public ArrayList<Integer> getRatings() {
        return ratings;
    }
    public void addRating(int rating){
        ratings.add(rating);
    }
    public double getAverageRating(){
      double sumRatings = 0.0;
      for (int i = 0; i < ratings.size(); i++) {
        sumRatings += ratings.get(i);
      }
      int numRatings = ratings.size();
      return sumRatings / numRatings;
    }
}
