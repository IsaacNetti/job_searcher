package JobSearcher;
import java.util.ArrayList;

public class Users {
    private static Users users;
    private ArrayList<User> userList;

    public Users(){

    }
    public static void getInstance(){

    }
    public boolean haveUser(String username){
        return true;
    }
    public User getUser(String username){
        User result = new User();
        return result;
    }
}
