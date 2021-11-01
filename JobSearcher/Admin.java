package JobSearcher;
import java.util.UUID;
public class Admin extends User {
    private UUID id;
    public Admin(){

    }
    public void setID(UUID id) {
      this.id = id;
    }
    public void setUsername(String username) {
      super.username = username;
      
    }
    public void setPassword(String password) {
      super.password = password;
      
    }
    public void setType() {
      super.typeOfUser = "Admin";
      
    }
    public UUID getID() {
      return this.id;
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
