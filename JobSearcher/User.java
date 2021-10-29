package JobSearcher;

public class User {
    protected String username;
    protected String password;
    protected String typeOfUser;

    public User(){
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
    public String getUsername(){
        return this.username;
    }
    public String getPassword() {
        return password;
    }
    public String getType(){
        return typeOfUser;
    }
}
