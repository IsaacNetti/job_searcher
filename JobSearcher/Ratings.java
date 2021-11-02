package JobSearcher;
import java.util.ArrayList;

public class Ratings {
    private ArrayList<Integer> ratings;
    private double rating;

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
    public double getRating() {
        return rating;
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
