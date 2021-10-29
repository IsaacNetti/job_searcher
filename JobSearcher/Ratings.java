package JobSearcher;
import java.util.ArrayList;
import java.util.UUID;

public class Ratings {
    private ArrayList<Integer> ratings;
    private int rating;
    private Student student;

    public Ratings(){

    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }
    public int getRating() {
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
    public Double getAverageRating(){
    double sumRatings = 0.0;
    double numRatings = 0.0;
    return sumRatings / numRatings;
    }
}
