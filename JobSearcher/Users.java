package JobSearcher;
import java.util.ArrayList;

public class Users {
    private static Users users;
    private ArrayList<User> userList;

    public Users(){
        userList = DatabaseLoader.loadResumes();
    }
    public static Users getInstance(){
        if (users == null) {
            users = new Users();
          }
          return users;
    }
    public boolean haveUser(String username){
        for (User c : userList) {
            if (c.getUsername() == username) {
              return true;
            }
          }
          return false;
    }
    public User getUser(String username){
        for (User c : userList) {
            if (c.getUsername() == username) {
              return c;
            }
          }
          System.out.println("User does not exist");
          return null;
    }
}
