package JobSearcher;
import java.util.UUID;
/**
 * This is the administrator class
 * @author The Back Rowers
 */
public class Admin extends User {
    private UUID id;
    /**
     * This is the admin constructor
     */
    public Admin(){

    }
    /**
     * Sets the ID of the admin
     * @param id The ID number of the admin
     */
    public void setID(UUID id) {
      this.id = id;
    }
    /**
     * Sets the username of the admin
     * @param username The username of the admin
     */
    public void setUsername(String username) {
      super.username = username;
    }
    /**
     * Sets the password of the admin
     * @param password The password of the admin
     */
    public void setPassword(String password) {
      super.password = password;
    }
    /**
     * Sets the type of user to admin
     */
    public void setType() {
      super.typeOfUser = "Admin";
    }
    /**
     * Gets the ID of the admin
     * @return The UUID of the admin
     */
    public UUID getID() {
      return this.id;
    }
    /**
     * Changes the username of a user
     * @param user User that's username will be changed
     * @param username The new username
     */
    public void setUsername(User user,String username){
        user.username = username;
    }
    /**
     * Changes the password of a user
     * @param user User that's password will be changed
     * @param password The new password
     */
    public void setPassword(User user, String password){
        user.password = password;
    }
    /**
     * Adds another admin
     * @param user The user that will be changed into an admin
     */
    public void addAdmin(User user){
        user.typeOfUser = "Admin";
    }
    /**
     * Removes an account
     * @param user The user that will be removed
     */
    public void removeAccount(User user){
        // remove user from json file
    }
}
