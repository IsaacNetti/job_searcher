package JobSearcher;

public class User {
    protected String username;
    protected String password;
    protected String typeOfUser;

    public User(String username, String password, String type){
        setUsername(username);
        setType(type);
        setPassword(password);
        // When called write user to json
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setType(String type){
        this.typeOfUser = type;
    }
    public String getUsername() {
        return username;
    }
}
