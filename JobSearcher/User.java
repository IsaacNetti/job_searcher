package JobSearcher;
/**
 * The user class
 * @author The Back Rowers
 */
public abstract class User {
    protected String username;
    protected String password;
    protected String typeOfUser;
    /**
     * The user constructor
     */
    public User(){
    }
    /**
     * Sets the username
     * @param username The username of the user
     */
    public abstract void setUsername(String username);
    /**
     * Sets the password
     * @param password The password of the user
     */
    public abstract void setPassword(String password);
    /**
     * Sets the type
     * @param type The username of the type
     */
    public abstract void setType();
    /**
     * Gets the username
     * @return Returns the username
     */
    public String getUsername(){
        return this.username;
    }
    /**
     * Gets the password
     * @return Returns the password
     */
    public String getPassword() {
        return this.password;
    }
    /**
     * Gets the type
     * @return Returns the type of user
     */
    public String getType(){
        return this.typeOfUser;
    }
}
