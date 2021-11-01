package JobSearcher;

public abstract class User {
    protected String username;
    protected String password;
    protected String typeOfUser;

    public User(){
    }
    public abstract void setUsername(String username);
    public abstract void setPassword(String password);
    public abstract void setType();

    public String getUsername(){
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    public String getType(){
        return this.typeOfUser;
    }
}
