package JobSearcher;

public class Admin {
    
    public Admin(){

    }

    public void setUsername(User user,String username){
        user.username = username;
    }
    
    public void setPassword(User user, String password){
        user.password = password;
    }
    public void addAdmin(User user){
        user.typeOfUser = "Admin";
    }
    public void removeAccount(User user){
        // remove user from json file
    }
}
